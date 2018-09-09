package edu.nd.se2018.homework.hwk2;

import java.util.ArrayList;

public class Race {
	ArrayList<Horse> horseList;
	
	public Race() {
		horseList = new ArrayList<Horse>();
	}
	
	public void enrollHorse(String name, int index, int maxSpeed, JockeyBehavior jockeybehavior) {
		horseList.add(new Horse(name, index, maxSpeed, jockeybehavior));
	}
	
	
	
	public String runRace() {
		String winnerMessage = "";
		
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
			
			if (maxDistance >= 10.0) {
				winnerMessage = "Winner is " + topHorse;
				break;
			}
			
		}
		
		System.out.println(winnerMessage);
		return winnerMessage;
		
		
	}
}
