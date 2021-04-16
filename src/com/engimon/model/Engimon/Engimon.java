package com.engimon.model.Engimon;

import com.engimon.model.map.Cellable;
import com.engimon.model.map.Point;

import java.util.ArrayList;

abstract public class Engimon implements Cellable {

    protected String name;
    protected String species; // instanceof (?)
    protected String parent;
//    protected ArrayList<Element> elements;
//    protected ArrayList<Skill> skills;
    protected int ID;
    protected int maxSkills;
    protected int numOfSkill;
    protected int level;
    protected int exp;
    protected int cumulativeExp;
    protected Boolean active;
    protected Boolean child;
    protected Point position;

    public Engimon() {

    }

    public Engimon(int lvl, Point pos, boolean child) {
        level = lvl;
        maxSkills = 4;
        exp = 0;
        cumulativeExp = 0;
        active = false;
        this.child = child;
        position = new Point(pos);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void moveRight() {
        this.position.addX();
    }

    public void moveLeft() {
        this.position.subX();
    }

    public void moveUp() {
        this.position.addY();
    }

    public void moveDown() {
        this.position.subY();
    }

    abstract public void interact();
}