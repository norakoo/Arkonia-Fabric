package net.norako.arkonia.entity.custom.overworld.illagers;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.NoPenaltyTargeting;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.raid.Raid;
import net.minecraft.world.*;
import net.minecraft.world.poi.PointOfInterestStorage;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.norako.arkonia.sound.ArkoniaSounds;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.*;
import java.util.function.Predicate;

public class MountaineerEntity extends RaiderEntity implements GeoEntity {
    static final Predicate<Difficulty> DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE = (difficulty) -> {
        return difficulty == Difficulty.NORMAL || difficulty == Difficulty.HARD;
    };
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public MountaineerEntity(EntityType<? extends RaiderEntity> entityType, World world) {
        super(entityType, world);
    }

    private void equipInitialGear() {
        ItemStack itemStack = new ItemStack(Items.IRON_PICKAXE);

        this.equipStack(EquipmentSlot.MAINHAND, itemStack);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return RaiderEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 9.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3499999940395355f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0);
    }

    @Override
    public void addBonusForWave(int wave, boolean unused) {
        ItemStack itemStack = new ItemStack(Items.IRON_PICKAXE);
        Raid raid = this.getRaid();
        int i = 1;
        if (wave > raid.getMaxWaves(Difficulty.NORMAL)) {
            i = 2;
        }

        boolean bl = this.random.nextFloat() <= raid.getEnchantmentChance();
        if (bl) {
            Map<Enchantment, Integer> map = Maps.newHashMap();
            map.put(Enchantments.SHARPNESS, Integer.valueOf(i));
            EnchantmentHelper.set(map, itemStack);
        }

        this.equipStack(EquipmentSlot.MAINHAND, itemStack);
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MountaineerEntity.BreakDoorGoal(this));
        this.goalSelector.add(4, new MountaineerEntity.AttackGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, MerchantEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal(this, IronGolemEntity.class, true));
        this.goalSelector.add(8, new WanderAroundGoal(this, 0.6));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
        this.goalSelector.add(1, new PickupBannerAsLeaderGoal(this));
        this.goalSelector.add(3, new MoveToRaidCenterGoal(this));
        this.goalSelector.add(4, new AttackHomeGoal(this, 1.0499999523162842, 1));
        this.goalSelector.add(5, new CelebrateGoal(this));
    }

    class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(MountaineerEntity mountaineer) {
            super(mountaineer, 1.0, false);
        }

        protected double getSquaredMaxAttackDistance(LivingEntity entity) {
            if (this.mob.getVehicle() instanceof RavagerEntity) {
                float f = this.mob.getVehicle().getWidth() - 0.1F;
                return (double)(f * 2.0F * f * 2.0F + entity.getWidth());
            } else {
                return super.getSquaredMaxAttackDistance(entity);
            }
        }
    }

    static class AttackHomeGoal extends Goal {
        private final MountaineerEntity raider;
        private final double speed;
        private BlockPos home;
        private final List<BlockPos> lastHomes = Lists.newArrayList();
        private final int distance;
        private boolean finished;

        public AttackHomeGoal(MountaineerEntity raider, double speed, int distance) {
            this.raider = raider;
            this.speed = speed;
            this.distance = distance;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            this.purgeMemory();
            return this.isRaiding() && this.tryFindHome() && this.raider.getTarget() == null;
        }

        private boolean isRaiding() {
            return this.raider.hasActiveRaid() && !this.raider.getRaid().isFinished();
        }

        private boolean tryFindHome() {
            ServerWorld serverWorld = (ServerWorld)this.raider.getWorld();
            BlockPos blockPos = this.raider.getBlockPos();
            Optional<BlockPos> optional = serverWorld.getPointOfInterestStorage().getPosition((registryEntry) -> {
                return registryEntry.matchesKey(PointOfInterestTypes.HOME);
            }, this::canLootHome, PointOfInterestStorage.OccupationStatus.ANY, blockPos, 48, this.raider.random);
            if (!optional.isPresent()) {
                return false;
            } else {
                this.home = ((BlockPos)optional.get()).toImmutable();
                return true;
            }
        }

        public boolean shouldContinue() {
            if (this.raider.getNavigation().isIdle()) {
                return false;
            } else {
                return this.raider.getTarget() == null && !this.home.isWithinDistance(this.raider.getPos(), (double)(this.raider.getWidth() + (float)this.distance)) && !this.finished;
            }
        }

        public void stop() {
            if (this.home.isWithinDistance(this.raider.getPos(), (double)this.distance)) {
                this.lastHomes.add(this.home);
            }

        }

        public void start() {
            super.start();
            this.raider.setDespawnCounter(0);
            this.raider.getNavigation().startMovingTo((double)this.home.getX(), (double)this.home.getY(), (double)this.home.getZ(), this.speed);
            this.finished = false;
        }

        public void tick() {
            if (this.raider.getNavigation().isIdle()) {
                Vec3d vec3d = Vec3d.ofBottomCenter(this.home);
                Vec3d vec3d2 = NoPenaltyTargeting.findTo(this.raider, 16, 7, vec3d, 0.3141592741012573);
                if (vec3d2 == null) {
                    vec3d2 = NoPenaltyTargeting.findTo(this.raider, 8, 7, vec3d, 1.5707963705062866);
                }

                if (vec3d2 == null) {
                    this.finished = true;
                    return;
                }

                this.raider.getNavigation().startMovingTo(vec3d2.x, vec3d2.y, vec3d2.z, this.speed);
            }

        }

        private boolean canLootHome(BlockPos pos) {
            Iterator var2 = this.lastHomes.iterator();

            BlockPos blockPos;
            do {
                if (!var2.hasNext()) {
                    return true;
                }

                blockPos = (BlockPos)var2.next();
            } while(!Objects.equals(pos, blockPos));

            return false;
        }

        private void purgeMemory() {
            if (this.lastHomes.size() > 2) {
                this.lastHomes.remove(0);
            }

        }
    }

    static class BreakDoorGoal extends net.minecraft.entity.ai.goal.BreakDoorGoal {
        public BreakDoorGoal(MobEntity mobEntity) {
            super(mobEntity, 6, MountaineerEntity.DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE);
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean shouldContinue() {
            MountaineerEntity mountaineerEntity = (MountaineerEntity)this.mob;
            return mountaineerEntity.hasActiveRaid() && super.shouldContinue();
        }

        public boolean canStart() {
            MountaineerEntity mountaineerEntity = (MountaineerEntity)this.mob;
            return mountaineerEntity.hasActiveRaid() && mountaineerEntity.random.nextInt(toGoalTicks(10)) == 0 && super.canStart();
        }

        public void start() {
            super.start();
            this.mob.setDespawnCounter(0);
        }
    }

    public class CelebrateGoal extends Goal {
        private final MountaineerEntity raider;

        CelebrateGoal(MountaineerEntity raider) {
            this.raider = raider;
            this.setControls(EnumSet.of(Control.MOVE));
        }

        public boolean canStart() {
            Raid raid = this.raider.getRaid();
            return this.raider.isAlive() && this.raider.getTarget() == null && raid != null && raid.hasLost();
        }

        public void start() {
            this.raider.setCelebrating(true);
            super.start();
        }

        public void stop() {
            this.raider.setCelebrating(false);
            super.stop();
        }

        public void tick() {
            if (!this.raider.isSilent() && this.raider.random.nextInt(this.getTickCount(100)) == 0) {
                MountaineerEntity.this.playSound(MountaineerEntity.this.getCelebratingSound(), MountaineerEntity.this.getSoundVolume(), MountaineerEntity.this.getSoundPitch());
            }

            if (!this.raider.hasVehicle() && this.raider.random.nextInt(this.getTickCount(50)) == 0) {
                this.raider.getJumpControl().setActive();
            }

            super.tick();
        }
    }

    @Override
    public SoundEvent getCelebratingSound() {
        return SoundEvents.ENTITY_VINDICATOR_CELEBRATE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ArkoniaSounds.MOUNTAINEER_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ArkoniaSounds.MOUNTAINEER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ArkoniaSounds.MOUNTAINEER_DEATH;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllers.add(new AnimationController<>(this, "attackController", 0, this::attackPredicate));
    }

    private PlayState attackPredicate(AnimationState<MountaineerEntity> mountaineerEntityAnimationState) {
        if(this.handSwinging && mountaineerEntityAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            mountaineerEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.mountaineer.right.attack_fast", Animation.LoopType.DEFAULT));
            this.handSwinging = false;
        }

        return PlayState.CONTINUE;
    }

    private PlayState predicate(AnimationState<MountaineerEntity> mountaineerEntityAnimationState) {
        if(mountaineerEntityAnimationState.isMoving()) {
            mountaineerEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.mountaineer.right.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        } else {
            if (this.isCelebrating()) {
                mountaineerEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.mountaineer.celebrate", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            } else {
                mountaineerEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.mountaineer.idle", Animation.LoopType.LOOP));
            }
        }

        mountaineerEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.mountaineer.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
