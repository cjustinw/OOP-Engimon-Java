package com.engimon.model.skill;

public class Earthquake extends Skill{
	public Earthquake(){
		super(6,"Earthquake",100,1);
		prereqElmt.add(new Ground());
	}
}
