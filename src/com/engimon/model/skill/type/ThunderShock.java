package com.engimon.model.skill.type;

import com.engimon.model.element.*;
import com.engimon.model.skill.Skill;
import java.util.ArrayList;

public class ThunderShock extends Skill{
	public ThunderShock(boolean item){
            id = 18;
	    name = "Thunder Shock";
	    basePower = 40;
	    masteryLevel = 1;
            this.item = item;
            if(item){
                numOfItem = 1;
            }
            else{
                numOfItem = 0;
            }
            prereqElmt = new ArrayList<>();
            prereqElmt.add(new Electric());
	}
}

