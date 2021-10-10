/*
Authors:
   Feifei Zhang UCID: 30071476
   Joanne Millard UCID:30117800
   Farhan Salam UCID: 30096686
   Description:
   This program will receive a location in city C and determine whether
   a given location is reachable from point (0,0) by only travelling north or east.

   Citation:
-	Lecture #3: Introduction to the Correctness of Algorithms II – Correctness of Simple Algorithms with a While Loop
-	Tutorial #4: Introduction to the Correctness of Algorithms II
-	Lecture #4: Analyzing the Efficiency of Algorithms
-	Tutorial #5: Analyzing the Efficiency of Algorithms

   Outer loop invariant:
   a)  C is an input city, and i and j are input integers
       such that 0 <= i <= w and 0 <= j <= h, where w and h are
       the width and height of C, respectively.
   b) R is a (variable) Boolean array with i + 1 rows and j + 1 columns.
   c) s is an integer variable such that 0 <= s <= i + 1.
   d) R[u][v] = 〖access〗c (u,v) for all integers u and v
      such that 0 <= v <= j and 0 <= u <= s - 1.

   Bound function for the outer loop:
   g:(s,i)=i-s+1

   Inner loop Invariant:
   a) C is an input city, and i and j are input integers
      such that 0 <= i <= w and 0 <= j <= h, where w and h are
      the width and height of C, respectively.
   b) R is a (variable) Boolean array with i + 1 rows and j + 1 columns.
   c) t is an integer variable such that 0 <= t <= j + 1.
   d) R[u][v] = 〖access〗c (u,v) for all integers u and v
      such that 0 <= u <= i and 0 <= v <= t - 1.

   Bound function for the inner loop:
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

    // Worst case: 5ij + 9i + 5j + 16
    public static boolean access(City C, int i, int j) throws IllegalArgumentException {
        // Two nonnegative integers, i and j, and class City C has been given as input.
        if ((0 > i) || (i > C.width())) {
            // i is a negative integer input or it is greater than the width of City C.
            throw new IllegalArgumentException("input must be between 0 and width");
            // An IllegalArgumentException is thrown.
        }
        if ((0 > j) || (j > C.height())) {
            // j is a negative integer input or it is greater than the height of City C.
            throw new IllegalArgumentException("input must be between 0 and height");
            // An IllegalArgumentException is thrown.
        }
        if ((i == 0) && (j == 0)) {
            // i and j are nonnegative integer inputs such that i and j equal 0.
            return true;
        } else {
            // s and t are integer variables such that 0<=s<=i and 0<=t=<i
            Boolean[][] R = new Boolean[i + 1][j + 1];
            /*
               R is a boolean array with i + 1 rows and j columns
               for all integers s and t such that 0 <= s <= i and 0 <= t <= j.
               All elements in the array have been set to false
               (Java automatically sets all elements in a boolean array to be false).
            */
            int s = 0;
            // Tests if the integer variable s is less than the integer input i.
            while (s <= i) {
                int t = 0;
                // Tests if the integer variable t is less than the integer input j.
                while (t <= j) {
                    if (s == 0) {
                        if (t == 0) {
                            // s and t are nonnegative  integer variables such that s = 0 and t = 0.
                            R[s][t] = true;
                            // R[s][t] is set to True.
                        } else {
                            // s and t are nonnegative integer variables such that s = 0 and t > 0.
                            R[s][t] = C.north(s, t - 1) && R[s][t - 1];
                            /*
                              R[s][t] is set to True only if there exists
                              a street from R[s][t - 1] to R[s][t] in City C.
                            */
                        }
                    } else if (t == 0) {
                         // s and t are nonnegative integer variables such that s > 0 and t = 0.
                        R[s][t] = (C.east(s - 1, t) && R[s - 1][t]);
                        /*
                           R[s][t] is set to True only if there exists
                           a street from R[s - 1][t] to R[s][t] in City C.
                         */
                    } else {
                        // s and t are nonnegative integer variables greater than 0.
                        R[s][t] = ((C.east(s - 1, t) && R[s - 1][t]) || (C.north(s, t - 1) && R[s][t - 1]));
                        /*
                           R[s][t] is set to True only if there exists
                           a street from R[s][t - 1] to R[s][t]
                           or a street from R[s - 1][t] to R[s][t] in City C.
                        */
                    }
                    t++;
                    // integer variable t has been incremented by 1.
                }
                s++;
                // integer variable s has been incremented by 1.
            }
            return R[i][j];
            /*
              An integer array R with a length of i + 1 and a
              width of j + 1 such that R[i][j] has been returned as output.
            */
        }
    }
}


