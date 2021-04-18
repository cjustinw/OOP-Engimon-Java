package com.engimon.model.skill;

public class WaterPulse extends Skill{
	public WaterPulse(){
		super(25,"Water Pulse",60,1);
		prereqElmt.add(new Water());
	}
}
