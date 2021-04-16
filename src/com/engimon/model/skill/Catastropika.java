package com.engimon.model.skill;

public class Catastropika extends Skill{
	public Catastropika(){
		super(4,"Catastropika",210,1);
		prereqElmt.add(new Electric());
	}
}
