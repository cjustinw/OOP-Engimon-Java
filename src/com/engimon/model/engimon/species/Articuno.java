package com.engimon.model.engimon.species;

import com.engimon.model.element.Ice;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.IceBurn;

import java.awt.*;
import java.util.ArrayList;

public class Articuno extends Engimon {

    public Articuno(int level, Point position) {
        id = 11;
        species = "Articuno";
        name = "Articuno";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Ice());
        skills = new ArrayList<>();
        skills.add(new IceBurn(false));
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/articuno.png";
        }
        return "resources/sprites/pokemon/articuno-galarian.png";
    }

    public String interact() {
        return "Rrrrreeeee~";
    }
}
