package com.engimon.model.skill;

public class MudShot extends Skill{
	public MudShot(){
		super(13,"Mud Shot",90,1);
		prereqElmt.add(new Ground());
	}
}
