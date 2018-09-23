package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import edu.nd.sarec.railwaycrossing.model.vehicles.Car;


public class TJunction {
	
	/* TJunction uses a hash tables to create the notions of cars on certain rows
	 * The logic in Simulation.java implements the notion of interstion */

	HashMap<String, Collection<Car>> roadDivides;

	public TJunction () {
		roadDivides = new HashMap<String, Collection<Car>>();
		buildRoadDivides();
	}

	private void buildRoadDivides() {
		roadDivides.put("NE", new Vector<Car>());
		roadDivides.put("SE", new Vector<Car>());
		roadDivides.put("EW", new Vector<Car>());
		roadDivides.put("NW", new Vector<Car>());
		roadDivides.put("SW", new Vector<Car>());

	}

	public HashMap<String, Collection<Car>> getAllRoadDivides() {
		return roadDivides;
	}
	
	public Collection<Collection<Car>> getroadDivides() {
		return roadDivides.values();
	}

	public void setroadDivides(HashMap<String, Collection<Car>> intersectionSegments) {
		this.roadDivides = intersectionSegments;
	}
	
	public Collection<Car> getroadDivide(String name) {
		return roadDivides.get(name);
	}
	
}
