package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	private Direction direction;
	
	// TODO direction of train
	public Train(int x, int y, Direction direction){
		this.currentX = x;
		this.currentY = y;
		this.direction = direction;
		originalX = x;
		img = new Image("images/Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public void setVehicleX(double x){
		currentX = x;
	}
	
	
	public void move(){
		if (direction == Direction.WEST) {
			currentX-=2;
		} else {
			currentX+=2;
		}
		
		/*imgView.setX(currentX);
		setChanged();
		notifyObservers();*/
	}
	
	public boolean offScreen(){
		if ((this.getTrainDirection() == Direction.WEST  && currentX < -200) || (this.getTrainDirection() == Direction.EAST  && currentX > 1400))
			return true;
		else
			return false;				
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
	
	public Direction getTrainDirection() {
		return direction;
	}
}