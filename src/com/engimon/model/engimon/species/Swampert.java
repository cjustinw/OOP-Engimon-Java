package com.engimon.model.engimon.species;

import com.engimon.model.element.Ground;
import com.engimon.model.element.Water;
import com.engimon.model.engimon.Engimon;
import com.engimon.model.skill.type.MudShot;

import java.awt.*;
import java.util.ArrayList;

public class Swampert extends Engimon {

    public Swampert(int level, Point position) {
        id = 13;
        species = "Swampert";
        name = "Swampert";
        this.level = level;
        this.position = position;
        elements = new ArrayList<>();
        elements.add(new Water());
        elements.add(new Ground());
        skills = new ArrayList<>();
        skills.add(new MudShot(false));
        life = 1;
    }
    
    public String getImagePath() {
        if(level < 4){
            return "resources/sprites/pokemon/swampert.png";
        }
        return "resources/sprites/pokemon/swampert 2.png";
    }

    public String interact() {
        return "Swampert~";
    }
}
