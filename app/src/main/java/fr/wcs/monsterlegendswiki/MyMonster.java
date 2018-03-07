package fr.wcs.monsterlegendswiki;

/**
 * Created by wilder on 07/03/18.
 */

public class MyMonster {

    int mLevel;
    int mPower;
    int mLife;
    int mSpeed;
    int mStamina;

    public MyMonster (int level, int power, int life, int speed, int stamina) {
        mLevel = level;
        mPower = power;
        mLife = life;
        mSpeed = speed;
        mStamina = stamina;
    }

    public int getmLevel() {
        return mLevel;
    }

    public int getmPower() {
        return mPower;
    }

    public int getmLife() {
        return mLife;
    }

    public int getmSpeed() {
        return mSpeed;
    }

    public int getmStamina() {
        return mStamina;
    }

    public void evolution(int niveau){
        mLevel = niveau;
        int bonus1 = 22 * (niveau - 1);
        mPower = 242 + bonus1;
        int bonus2 = 11 * (niveau - 1);
        mLife = 81 + bonus2;
        int bonus3 = 17 * (niveau - 1);
        mSpeed = 192 + bonus3;
        mStamina = 100;

    }
}
