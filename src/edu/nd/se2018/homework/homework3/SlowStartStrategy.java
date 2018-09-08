package edu.nd.se2018.homework.homework3;

public class SlowStartStrategy implements JockeyBehavior {
	
	@Override
	public void stepOneMinute(Horse horse) {	
		
		horse.minutesRan++;
		if (horse.milesRan <= 6) { 
			horse.milesRan = ((horse.maxSpeed * 0.75) / 60) * horse.minutesRan;
		} else if (horse.milesRan > 6 && horse.milesRan <= 9) {
			horse.milesRan = ((horse.maxSpeed * 0.90) / 60) * horse.minutesRan;
		} else {
			horse.milesRan = (horse.maxSpeed / 60) * horse.minutesRan;
		}
	}
}
