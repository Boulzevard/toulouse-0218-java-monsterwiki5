package fr.wcs.monsterlegendswiki;

/**
 * Created by wilder on 07/03/18.
 */

public class MonsterModel {

    private int level;
    private int power;
    private int life;
    private int speed;
    private int stamina;

    public MonsterModel(int level, int power, int life, int speed, int stamina) {
        this.level = level;
        this.power = power;
        this.life = life;
        this.speed = speed;
        this.stamina = stamina;
    }

    public int getLevel() {
        return level;
    }

    public int getPower() {
        return power;
    }

    public int getLife() {
        return life;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStamina() {
        return stamina;
    }

    public void evolution(int level) {
        this.level = level;
        int bonus1 = 22 * (level - 1);
        this.power = 242 + bonus1;
        int bonus2 = 11 * (level - 1);
        this.life = 81 + bonus2;
        int bonus3 = 17 * (level - 1);
        this.speed = 192 + bonus3;
        this.stamina = 100;
    }
}
