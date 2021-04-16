package com.engimon.model.Engimon;

import com.engimon.model.element.Element;
import com.engimon.model.map.Cell;
import com.engimon.model.map.Cellable;
import com.engimon.model.map.Point;

import java.util.ArrayList;

abstract public class Engimon implements Cellable {

    protected String name;
    protected String species; // instanceof (?)
    protected String parent;
    protected ArrayList<Element> elements;
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
        position = new Point(0,0);
        elements = new ArrayList<>();
    }

    public Engimon(int lvl, Point pos, boolean child) {
        level = lvl;
        maxSkills = 4;
        exp = 0;
        cumulativeExp = 0;
        active = false;
        this.child = child;
        position = new Point(pos);
        elements = new ArrayList<>();
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

    public boolean isAllowedTo(Cell cell) {
        return this.elements
                .stream()
                .anyMatch(element -> element.isAllowedTo(cell));
    }

    abstract public void interact();
}