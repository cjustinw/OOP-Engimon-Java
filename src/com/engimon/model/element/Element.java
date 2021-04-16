package com.engimon.model.element;

public class Element {
    protected ElmtType Elmt;

    public enum ElmtType {
        FIRE, WATER, ELECTRIC, GROUND, ICE
    }

    public Element(ElmtType elmt) {
        this.Elmt = elmt;
    }

    public ElmtType getElmt() {
        return this.Elmt;
    }

}
