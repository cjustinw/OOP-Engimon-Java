package com.engimon.model.skill;

public class Buldoze extends Skill{
	public Buldoze(){
		super(21,"Buldoze",90,1);
		prereqElmt.add(new Ground());
	}
}
