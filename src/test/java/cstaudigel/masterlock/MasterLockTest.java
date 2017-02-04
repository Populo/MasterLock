package cstaudigel.masterlock;


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
    public void generateTest() {
        Random r = new Random();
        int x = r.nextInt(MasterLockImpl.MAXNUMBER + 1);
        int y = r.nextInt(MasterLockImpl.MAXNUMBER + 1);
        int z = r.nextInt(MasterLockImpl.MAXNUMBER + 1);

        MasterLockImpl m = new MasterLockImpl(x, y, z);
        m.unlock(x, y, z);
        assertEquals(true, m.pullLock());
    }

    @Test
    public void randomCombo1() {
        generateTest();
    }

    @Test
    public void randomCombo2() {
        generateTest();
    }

    @Test
    public void randomCombo3() {
        generateTest();
    }

    @Test
    public void randomCombo4() {
        generateTest();
    }

    @Test
    public void randomCombo5() {
        generateTest();
    }

    @Test
    public void randomCombo6() {
        generateTest();
    }

    @Test
    public void randomCombo7() {
        generateTest();
    }

    @Test
    public void randomCombo8() {
        generateTest();
    }

    @Test
    public void randomCombo9() {
        generateTest();
    }

    @Test
    public void randomCombo10() {
        generateTest();
    }
}