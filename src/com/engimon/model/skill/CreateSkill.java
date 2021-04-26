/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.engimon.model.skill;

import com.engimon.model.skill.type.BlastBurn;
import com.engimon.model.skill.type.Catastropika;
import com.engimon.model.skill.type.Charge;
import com.engimon.model.skill.type.Dig;
import com.engimon.model.skill.type.Earthquake;
import com.engimon.model.skill.type.Eruption;
import com.engimon.model.skill.type.FreezeShock;
import com.engimon.model.skill.type.IceBurn;
import com.engimon.model.skill.type.Mist;
import com.engimon.model.skill.type.MudShot;
import com.engimon.model.skill.type.OceanicOperetta;
import com.engimon.model.skill.type.ThunderBolt;
import com.engimon.model.skill.type.WaterGun;

/**
 *
 * @author chris
 */
public class CreateSkill {

    public Skill createSkillItem(int id) {
        return switch (id) {
            case 1 -> new BlastBurn(false);
            case 2 -> new Eruption(false);
            case 3 -> new ThunderBolt(false);
            case 4 -> new Catastropika(false);
            case 5 -> new Dig(false);
            case 6 -> new Earthquake(false);
            case 7 -> new WaterGun(false);
            case 8 -> new OceanicOperetta(false);
            case 9 -> new FreezeShock(false);
            case 10 -> new IceBurn(false);
            case 11 -> new Charge(false);
            case 12 -> new Mist(false);
            case 13 -> new MudShot(false);       
            default -> null;
        };
    }
}
