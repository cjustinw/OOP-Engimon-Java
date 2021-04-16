package com.engimon.model.element;

import com.engimon.model.map.Cell;
import com.engimon.model.map.CellType;

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

    @Override
    public boolean isAllowedTo(Cell cell) {
        return cell.getType() == CellType.GRASSLAND;
    }
}
