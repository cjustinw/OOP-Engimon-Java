package com.engimon.model.element;

import com.engimon.model.map.Cell;
import com.engimon.model.map.CellType;

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

    @Override
    public boolean isAllowedTo(Cell cell) {
        return cell.getType() == CellType.TUNDRA;
    }
}
