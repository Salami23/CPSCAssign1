/* Joanne Millard UCID:30117800
   Farhan Salam UCID: 30096686
*/
package cpsc331.assignment1;

import cpsc331.assignment1.City;

import java.util.Arrays;
import cpsc331.assignment1.City;

/*
 *
 * Provides a function to decide whether a given location in a given city
 * can be reached by travelling north and east
 *
 */

public class Reachable {
    /*
     *
     * Function to determine whether a given location in a given city can
     * be reached by travelling north and east
     *
     * Precondition: A city c and integers i and j are given as input
     *
     * Postcondition: If 0 <= i <= w and 0 <= j <= h, where w and h are
     * the width and height of C, respectively, then reachable_C(i, j) is
     * returned as output. That is,
     * - true is returned if it is possible to reach point (i, j) from
     *    point (0, 0) in the city by travelling north and east, and
     * - false is returned if it is not possible to reach point (i, j)
     *    from point (0, 0) in this city by travelling in this way.
     * On the other hand, if it is not true that 0 <= i <= w and 0 <= j <= h
     * (where w and h are the width and height of C, respectively) then an
     * IllegalArgumentException is thrown.
     *
     */

    public static boolean access(City C, int i, int j) throws IllegalArgumentException {
        City F = new City(i, j);
        if (i<0 || j<0){
            throw new IllegalArgumentException("Value too small");
        }
        if ((i == 0) && (j == 0)) {
            return true;
        } else {
            /*for all integers s and t such that 0 <= s <= i and 0 <= t <= j*/
            int s = 0;
            while (s <= i) {
                int t = 0;
                while (t <= j) {
                    if (s == 0) {
                        if (t == 0) {
                            F.addNorth(s, t-1);
                            F.addEast(s-1,t);
                        } else {
                            if (F.north(s, t-1)) {
                                F.addNorth(s,t);
                            }
                        }
                    } else if (t == 0) {
                        if (F.east(s-1,t)) {
                            F.addEast(s,t);
                        }
                    } else {
                        if (F.east(s-1,t)) {
                            F.addEast(s,t);
                        }
                        if (F.north(s,t-1)) {
                            F.addNorth(s,t);
                        }
                    }
                    t++;
                }
                s++;
            }
            if (i >= j) {
                return F.east(i,j);
            } else {
                return F.north(i,j);
            }
        }
    }
}


