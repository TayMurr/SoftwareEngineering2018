package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer {
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double leadCarX = -1;
	private double speed = 0.5;
	boolean canMove = true;
	boolean headWest;
	boolean travelingEW = false;
	private String leadCarMessage = "going south";
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
		Random ran = new Random();
		if (ran.nextInt(2) == 1) {
			headWest = true;
		} else {
			headWest = false;

		}
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public Boolean getMovement() {
		return canMove;
	}
	
	public void move(){
		boolean canMove = true; 

		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
			canMove = false;
		
		// Second case. Car is too close too other car.
		if (leadCarMessage == "going south" && leadCarY != -1 && getDistanceToLeadCarY() < 50) // TODO always calculates y distance needs fixing for EW road
			canMove = false;
	
		if (leadCarMessage == "going west" && leadCarX != -1 &&  getDistanceToLeadCarX() < 50) // TODO always calculates y distance needs fixing for EW road
			canMove = false;
		
		if (canMove){ 
			if (headWest && (currentY > 782) && (currentY < 818)) {
					currentX-=speed;
					travelingEW = true;
					if ((currentX > 370) && (currentX < 390)) {
						headWest = false;
						travelingEW = false;

					}
			} else {
				currentY+=speed;
				travelingEW = false;
			}
			
		}
		
		
		ivCar.setX(currentX);
		ivCar.setY(currentY);
		setChanged();
		if (travelingEW) {
			notifyObservers("going west");
		} else {
			notifyObservers("going south");
		}
	


	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public void setMovementFlag(boolean canMove) {
		this.canMove = canMove;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	public double getDistanceToLeadCarX() {
		return Math.abs(leadCarX-getVehicleX());
		
	}
	
	public double getDistanceToLeadCarY() {
		return Math.abs(leadCarY-getVehicleY());
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
	}
	
	public void removeLeadCarX(){
		leadCarX = -1;
	}

	public boolean entertingJunction() {
		if ((currentY > 782) && (currentY < 818)) {
			return true;
		} 
		
		return false;
	}
	
	public boolean exitingJunction() {
		if (currentX > 370 && currentX < 390) {
			return true;
		}
		return false;
	}
	
	public boolean isHeadedWest() {
		return headWest;
	}
	
	public boolean isTravelingEW() {
		
		if (headWest && (currentY > 782) && (currentY < 818)) {
			travelingEW = true;
			if ((currentX > 370) && (currentX < 390)) {
				travelingEW = false;
			}
		}
		return travelingEW;
	}


	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCarMessage = (String)arg1;
			leadCarY = (((Car)o).getVehicleY());
			leadCarX = (((Car)o).getVehicleX());
			if (leadCarY > 1020)
				leadCarY = -1;
			if (leadCarX < 390)
				leadCarX = -1;
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}				
	}	
}
