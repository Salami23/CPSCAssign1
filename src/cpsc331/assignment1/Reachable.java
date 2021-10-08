/*
   Authors:
   Feifei Zhang UCID:
   Joanne Millard UCID:30117800
   Farhan Salam UCID: 30096686
   Description:
   This program will receive a location in city F and see whether or not
   that location is reachable from point (0, 0)
   Citation:
   Outerloop invariant:
   a)  F is an input city, and i and j are input integers
   	   such that 0 <= i <= w and 0 <= j <= h, where w and h are
   	   the width and height of F, respectively.
	b) northStreets is a (variable) Boolean array with i + 1 rows and j columns and
	   eastStreets is a (variable) Boolean array with i rows and j + 1 columns.
	c) s is an integer variable such that 0 <= s <= i + 1.
    d) northStreets[u][v] || eastStreets[u][v] = 〖access〗c (u,v)
       for all integers u and v such that 0 <= v <= j and 0 <= u <= s - 1.
   Bound function for the outerloop:
     g:(s,i)=i-s+1
   Innerloop Invariant:
   	a) F is an input city, and i and j are input integers
   	   such that 0 <= i <= w and 0 <= j <= h, where w and h are
   	   the width and height of F, respectively.
	b) northStreets is a (variable) Boolean array with i + 1 rows and j columns and
	   eastStreets is a (variable) Boolean array with i rows and j + 1 columns.
	c) t is an integer variable such that 0 <= t <= j + 1.
    d) northStreets[u][v] || eastStreets[u][v] = 〖access〗c (u,v)
       for all integers u and v such that 0 <= u <= i and 0 <= v <= t - 1.
   Bound function for the innerloop:
     f:(t,j)=j-t+1

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

    // Worst case: 8ij + 12i + 8j + 18
    public static boolean access(City C, int i, int j) throws IllegalArgumentException {
        // Two nonnegative integers, i and j, and class City C has been given as input
        City F = new City(i, j);
        /* northStreets is a boolean array with i + 1 rows and j columns
           and eastStreets is a boolean array with i rows and j + 1 columns
           such that northStreets[s][t] and eastStreets[s][t] such that
           0 <= s <= i and 0 <= t <= j*/
        if ((i == 0) && (j == 0)) {
            return true;
            /* The function access returns the boolean true as output */
        } else {
            /*for all integers s and t such that 0 <= s <= i and 0 <= t <= j*/
            int s = 0;
            while (s <= i) {
                int t = 0;
                while (t <= j) {
                    if (s == 0) {
                        if (t == 0) {
                            F.addNorth(s, t);
                            // Set northStreets[s][i] to true.
                            F.addEast(s,t);
                            // Set eastStreats[s][i] to true.
                        } else {
                            if (F.north(s, t-1)) {
                                F.addNorth(s,t);
                                //
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


