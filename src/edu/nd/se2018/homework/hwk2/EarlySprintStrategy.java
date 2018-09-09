package edu.nd.se2018.homework.hwk2;

public class EarlySprintStrategy implements JockeyBehavior {
		
	@Override
	public void stepOneMinute(Horse horse) {
		horse.minutesRan++;
			
		if (horse.milesRan > 2) { 
			horse.milesRan = (horse.maxSpeed * 0.75 / 60) * horse.minutesRan;

		} else {
			horse.milesRan = (horse.maxSpeed / 60) * horse.minutesRan;
		}
		
	}
}
