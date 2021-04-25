package com.engimon.model.map;

public class MainCell {
    public static void main(String[] args) {
        Cell grass = new Cell(CellType.GRASSLAND);
        Cell grassStreet = new Cell(CellType.GRASSLAND_STREET);
        Cell sea = new Cell(CellType.SEA);
        Cell seaborder = new Cell(CellType.SEA_BORDER);
        Cell mountain = new Cell(CellType.MOUNTAINS);
        Cell mountainbordor = new Cell(CellType.MOUNTAINS_BORDER);
        Cell tundra = new Cell(CellType.TUNDRA);
        Cell rockwall = new Cell(CellType.ROCK_WALL);
        Cell rockstair = new Cell(CellType.ROCK_STAIR);

        // grass testing
        assert grass.getType() == CellType.GRASSLAND;
        assert grass.isEmpty() == true;

        // grass street testing
        assert grassStreet.getType() == CellType.GRASSLAND_STREET;
        assert grassStreet.isEmpty() == true;

        // sea testing
        assert sea.getType() == CellType.SEA;
        assert sea.isEmpty() == true;

        // sea border testing
        assert seaborder.getType() == CellType.SEA_BORDER;
        assert seaborder.isEmpty() == true;

        // mountains testing
        assert mountain.getType() == CellType.MOUNTAINS;
        assert mountain.isEmpty() == true;

        // mountainbordor testing
        assert mountainbordor.getType() == CellType.MOUNTAINS_BORDER;
        assert mountainbordor.isEmpty() == true;

        // tundra testing
        assert tundra.getType() == CellType.TUNDRA;
        assert tundra.isEmpty() == true;

        // rockwall testing
        assert rockwall.getType() == CellType.ROCK_WALL;
        assert rockwall.isEmpty() == true;

        // grass testing
        assert rockstair.getType() == CellType.ROCK_STAIR;
        assert rockstair.isEmpty() == true;

    }
}
