package cstaudigel.masterlock;

import java.util.Random;

/**
 * Created by chris on 1/31/17.
 */
public class MasterLockImpl implements MasterLock {

    private int topNumber;
    public static final int MAXNUMBER = 39;
    private int x, y, z;
    private int num1, num2, num3;
    private boolean isLocked;

    private boolean num1b, num2b, num3b;

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

        topNumber = topNumber + (amount*multiplier);

        if (topNumber > MAXNUMBER) topNumber = topNumber - (MAXNUMBER);
        else if (topNumber < 0) topNumber = (MAXNUMBER) + topNumber;
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
        // reset number to 0
        if (topNumber > ((MAXNUMBER+1)/2)) turn(true, MAXNUMBER+1 - topNumber);
        else if (topNumber < ((MAXNUMBER+1)/2)) turn(false, topNumber);


        // first input
        // revolution 1
        turn(true, MAXNUMBER);
        // revolution 2
        turn(true, MAXNUMBER);
        // to first number
        if (x != MAXNUMBER) turn(true, MAXNUMBER - x);
        else turn(true, -MAXNUMBER);

        num1 = topNumber;
        if (topNumber == this.x) num1b = true;

        // second number
        // revolution
        turn(false, MAXNUMBER);
        // to 0
        turn(false, -x);
        // to second number
        turn(false, y);

        num2 = topNumber;

        if (topNumber == this.y) num2b = true;

        // third number
        // back to 0
        turn(true, y);
        // to 3rd number
        turn(true, -z);

        num3 = topNumber;

        if (topNumber == this.z) num3b = true;
    }

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
     * closes the lock
     */
    @Override
    public void closeLock() {
        if (!isLocked) {
            Random rand = new Random();
            topNumber = rand.nextInt(MAXNUMBER+1);
            isLocked = true;
        } else {
            return;
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
