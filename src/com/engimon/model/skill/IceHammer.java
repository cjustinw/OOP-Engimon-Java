package com.engimon.model.skill;

public class IceHammer extends Skill{
	public IceHammer(){
		super(26,"IceHammer",100,1);
		prereqElmt.add(new Ice());
	}
}
