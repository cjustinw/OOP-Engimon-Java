package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;
import java.util.ArrayList;

public class HydroCannon extends Skill{
	public HydroCannon(boolean item){
            id = 23;
	    name = "Hydro Cannon";
	    basePower = 150;
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
            prereqElmt.add(new Ice());
	}
}
