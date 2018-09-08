package edu.nd.se2018.homework.homework3;

public class SteadyRunStrategy implements JockeyBehavior {
	@Override
	public void stepOneMinute(Horse horse) {
		horse.minutesRan++;
		horse.milesRan = ((horse.maxSpeed * 0.80) / 60) * horse.minutesRan;
	}
}
