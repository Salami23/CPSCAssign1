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

    /*
    Functions in city:
        City - The constructor, makes the double arrays for the City
        addEast - Add street eastStreets[input for width][input for height] and make it true
        addNorth - Add street northStreets[input for width][input for height] and make it true
        width - return the width of City
        height - return the height of City
        east - Returns the truth value in eastStreets[input for width][input for height]
        north - Returns the truth value in northStreets[input for width][input for height]
     */

    /*
    Pseudocode for access:
  */


    public static boolean access(City C, int i, int j) throws IllegalArgumentException {
        City F = new City(i, j); //Creates a city F with inputs i and j as length and width
        if ((i == 0) && (j == 0)) {
            return true;
        } else {
            // s and t are integers such that 0<=s<=i and 0<=t=<i
            int s = 0;
            while (s <= i) {
                int t = 0;
                while (t <= j) {
                    if (s == 0) {
                        if (t == 0) {
                            F.addNorth(s, t-1); //when s=0 and t=0, turn array position F(s, t-1) true
                            F.addEast(s-1,t);
                        } else { //s=0 and t>1
                            if (F.north(s, t-1)) { //if there is a street from (s,t-1) to (s,t) then return true
                                F.addNorth(s,t); //when s=0 and t>0, turn array position F(s-1, t) true
                            }
                        }

                    } else if (t == 0) { //if s>0 and t=0
                        if (F.east(s-1,t)) { //if there is a street from (s-1,t) to (s,t) then return true
                            F.addEast(s,t);  //when s>0 and t=0, turn array position F(s-1, t) to true
                        }
                    } else { //if s>0 and t>0
                        if (F.east(s-1,t)) { //if there is a street from (s-1,t) to (s,t) then return true
                            F.addEast(s,t); //when s>0 and t=0, turn array position F(s-1, t) to true
                        }
                        if (F.north(s,t-1)) { //if there is a street from (s,t-1) to (s,t) then return true
                            F.addNorth(s,t); //when s=0 and t?0, turn array position F(s-1, t) true
                        }
                    }
                    t++;
                }
                s++;
            }
            //return R[i][j];
            if (i >= j) {
                return F.east(i,j);
            } else {
                return F.north(i,j);
            }
        }
    }
}


