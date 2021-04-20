package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Earthquake;

import java.awt.*;

public class Groudon extends Engimon {

    public Groudon(int level, Point position) {
        id = 6;
        species = "Groudon";
        name = "Groudon";
        this.level = level;
        this.position = position;
        elements.add(new Ground());
        skills.add(new Earthquake(false));
    }

    public String interact() {
        return "Rrrrraaaaaaa~";
    }
}
