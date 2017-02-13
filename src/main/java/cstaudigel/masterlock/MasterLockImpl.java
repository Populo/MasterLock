package cstaudigel.masterlock;

import java.util.Random;

/**
 * Created by chris staudigel on 1/31/17.
 */
public class MasterLockImpl implements MasterLock {

    private int topNumber;
    public static final int MAXNUMBER = 39;
    private int x, y, z;
    private int num1, num2, num3;
    private boolean isLocked;

    private boolean num1b, num2b, num3b;

    /**
     * constructor that sets combination
     */
    public MasterLockImpl(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.topNumber = 0;

        this.isLocked = true;

        this.num1b = false;
        this.num2b = false;
        this.num3b = false;
    }


    /**
     * method to turn lock
     *
     * @param clockwise to tell program which way to turn
     * @param amount    to tell program how far to turn
     */
    @Override
    public void turn(boolean clockwise, int amount) {
        // easier math, multiply amount by multiplier (1 or -1) to decide direction
        int multiplier = clockwise ? -1 : 1;

        topNumber = getCurrentNumber() + (amount*multiplier);

        if (getCurrentNumber() > MAXNUMBER) topNumber = getCurrentNumber() - (MAXNUMBER);
        else if (getCurrentNumber() < 0) topNumber = (MAXNUMBER) + getCurrentNumber();
    }

    /**
     * tries to unlock the lock with the given values
     *
     * @param x first entry
     * @param y second entry
     * @param z third entry
     * @return whether the lock can successfully unlock
     */
    @Override
    public void unlock(int x, int y, int z) {
        // first input
        // revolution 1
        turn(true, MAXNUMBER);
        // revolution 2
        turn(true, MAXNUMBER);
        // to first number
        // first number == MAXNUMBER caused errors
        if (x != MAXNUMBER) turn(true, MAXNUMBER - x);
        else turn(true, -MAXNUMBER);

        num1 = getCurrentNumber();
        if (getCurrentNumber() == this.x) num1b = true;

        // second number
        // revolution
        turn(false, MAXNUMBER);
        // to 0
        turn(false, -x);
        // to second number
        turn(false, y);

        num2 = getCurrentNumber();

        if (getCurrentNumber() == this.y) num2b = true;

        // third number
        // back to 0
        turn(true, y);
        // to 3rd number
        turn(true, -z);

        num3 = getCurrentNumber();

        if (getCurrentNumber() == this.z) num3b = true;
    }

    /**
     * pullLock
     * 
     * returns true if and only if all 3 numbers were correct
     */
    @Override
    public boolean pullLock() {
        return num1b && num2b && num3b;
    }

    /**
     * @param x first entry
     * @param y second entry
     * @param z third entry
     */
    @Override
    public void resetCode(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * closes the lock and resets top number
     */
    @Override
    public void closeLock() {
        if (!checkStatus()) {
            Random rand = new Random();
            topNumber = rand.nextInt(MAXNUMBER+1);
            isLocked = true;

            num1 = 0;
            num2 = 0;
            num3 = 0;

            num1b = false;
            num2b = false;
            num3b = false;
        }
    }

    /**
     * checks the lock status of the lock
     */
    @Override
    public boolean checkStatus() {
        return isLocked;
    }

    /**
     * @return number at top of lock
     */
    @Override
    public int getCurrentNumber() {
        return topNumber;
    }
}
