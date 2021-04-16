package com.engimon.model.element;

public class Ground extends Element {
    public Ground() {
        super(ElmtType.GROUND);
    }

    public double elementAdvantage(ElmtType Elmt) {
        switch (Elmt) {
        case ICE:
            return 0;
        case FIRE:
            return 1.5;
        case ELECTRIC:
            return 2;
        default:
            return 1;
        }
    }
}
