package com.engimon.model.map;

public class Point {
    private int x = 0;  //  default value
    private int y = 0;  // default value

    public Point(){

    }

    public Point(int absis, int ordinat) {
        x = absis;
        y = ordinat;
    }

    public Point(Point other) {
        x = other.getX();
        y = other.getY();
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
