package com.engimon.model.element;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package com.engimon.model.element;

/**
 *
 * @author adinatha
 */
public class Main {
    public static void main(String[] args) {
        Fire fire = new Fire();
        Water water = new Water();
        Electric elec = new Electric();
        Ground ground = new Ground();
        Ice ice = new Ice();

        // Fire test
        assert (fire.getElmt()).equals(Element.ElmtType.FIRE);
        assert (fire.elementAdvantage(ground.getElmt())) == 0.5;
        assert (fire.elementAdvantage(ice.getElmt())) == 2.0;
        assert (fire.elementAdvantage(water.getElmt())) == 0.0;
        assert (fire.elementAdvantage(fire.getElmt())) == 1.0;
        assert (fire.elementAdvantage(elec.getElmt())) == 1.0;

        // Water test
        assert (water.getElmt()).equals(Element.ElmtType.WATER);
        assert (water.elementAdvantage(ground.getElmt())) == 1.0;
        assert (water.elementAdvantage(ice.getElmt())) == 1.0;
        assert (water.elementAdvantage(water.getElmt())) == 1.0;
        assert (water.elementAdvantage(fire.getElmt())) == 2.0;
        assert (water.elementAdvantage(elec.getElmt())) == 0.0;

        // Electric test
        assert (elec.getElmt()).equals(Element.ElmtType.ELECTRIC);
        assert (elec.elementAdvantage(ground.getElmt())) == 0.0;
        assert (elec.elementAdvantage(ice.getElmt())) == 1.5;
        assert (elec.elementAdvantage(water.getElmt())) == 2.0;
        assert (elec.elementAdvantage(fire.getElmt())) == 1.0;
        assert (elec.elementAdvantage(elec.getElmt())) == 1.0;

        // Ground test
        assert (ground.getElmt()).equals(Element.ElmtType.GROUND);
        assert (ground.elementAdvantage(ground.getElmt())) == 1.0;
        assert (ground.elementAdvantage(ice.getElmt())) == 0.0;
        assert (ground.elementAdvantage(water.getElmt())) == 1.0;
        assert (ground.elementAdvantage(fire.getElmt())) == 1.5;
        assert (ground.elementAdvantage(elec.getElmt())) == 2.0;

        // Ice test
        assert (ice.getElmt()).equals(Element.ElmtType.ICE);
        assert (ice.elementAdvantage(ground.getElmt())) == 2.0;
        assert (ice.elementAdvantage(ice.getElmt())) == 1.0;
        assert (ice.elementAdvantage(water.getElmt())) == 1.0;
        assert (ice.elementAdvantage(fire.getElmt())) == 0.0;
        assert (ice.elementAdvantage(elec.getElmt())) == 0.5;

    }
}
