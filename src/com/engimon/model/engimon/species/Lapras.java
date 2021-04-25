package com.engimon.model.engimon.species;

import com.engimon.model.element.Ice;
import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.Mist;

import java.awt.*;
import java.util.ArrayList;

public class Lapras extends Engimon {

    public Lapras(int level, Point position) {
        id = 12;
        species = "Lapras";
        name = "Lapras";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Water());
        elements.add((new Ice()));
        skills = new ArrayList<>();
        skills.add(new Mist(false));
        life = 1;
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/lapras.png";
        }
        return "resources/sprites/pokemon/lapras-gmax.png";
    }

    public String interact() {
        return "Aaaaarrrrrr~";
    }
}
