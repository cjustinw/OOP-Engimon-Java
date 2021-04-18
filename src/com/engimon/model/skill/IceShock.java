package com.engimon.model.skill;

public class IceShock extends Skill{
	public IceShock(){
		super(27,"Ice Shock",50,1);
		prereqElmt.add(new Ice());
		prereqElmt.add(new Water());
	}
}
