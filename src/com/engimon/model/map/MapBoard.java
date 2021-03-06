package com.engimon.model.map;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Map structure
        ----> width --->
      +(0,0)------------+   |
      |-----------------|   |
      |-----------------|   |
      |-----------------|   V
      |-----------------|  length
      |-----------------|   |
      |-----------------|   |
      |-----------------|   |
      +-----------------+   V
*/

public class MapBoard {

    private static int SIZE_LENGTH = 20;
    private static int SIZE_WIDTH = 20;
    private static String mapPath = "resources/map.txt";

    private final Cell[][] map;

    public MapBoard() {
        map = new Cell[SIZE_LENGTH][SIZE_WIDTH];
        try {
            File file = new File(mapPath);
            Scanner sc = new Scanner(file);
            
            for(int i = 0; i < SIZE_LENGTH; i++){
                String str = sc.next();
                
                for(int j = 0; j < SIZE_WIDTH; j++) {
                    switch (str.charAt(j)) {
                        case 'o' -> map[i][j] = new Cell(CellType.SEA);
                        case '-' -> map[i][j] = new Cell(CellType.GRASSLAND);
                        case '^' -> map[i][j] = new Cell(CellType.MOUNTAINS);
                        case '~' -> map[i][j] = new Cell(CellType.TUNDRA);
                        case '1' -> map[i][j] = new Cell(CellType.SEA_BORDER);
                        case '2' -> map[i][j] = new Cell(CellType.MOUNTAINS_BORDER);
                        case '3' -> map[i][j] = new Cell(CellType.ROCK_STAIR);
                        case '4' -> map[i][j] = new Cell(CellType.ROCK_WALL);
                        case '5' -> map[i][j] = new Cell(CellType.GRASSLAND_STREET);
                        default -> {
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Cell at(int x, int y) {
        return map[y][x];
    }

    public Cell at(Point P) {
        return this.at(P.x, P.y);
    }

    public boolean isPositionValid(Point P) {
        if((P.x < 0) || (P.x > SIZE_WIDTH - 1) || (P.y < 0) || (P.y > SIZE_LENGTH - 1)){
            return false;
        }
        else if(at(P.x, P.y).getType().equals(CellType.ROCK_WALL)){
            return false;
        }
        return true;
    }

    public void printMap() {
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                if(at(j,i).isFull()){
                    System.out.print("O");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
