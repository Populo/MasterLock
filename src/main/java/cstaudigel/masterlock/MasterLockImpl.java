package cstaudigel.masterlock;

import java.util.Random;

/**
 * Created by chris on 1/31/17.
 */
public class MasterLockImpl implements MasterLock {

    private int topNumber;
    public static final int MAXNUMBER = 39;
    private int x, y, z;
    private boolean isLocked;

    private boolean num1, num2, num3;

    public MasterLockImpl(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.topNumber = 0;

        this.isLocked = true;

        this.num1 = false;
        this.num2 = false;
        this.num3 = false;
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

        topNumber = topNumber + (amount*multiplier);

        if (topNumber > MAXNUMBER) topNumber = topNumber - MAXNUMBER;
        else if (topNumber < 0) topNumber = MAXNUMBER - topNumber;
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
        turn(true, MAXNUMBER - x);

        if (topNumber == this.x) num1 = true;

        // second number
        // revolution
        turn(false, MAXNUMBER);
        // to 0
        turn(false, x);
        // to second number
        turn(false, (MAXNUMBER+1) - y);

        if (topNumber == this.y) num2 = true;

        // third number
        // back to 0
        // TODO doesnt need to go to 0, what if third # is before 0
        turn(true, y);
        // to 3rd number
        turn(true, z);

        if (topNumber == this.z) num3 = true;
    }

    @Override
    public boolean pullLock() {
        return num1 && num2 && num3;
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
     * closes the lock
     */
    @Override
    public void closeLock() {
        Random rand = new Random();
        topNumber = rand.nextInt(MAXNUMBER+1);
        isLocked = true;
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
