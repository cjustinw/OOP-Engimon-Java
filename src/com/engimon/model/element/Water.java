package com.engimon.model.element;

import com.engimon.model.map.Cell;
import com.engimon.model.map.CellType;

public class Water extends Element {
    public Water() {
        super(ElmtType.WATER);
    }

    public float elementAdvantage(ElmtType Elmt) {
        switch (Elmt) {
        case ELECTRIC:
            return 0;
        case FIRE:
            return 2;
        default:
            return 1;
        }
    }

    @Override
    public boolean isAllowedTo(Cell cell) {
        return cell.getType() == CellType.SEA;
    }
}
