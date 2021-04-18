package com.engimon.model.skill;

public class Dig extends Skill{
	public Dig(){
		super(5,"Dig",80,1);
		prereqElmt.add(new Ground());
	}
}


