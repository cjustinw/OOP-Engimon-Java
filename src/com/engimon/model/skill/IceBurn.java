package com.engimon.model.skill;

public class IceBurn extends Skill{
	public IceBurn(){
		super(10,"Ice Burn",210,1);
		prereqElmt.add(new Ice());
	}
}
