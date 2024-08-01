package net.norako.arkonia.entity.ai.overworld.zombies;

import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.norako.arkonia.entity.custom.overworld.zombies.JungleZombieEntity;

public class JungleZombieAttackGoal extends MeleeAttackGoal {
    private final JungleZombieEntity JungleZombie;
    private int ticks;

    public JungleZombieAttackGoal(JungleZombieEntity JungleZombie, double speed, boolean pauseWhenMobIdle) {
        super(JungleZombie, speed, pauseWhenMobIdle);
        this.JungleZombie = JungleZombie;
    }

    public void start() {
        super.start();
        this.ticks = 0;
    }

    public void stop() {
        super.stop();
        this.JungleZombie.setAttacking(false);
    }

    public void tick() {
        super.tick();
        ++this.ticks;
        if (this.ticks >= 5 && this.getCooldown() < this.getMaxCooldown() / 2) {
            this.JungleZombie.setAttacking(true);
        } else {
            this.JungleZombie.setAttacking(false);
        }

    }
}