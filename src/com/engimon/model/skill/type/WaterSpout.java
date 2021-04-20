package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;

public class WaterSpout extends Skill{
	public WaterSpout(boolean item){
            id = 24;
	    name = "Water Spout";
	    basePower = 150;
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
