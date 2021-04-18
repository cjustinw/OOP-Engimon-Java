package com.engimon.model.skill;

public class WaterGun extends Skill{
	public WaterGun(){
		super(7,"Water Gun",100,1);
		prereqElmt.add(new Water());
	}
}
