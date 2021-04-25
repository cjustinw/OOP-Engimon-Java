package com.engimon.model.element;

public class Water extends Element {
    public Water() {
        super(ElmtType.WATER);
    }

    public double elementAdvantage(ElmtType Elmt) {
        switch (Elmt) {
        case ELECTRIC:
            return 0;
        case FIRE:
            return 2;
        default:
            return 1;
        }
    }
}
