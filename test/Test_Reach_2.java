

import org.junit.*;
import static org.junit.Assert.*;
import cpsc331.assignment1.City;
import cpsc331.assignment1.Reachable;

/*
 *
 * Test suite to check the access function of "Reachable"
 *
 * Requires JUnit 4.x
 *
 */

public class Test_Reach_2 {

    City testCity() {

        City C = new City(1, 1);
        C.addEast(0, 0);
        return C;

    }


    @Test
    public void Test_0_0 () {

        try {

            City C = testCity();
            boolean result = Reachable.access(C, 0, 0);
            assertTrue("Incorrect input for inputs 0, 0.", result);

        } catch (IllegalArgumentException ex) {

            assertTrue("Exception thrown for inputs 0, 0.", true);

        }

    }

    @Test
    public void Test_0_1 () {

        try {

            City C = testCity();
            boolean result = Reachable.access(C, 0, 1);
            assertTrue("Incorrect input for inputs 0, 1.", !result);

        } catch (IllegalArgumentException ex) {

            assertTrue("Exception thrown for inputs 0, 1.", true);

        }

    }

    @Test
    public void Test_1_0 () {

        try {

            City C = testCity();
            boolean result = Reachable.access(C, 1, 0);
            assertTrue("Incorrect input for inputs 1, 0.", result);

        } catch (IllegalArgumentException ex) {

            assertTrue("Exception thrown for inputs 1, 0.", true);

        }

    }

    @Test
    public void Test_1_1 () {

        try {

            City C = testCity();
            boolean result = Reachable.access(C, 1, 1);
            assertTrue("Incorrect input for inputs 1, 1.", !result);

        } catch (IllegalArgumentException ex) {

            assertTrue("Exception thrown for inputs 1, 1.", true);

        }

    }

}