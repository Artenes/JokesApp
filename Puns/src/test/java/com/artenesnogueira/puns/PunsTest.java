package com.artenesnogueira.puns;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class PunsTest {

    private Puns puns;

    @Before
    public void setUp() {
        puns = new Puns();
    }

    @Test
    public void returns_a_valid_pun() {
        //stress test to see if it breaks
        for (int times = 1; times <= 1000; times++) {
            String pun = puns.getPun();
            assertNotNull(pun);
            assertTrue(pun.length() > 0);
        }
    }

    @Test
    public void do_not_return_same_pun_all_the_time() {
        String[] puns = new String[10];
        //create array of puns
        for (int index = 0; index < 10; index++) {
            puns[index] = this.puns.getPun();
        }
        //and check if all of them are the same
        String pun = puns[0];
        for (int index = 1; index < 10; index++) {
            //if there is at least one different
            //the array is not composed of the same element
            if (!pun.equals(puns[index])) {
                return;
            }
        }
        fail("All generated puns are the same");
    }

}