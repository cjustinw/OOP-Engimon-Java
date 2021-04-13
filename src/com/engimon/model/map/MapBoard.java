package com.engimon.model.map;

/* Map structure
        ----> width --->
      +-----------------+   |
      |-----------------|   |
      |-----------------|   |
      |-----------------|   V
      |-----------------|  length
      |-----------------|   |
      |-----------------|   |
      |(0,0)------------|   |
      +-----------------+   V
*/

public class MapBoard {

    private static int SIZE_LENGTH = 30;
    private static int SIZE_WIDTH = 30;

    private final Cell[][] map;

    public MapBoard() {
        map = new Cell[SIZE_WIDTH][SIZE_LENGTH];
    }

    public MapBoard(int width, int length) {
        SIZE_LENGTH = length;
        SIZE_WIDTH = width;
        map = new Cell[SIZE_WIDTH][SIZE_LENGTH];
    }

    public Cell at(int x, int y) {
        return map[x][SIZE_LENGTH-y-1];
    }

    public Cell at(Point P) {
        return this.at(P.getX(), P.getY());
    }

    public boolean isPositionValid(Point P) {
        return P.getX() < SIZE_WIDTH && P.getY() < SIZE_LENGTH;
    }
}
