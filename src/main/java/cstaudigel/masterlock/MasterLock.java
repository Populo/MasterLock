package cstaudigel.masterlock;

/**
 * Created by chris staudigel on 1/31/17.
 */
public interface MasterLock {

    /**
     * method to turn lock
     * @param clockwise to tell program which way to turn
     * @param amount to tell program how far to turn
     */
    void turn(boolean clockwise, int amount);

    /**
     *  inputs given values into the lock
     *
     * @param x first entry
     * @param y second entry
     * @param z third entry
     *
     */
    void unlock(int x, int y, int z);

    /**
     * tries to open the lock
     *
     * @return whether the lock opened
     */
    boolean pullLock();
    /**
     *
     * @param x first entry
     * @param y second entry
     * @param z third entry
     */
    void resetCode(int x, int y, int z);

    /**
     * closes the lock
     */
    void closeLock();

    /**
     * checks the lock status of the lock
     */
    boolean checkStatus();

    /**
     *
     * @return number at top of lock
     */
    int getCurrentNumber();
}
