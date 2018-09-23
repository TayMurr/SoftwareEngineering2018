package edu.nd.sarec.railwaycrossing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

import edu.nd.sarec.railwaycrossing.model.infrastructure.MapBuilder;
import edu.nd.sarec.railwaycrossing.model.infrastructure.RailwayTracks;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossing.model.infrastructure.TJunction;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossing.model.vehicles.Car;
import edu.nd.sarec.railwaycrossing.model.vehicles.Train;
import edu.nd.sarec.railwaycrossing.model.vehicles.TrainTraffic;
import edu.nd.sarec.railwaycrossing.view.MapDisplay;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.transform.Rotate;

public class Simulation extends Application{
	
	private Pane root;
	private Scene scene;
	private MapBuilder mapBuilder;
	private MapDisplay mapDisplay;
	
	@Override  
	public void start(Stage stage) throws Exception {
		
		root = new Pane();
		
		// Build infrastructure
		mapBuilder = new MapBuilder();
		mapDisplay = new MapDisplay(root, mapBuilder.getRoads(), mapBuilder.getTracks(),mapBuilder.getAllGates());					
		mapDisplay.drawTracks();		
		mapDisplay.drawRoad();
		mapDisplay.drawGate();
		
		scene = new Scene(root,1200,1000);
		stage.setTitle("Railways");
		stage.setScene(scene);
		stage.show();
				
		// Train
		RailwayTracks track = mapBuilder.getTrack("Royal");
		RailwayTracks track1 = mapBuilder.getTrack("aRoyal");

		Train train = new Train(track.getEndX()+100,track.getEndY()-25, Direction.WEST);
		Train train1 = new Train(track1.getStartX()-100,track1.getEndY()+25, Direction.EAST);

		train1.getImageView().setRotationAxis(Rotate.X_AXIS);
		train1.getImageView().setRotationAxis(Rotate.Y_AXIS);
		root.getChildren().add(train.getImageView());
		root.getChildren().add(train1.getImageView());
		
		// Train Traffic
		TrainTraffic trainTraffic = new TrainTraffic();
		trainTraffic.addTrain(train);
		trainTraffic.addTrain(train1);
		
		for(CrossingGate gate: mapBuilder.getAllGates())
			trainTraffic.addObserver(gate);

	
		// Sets up a repetitive loop i.e., in handle that runs the actual simulation
		new AnimationTimer(){

			@Override
			public void handle(long now) {
			
				createCar();
				trainTraffic.move();
				for(CrossingGate gate: mapBuilder.getAllGates())
					gate.operateGate();
				
				
				Collection<Train> trains = trainTraffic.getTrainTraffic();
				for (Train train : trains) {
					if (train.offScreen()) {
						train.reset();
					}
				}

				clearCars();	
				clearIntersections("tJunction1");

			}
		}.start();
	}
	
	// Clears cars as they leave the simulation
	private void clearCars(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){			
			if (road.getCarFactory()!= null){
				ArrayList<Car> junkCars = road.getCarFactory().removeOffScreenCars();	
				mapDisplay.removeCarImages(junkCars);
			}
		}
	}
	
	private void createCar(){
		Collection<Road> roads = mapBuilder.getRoads();
		TJunction tJunction = mapBuilder.getTJunction("tJunction1");
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 100) == 15){
					Car car = road.getCarFactory().buildCar();
					if (car != null){
						// Add car to the TJunction corresponding 
						if (road.getName() == "Western Highway") {
							tJunction.getroadDivide("NE").add(car);
						} else if (road.getName() == "Skyway") {
							tJunction.getroadDivide("NW").add(car);
						}
						root.getChildren().add(car.getImageView());
					}
				}
			}
		}
	}
	
	private void clearIntersections(String name) {
		TJunction tJunction = mapBuilder.getTJunction(name);
		HashMap<String, Collection<Car>> roadDivides = tJunction.getAllRoadDivides();
		Vector<Car> ne = (Vector<Car>)roadDivides.get("NE");
		Vector<Car> se = (Vector<Car>)roadDivides.get("SE");
		Vector<Car> ew = (Vector<Car>)roadDivides.get("EW");
		Vector<Car> nw = (Vector<Car>)roadDivides.get("NW");
		Vector<Car> sw = (Vector<Car>)roadDivides.get("SW");
		
		Car car = null;
		Car car1 = null;
		Car car2 = null;
		Car car3 = null;
		Car car4 = null;
		Car car5 = null;


		if (ne.size() > 0) {

			car = ne.get(0);
	
			
			//System.out.println(car.getVehicleY());
			if (car.getVehicleY() > 782 && car.getVehicleY() < 818 && car.isHeadedWest()) {
				System.out.println("turn left");
				ne.remove(0);
				car.deleteObservers();

				if (ew.size() > 0) {
					System.out.println("there is a car on ew to follow");
					car2 = ew.get(ew.size()-1);
					car2.addObserver(car);
				} else {
					System.out.print("nothing is east west. begin leading");
					car.removeLeadCarX();
				}
				
				ew.add(car);
				
				if (se.size() > 0) {
					car1 = se.get(se.size()-1);
					car1.deleteObservers(); // delete old observer
					System.out.println("there is a car on se to follow");
					if (ne.size() > 0) {
						Car newCar = ne.get(0); // following car should continue south either as new leader of following another car
						car1.addObserver(newCar);
						System.out.println("follow se car past intersection");
					}
				} else if (ne.size() > 0) {
					Car newCar = ne.get(0);
					newCar.removeLeadCar();
					System.out.println("nothing is south east. Begin leading");

				}
				
			} else if (car.getVehicleY() > 782 && !car.isHeadedWest()) {
				ne.remove(0);
				se.add(car);
			}
		}
		
		
	
		if (ew.size() > 0) { // the east west road has cars in it check if they need to switch roads
			car5 = ew.get(0);
			if (car5.getVehicleX() > 370 && car5.getVehicleX() < 390) {
				ew.remove(0);
				car5.deleteObservers();
				
				if (ew.size() > 0) { // if a car was following the one just removed
					Car newCar = ew.get(0);
					newCar.removeLeadCar();
				}
				
				if (sw.size() > 0) {
					car3 = sw.get(sw.size()-1);
					car3.deleteObservers(); // tell the cars in road behind not to observe anymore
					car3.addObserver(car5);
				} else {
					car5.removeLeadCar(); // this is just sanity check as it has already occured since the first car out of ew already has no leader
				}
				sw.add(car5);
	
			
				
				if (nw.size() > 0) {
					car4 = nw.get(0);
					car5.addObserver(car4);
				}
							
			}
		}
		
		if (nw.size() > 0) {
			car4 = nw.get(0);
			if (car4.getVehicleY() > 782 ) {
				nw.remove(0);
				sw.add(car4);
			}
		}
		
		ArrayList<Car> toDelete = new ArrayList<Car>();
		for(Car c: se){					
			if (c.offScreen())
				toDelete.add(c);
			
		}   
		
		for (Car c: toDelete)
			se.remove(c);
		
		toDelete.clear();
		
		for(Car c: sw){					
			if (c.offScreen())
				toDelete.add(c);
			
		}   
		
		for (Car c: toDelete)
			sw.remove(c);
		
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

