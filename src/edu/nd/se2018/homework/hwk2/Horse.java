package edu.nd.se2018.homework.hwk2;

public class Horse {
	
	JockeyBehavior jockeybehavior;
	String name;
	int index;
	double maxSpeed;
	double milesRan = 0;
	int minutesRan  = 0;
	
	public Horse(String name, int index, double maxSpeed, JockeyBehavior jockeybehavior) {
		this.name = name;
		this.index = index;
		this.maxSpeed = maxSpeed;
		this.jockeybehavior = jockeybehavior;
	}
	
	public void setJockeyBehavior(JockeyBehavior jockeybehavior){
		this.jockeybehavior = jockeybehavior;
	}

	public void update() {
		jockeybehavior.stepOneMinute(this);
	}

	public double printMiles() {
		System.out.println(name + " has run " + milesRan);
		return milesRan;
	}
	

}
