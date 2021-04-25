package com.engimon.model.element;

public abstract class Element {
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
    
    public abstract double elementAdvantage(ElmtType Elmt);
}
