package edu.nd.se2018.homework.homework3;

import java.util.ArrayList;

public class Race {
	ArrayList<Horse> horseList;
	
	public Race() {
		horseList = new ArrayList<Horse>();
	}
	
	public void enrollHorse(String name, int index, int maxSpeed, JockeyBehavior jockeybehavior) {
		horseList.add(new Horse(name, index, maxSpeed, jockeybehavior));
	}
	
	public void runRace() {
		
		while (true) {
			
			for (Horse horse : horseList) {
				horse.update();
				horse.printMiles();
			}

			double maxDistance = 0;
			double tempDistance;
			String topHorse = "";
			for (Horse horse: horseList) {
				tempDistance = horse.milesRan;
				if (tempDistance > maxDistance) {
					maxDistance = tempDistance;
					topHorse = horse.name;
				}
			}
			
			// announce
			if (maxDistance >= 10.0) {
				System.out.println(topHorse + " is the winner");
				break;
			}
			
		}
		
	}
}
