package cstaudigel.masterlock;


import org.junit.Before;
import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;
/**
 * Created by chris staudigel on 1/31/17.
 */
public class MasterLockTest {

    /**
     * theoretically,
     * if random numbers pass 20 times, every time it runs it has to work, right?
     * <p>
     * randomly generates 3 values for each x, y, and z.
     * <p>
     * Tests those values
     */
    @Before
    public void generateTest() {
        Random r = new Random();
        int x = r.nextInt(MasterLockImpl.MAXNUMBER + 1);
        int y = r.nextInt(MasterLockImpl.MAXNUMBER + 1);
        int z = r.nextInt(MasterLockImpl.MAXNUMBER + 1);

        MasterLockImpl m = new MasterLockImpl(x, y, z);
        m.unlock(x, y, z);
        assertEquals(true, m.pullLock());
    }

    /**
     * generates random numbers as before, but locks, and re tests same numbers
     */
    @Before
    public void generateDoubleTest() {
        Random r = new Random();
        boolean unlocked = false;

        int x = r.nextInt(MasterLockImpl.MAXNUMBER+1);
        int y = r.nextInt(MasterLockImpl.MAXNUMBER+1);
        int z = r.nextInt(MasterLockImpl.MAXNUMBER+1);
        MasterLockImpl m = new MasterLockImpl(x, y, z);
        m.unlock(x, y, z);

        unlocked = m.pullLock();

        if(unlocked) {
            m.closeLock();
            m.unlock(x,y,z);
            unlocked = m.pullLock();
        }

        assertEquals(true, unlocked);
    }

    @Test
    public void randomCombo1() { generateTest(); }

    @Test
    public void randomCombo2() { generateTest(); }

    @Test
    public void randomCombo3() { generateTest(); }

    @Test
    public void randomCombo4() { generateTest(); }

    @Test
    public void randomCombo5() { generateTest(); }

    @Test
    public void randomCombo6() { generateTest(); }

    @Test
    public void randomCombo7() { generateTest(); }

    @Test
    public void randomCombo8() { generateTest(); }

    @Test
    public void randomCombo9() { generateTest(); }

    @Test
    public void randomCombo10() { generateTest(); }

    @Test
    public void randomDoubleCombo1() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo2() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo3() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo4() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo5() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo6() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo7() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo8() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo9() { generateDoubleTest(); }

    @Test
    public void randomDoubleCombo10() { generateDoubleTest(); }

}