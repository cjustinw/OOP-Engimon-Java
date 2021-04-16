package com.engimon.model.element;

import com.engimon.model.map.Cell;
import com.engimon.model.map.CellType;

public class Fire extends Element {
    public Fire() {
        super(ElmtType.FIRE);
    }

    public double elementAdvantage(ElmtType Elmt) {
        switch (Elmt) {
        case WATER:
            return 0;
        case GROUND:
            return 0.5;
        case ICE:
            return 2;
        default:
            return 1;
        }
    }

    @Override
    public boolean isAllowedTo(Cell cell) {
        return cell.getType() == CellType.MOUNTAINS;
    }
}
