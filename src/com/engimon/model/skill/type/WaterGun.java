package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class WaterGun extends Skill{
	public WaterGun(boolean item){
            id = 7;
	    name = "Water Gun";
	    basePower = 100;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt.add(new Water());
	}
}
