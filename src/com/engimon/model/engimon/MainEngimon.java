package com.engimon.model.engimon;

import java.awt.Point;

import com.engimon.model.element.Element;
import com.engimon.model.engimon.species.Groudon;

public class MainEngimon {
    public static void main(String[] args) {
        Point point = new Point(1, 1);
        Groudon groudon = new Groudon(32, point);
        assert groudon.interact() == "Rrrrraaaaaaa~";
        assert groudon.getName() == "Groudon";
        assert groudon.getId() == 6;
        assert groudon.getLevel() == 32;
        assert groudon.getSpecies() == "Groudon";
        assert groudon.getExp() == 0;
        assert groudon.getActive() == false;
        assert groudon.getPosition() == point;
        assert groudon.getCumulativeExp() == 0;
    }
}
