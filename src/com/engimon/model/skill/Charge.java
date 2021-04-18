package com.engimon.model.skill;

public class Charge extends Skill{
	public Charge(){
		super(11,"Charge",100,1);
		prereqElmt.add(new Electric());
	}
}
