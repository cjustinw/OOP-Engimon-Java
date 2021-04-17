package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;

import java.awt.*;

public class Swampert extends Engimon {

    public Swampert(String name, int level, Point position) {
        id = 13;
        species = "Swampert";
        this.name = name;
        this.level = level;
        this.position = position;
        elements.add(new Water());
        elements.add(new Ground());
//        skills.add(new MudShot());
    }

    public String interact() {
        return "Swampert~";
    }
}
