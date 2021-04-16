package com.engimon.model.element;

public class Ice extends Element {
    public Ice() {
        super(ElmtType.ICE);
    }

    public double elementAdvantage(ElmtType Elmt) {
        switch (Elmt) {
        case FIRE:
            return 0;
        case ELECTRIC:
            return 0.5;
        case GROUND:
            return 2;
        default:
            return 1;
        }
    }

}
