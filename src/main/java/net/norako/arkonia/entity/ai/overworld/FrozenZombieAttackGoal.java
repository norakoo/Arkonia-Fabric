package net.norako.arkonia.entity.ai.overworld;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.norako.arkonia.entity.custom.overworld.FrozenZombieEntity;

public class FrozenZombieAttackGoal extends MeleeAttackGoal {
    private final FrozenZombieEntity frozenzombie;
    private int ticks;

    public FrozenZombieAttackGoal(FrozenZombieEntity frozenzombie, double speed, boolean pauseWhenMobIdle) {
        super(frozenzombie, speed, pauseWhenMobIdle);
        this.frozenzombie = frozenzombie;
    }

    public void start() {
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.frozenzombie.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.frozenzombie.setAttacking(true);
        } else {
            this.frozenzombie.setAttacking(false);
        }

    }
}
