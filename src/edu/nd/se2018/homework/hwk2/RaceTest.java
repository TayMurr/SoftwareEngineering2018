package edu.nd.se2018.homework.hwk2;

import org.junit.Test;

public class RaceTest {

	@Test
	public void test1() {
		Race race = new Race();
		
		race.enrollHorse("Mouse", 0, 24, new EarlySprintStrategy());
		race.enrollHorse("Buddy", 1, 26, new SlowStartStrategy());
		race.enrollHorse("Fred", 2, 23, new EarlySprintStrategy());
		race.enrollHorse("Secretariat", 3, 27, new SlowStartStrategy());
		
		assert(race.runRace().equals("Winner is Secretariat"));
		
	}
	
	@Test
	public void test2() {
		Race race = new Race();
		
		race.enrollHorse("Buck", 0, 80, new EarlySprintStrategy());
		race.enrollHorse("Shadow", 1, 10, new SlowStartStrategy());
		race.enrollHorse("Joey", 2, 36, new SteadyRunStrategy());

		assert(race.runRace().equals("Winner is Buck"));
		
	}
	
	@Test
	public void test3() {
		Race race = new Race();
		
		race.enrollHorse("Sam", 0, 22, new SteadyRunStrategy());
		race.enrollHorse("Molly", 1, 24, new SlowStartStrategy());
	
		
		assert(race.runRace().equals("Winner is Molly"));
		
	}
}
