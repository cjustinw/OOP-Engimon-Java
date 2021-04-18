package com.engimon.model.skill;

public class BoneRush extends Skill{
	public BoneRush(){
		super(20,"Bone Rush",50,1);
		prereqElmt.add(new Ground());
	}
}
