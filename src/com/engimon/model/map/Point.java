package com.engimon.model.map;

public class Point {
    private int x = 0;  //  default value
    private int y = 0;  // default value

    public Point(int absis, int ordinat) {
        x = absis;
        y = ordinat;
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getY() {
        return y;
    }

    public void setY(int newY) {
        y = newY;
    }
}
