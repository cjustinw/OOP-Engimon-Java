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

import com.engimon.model.Engimon.Engimon;
import com.engimon.model.Engimon.Entei;

import java.util.Random;

public class MapBoard {

    private static int SIZE_LENGTH = 30;
    private static int SIZE_WIDTH = 30;

    private final Cell[][] map;

    public MapBoard() {
        map = new Cell[SIZE_LENGTH][SIZE_WIDTH];
    }

    public MapBoard(int width, int length) {
        SIZE_LENGTH = length;
        SIZE_WIDTH = width;
        map = new Cell[SIZE_WIDTH][SIZE_LENGTH];
        for (int i = 0; i < SIZE_LENGTH; i++) {
            for (int j = 0; j < SIZE_WIDTH; j++) map[i][j] = new Cell();
        }
    }

    public int getSizeLength(){
        return SIZE_LENGTH
    }

    public int getSizeWidth() {
        return SIZE_WIDTH;
    }

    public Cell at(int x, int y) {
        return map[x][SIZE_LENGTH-y-1];
    }

    public Cell at(Point P) {
        return this.at(P.getX(), P.getY());
    }

    public boolean isPositionValid(Point P) {
        return P.getX() > 0 && P.getX() < SIZE_WIDTH
                && P.getY() > 0 && P.getY() < SIZE_LENGTH;
    }

    public void print() {
        for (int x = 0; x < SIZE_WIDTH; x++) {
            for (int y = 0; y < SIZE_LENGTH; y++) {
                System.out.print(this.at(x,y).getSymbol());
            }
            System.out.println();
        }
    }

    public void spawnEngimonAt(Engimon engimon, int x, int y) {
//        Engimon engimon = new Entei(); // buat coba2 dulu pake entei
        this.at(x,y).setObject(engimon);
    }

    public void spawnEngimonAt(Engimon engimon, Point p){
        spawnEngimonAt(engimon, p.getX(), p.getY());
    }

    public static void main(String[] args) {
        // main buat driver
        MapBoard map = new MapBoard(20,20);

        map.print();



        map.print();
    }
}
