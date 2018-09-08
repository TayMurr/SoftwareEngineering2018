package edu.nd.se2018.homework.homework3;

public class EarlySprintStrategy implements JockeyBehavior {
	
	boolean twoMileSwitch = true; // switch maxSpeed once
	
	@Override
	public void stepOneMinute(Horse horse) {
		horse.minutesRan++;
		
		horse.milesRan = (horse.maxSpeed / 60) * horse.minutesRan;
	
		if ((horse.milesRan > 2) && twoMileSwitch) { 
			horse.maxSpeed = horse.maxSpeed * 0.75;
			twoMileSwitch = false;
		}
		
	}
}
