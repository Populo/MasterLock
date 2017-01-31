package cstaudigel.masterlock;


import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by chris on 1/31/17.
 */
public class MasterLockTest {

    @Test
    public void combo1() {
        MasterLockImpl m = new MasterLockImpl(10, 26, 4);
        m.unlock(10, 26, 4);
        assertEquals(true, m.pullLock());
    }
}
