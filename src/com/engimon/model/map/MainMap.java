package com.engimon.model.map;

import java.awt.Point;

public class MainMap {
    public static void main(String[] args) {
        MapBoard map = new MapBoard();
        Point point = new Point(1, 1);

        assert map.at(3, 2).getType() == CellType.MOUNTAINS;
        assert map.isPositionValid(point) == true;
        assert map.at(point).getType() == CellType.MOUNTAINS;
    }
}
