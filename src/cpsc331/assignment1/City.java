package cpsc331.assignment1;

/*
 *
 * Provides a "City", as described for Assignment #1
 *
 */

//Changes to city for test

public class City {

    // Data Fields

    private final int cWidth;            // A positive integer
    private final int cHeight;           // A positive integer
    private boolean[][] eastStreets;
    private boolean[][] northStreets;

    /*
     *
     * Constructor produces a city with a given positive integer width
     * and height, with no streets
     *
     */

    public City(int width, int height) {

        if (width > 0) {

            if (height > 0) {

                this.cWidth = width;
                this.cHeight = height;

                this.eastStreets = new boolean[width][height + 1];
                int i = 0;
                while (i < width) {
                    int j = 0;
                    while (j <= height) {
                        this.eastStreets[i][j] = false;
                        j = j + 1;
                    };
                    i = i + 1;
                };

                this.northStreets = new boolean[width+1][height];
                i = 0;
                while (i <= width) {
                    int j = 0;
                    while (j < height) {
                        this.northStreets[i][j] = false;
                        j = j + 1;
                    };
                    i = i + 1;
                };

            } else {

                throw new IllegalArgumentException("The given height must be a positive integer.");

            }

        } else {

            throw new IllegalArgumentException("The given width must be a positive integer.");

        }

    }

    /*
     *
     * Adds a street east from point (i, j) to point (i+1, j) - throwing an
     * exception, instead, if i < 0, i >= cWidth, j < 0, or j > cHeight.
     * There is no change if a street from (i, j) to (i+1, j) already exists.
     *
     */

    public void addEast(int i, int j) {

        if ((i >= 0) && (i < this.cWidth)) {

            if ((j >= 0) && (j <= this.cHeight)) {

                this.eastStreets[i][j] = true;

            } else {

                throw new IllegalArgumentException("Second input must between 0 and height");

            }

        } else {

            throw new IllegalArgumentException("First input must be between 0 and width-1");

        }

    }

    /*
     *
     * Adds a street north from point (i, j) to point (i, j+1) - throwing an
     * exception, instead, if i < 0, i > cWidth, j < 0, or j >= cHeight.
     * There is no change if a street from (i, j) to (i, j+1) already exists.
     *
     */

    public void addNorth(int i, int j) {

        if ((i >= 0) && (i <= this.cWidth)) {

            if ((j >= 0) && (j < this.cHeight)) {

                this.northStreets[i][j] = true;

            } else {

                throw new IllegalArgumentException("Second input must be between 0 and height-1");

            }

        } else {

            throw new IllegalArgumentException("First input must be between 0 and width.");

        }

    }

    /*
     *
     * Reports the width of this city
     *
     */

    public int width() {

        return this.cWidth;

    }

    /*
     *
     * Returns the height of this city
     *
     */

    public int height() {

        return this.cHeight;

    }

    /*
     *
     * Reports whether there is a street from point (i, j) to point (i+1, j) - throwing
     * an exception if i < 0, i >= cWidth, j < 0 or j > cHeight, so that no such street
     * could possibly exist
     *
     */

    public boolean east(int i, int j) {

        if ((i >= 0) && (i < this.cWidth)) {

            if ((j >= 0) && (j <= this.cHeight)) {

                return this.eastStreets[i][j];

            } else {

                throw new IllegalArgumentException("Second input must be between 0 and height");

            }

        } else {

            throw new IllegalArgumentException("First input must be between 0 and width-1");

        }

    }

    /*
     *
     * Reports whether there is a street from point (i, j) to point (i, j+1) -
     * throwing an exception if i < 0, i > cWidth, j < 0 or j >= cHeight, so that
     * no such street could possibly exist
     *
     */

    public boolean north(int i, int j) {

        if ((i >= 0) && (i <= this.cWidth)) {

            if ((j >= 0) && (j < this.cHeight)) {

                return this.northStreets[i][j];

            } else {

                throw new IllegalArgumentException("Second input must be between 0 and height-1");

            }

        } else {

            throw new IllegalArgumentException("First input must be between 0 and width");

        }

    }

}