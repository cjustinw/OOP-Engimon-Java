package Map;

/*
      +-----------------+
      |-----------------|
      |-----------------|
      |-----------------|
      |-----------------|
      |-----------------|
      |-----------------|
      |(0,0)------------|
      +-----------------+
*/

public class MapBoard {

    private static final int SIZE_LENGTH = 30;
    private static final int SIZE_WIDTH = 30;

    private final Cell[][] map;

    public MapBoard() {
        map = new Cell[SIZE_WIDTH][SIZE_LENGTH];
    }

    public Cell at(int x, int y) {
        return map[x][SIZE_LENGTH-y-1];
    }


}
