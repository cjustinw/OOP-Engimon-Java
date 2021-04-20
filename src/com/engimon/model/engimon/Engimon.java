package com.engimon.model.engimon;

import java.awt.*;
import java.util.List;

import com.engimon.model.element.*;
import com.engimon.model.skill.*;

public abstract class Engimon {
    protected int id;
    protected String name;
    protected String species;
    protected int level;
    protected List<Skill> skills;
    protected List<Element> elements;
    protected Point position;
    private int numOfSkill;
    private int exp;
    private int cumulativeExp;
    private boolean active;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getCumulativeExp() {
        return cumulativeExp;
    }

    public boolean getActive() {
        return active;
    }

    public Point getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void moveToNorth() {
        position.y--;
    }

    public void moveToSouth() {
        position.y++;
    }

    public void moveToWest() {
        position.x--;
    }

    public void moveToEast() {
        position.x++;
    }

    /* return true jika naik level */
    public boolean addExp(int exp) {
        this.exp += exp;
        cumulativeExp += exp;
        int lvl = (this.exp)/(getLevel()*100);
        if(lvl > 0) {
            level += lvl;
            this.exp = getExp() % (lvl*100);
            return true;
        }
        return false;
    }

    public boolean canBreeding() {
        return level >= 4;
    }

    public void setLevelAfterBreeding() {
        level -= 3;
    }

    public abstract String interact();

    public void learnSkill(Skill skill){
        skills.add(skill);
        numOfSkill++;
    }
}
