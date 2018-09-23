package edu.nd.sarec.railwaycrossing.model.infrastructure;

import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import edu.nd.sarec.railwaycrossing.model.vehicles.Car;


public class TJunction {
	
	/* TJunction uses multiple vectors */
	Collection<Car> NE;
	Collection<Car> SE;
	Collection<Car> EW;
	Collection<Car> NW;
	Collection<Car> SW;

	HashMap<String, Collection<Car>> intersectionSegments;

	public TJunction () {
		
	}
	
	
	
}
