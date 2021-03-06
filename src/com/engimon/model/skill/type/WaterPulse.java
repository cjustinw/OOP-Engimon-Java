package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;
import java.util.ArrayList;

public class WaterPulse extends Skill{
	public WaterPulse(boolean item){
            id = 25;
	    name = "Water Pulse";
	    basePower = 60;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt = new ArrayList<>();
            prereqElmt.add(new Water());
	}
}
