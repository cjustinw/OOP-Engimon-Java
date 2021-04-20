package com.engimon.model.engimon.species;

import com.engimon.model.element.Ice;
import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Mist;

import java.awt.*;

public class Lapras extends Engimon {

    public Lapras(int level, Point position) {
        id = 12;
        species = "Lapras";
        name = "Lapras";
        this.level = level;
        this.position = position;
        elements.add(new Water());
        elements.add((new Ice()));
        skills.add(new Mist(false));
    }

    public String interact() {
        return "Aaaaarrrrrr~";
    }
}
