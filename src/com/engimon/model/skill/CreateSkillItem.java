/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.model.skill;

import com.engimon.model.skill.type.*;

/**
 *
 * @author chris
 */
public class CreateSkillItem {

    public Skill createSkillItem(int id) {
        return switch (id) {
            case 1 -> new BlastBurn(true);
            case 2 -> new Eruption(true);
            case 3 -> new ThunderBolt(true);
            case 4 -> new Catastropika(true);
            case 5 -> new Dig(true);
            case 6 -> new Earthquake(true);
            case 7 -> new WaterGun(true);
            case 8 -> new OceanicOperetta(true);
            case 9 -> new FreezeShock(true);
            case 10 -> new IceBurn(true);
            case 11 -> new Charge(true);
            case 12 -> new Mist(true);
            case 13 -> new MudShot(true);                
            case 14 -> new Ember(true);
            case 15 -> new FireBlast(true);
            case 16 -> new FireFang(true);
            case 17 -> new ElectroBall(true);
            case 18 -> new ThunderShock(true); 
            case 19 -> new VoltTackle(true);
            case 20 -> new BoneRush(true);
            case 21 -> new Buldoze(true);
            case 22 -> new SandAttack(true);
            case 23 -> new HydroCannon(true);
            case 24 -> new WaterSpout(true);
            case 25 -> new WaterPulse(true);
            case 26 -> new IceHammer(true);
            case 27 -> new IceShock(true);
            case 28 -> new FrostBreath(true);
            default -> null;
        };
    }
}
