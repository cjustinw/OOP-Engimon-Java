package com.engimon.model.skill;

public class Ember extends Skill{
	public Ember(){
		super(14,"Ember",40,1);
		prereqElmt.add(new Fire());
		prereqElmt.add(new Electric());
	}
}
