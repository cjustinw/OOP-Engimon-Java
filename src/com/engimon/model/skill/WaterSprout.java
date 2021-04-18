package com.engimon.model.skill;

public class WaterSprout extends Skill{
	public WaterSprout(){
		super(24,"Water Sprout",150,1);
		prereqElmt.add(new Water());
	}
}
