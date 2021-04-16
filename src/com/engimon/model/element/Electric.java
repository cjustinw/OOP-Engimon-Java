package com.engimon.model.element;

import com.engimon.model.map.Cell;
import com.engimon.model.map.CellType;

public class Electric extends Element {
    public Electric() {
        super(ElmtType.ELECTRIC);
    }

    public double elementAdvantage(ElmtType Elmt) {
        switch (Elmt) {
        case GROUND:
            return 0;
        case ICE:
            return 1.5;
        case WATER:
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
