package com.engimon.model.engimon.species;

import com.engimon.model.element.Ice;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Articuno extends Engimon {

    public Articuno(String name, int level, Point position) {
        id = 11;
        species = "Articuno";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Ice());
//        skills.add(new IceBurn());
    }

    public String interact() {
        return "Rrrrreeeee~";
    }
}
