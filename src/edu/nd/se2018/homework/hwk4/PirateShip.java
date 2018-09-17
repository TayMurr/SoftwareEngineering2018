package edu.nd.se2018.homework.hwk4;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PirateShip implements Observer {

	OceanMap omap;
	int scale;
	int shipx, shipy, x1, y1; // shipx, shipy are the x and y coordinates of the pirate ship and x1 and y1 are the regular ship
	int minDistance;
	Image pirateShipImage;
	ImageView pirateShipImageView;
	Random rand = new Random(System.currentTimeMillis());

	public PirateShip(OceanMap omap) {
		this.omap = omap;
		this.scale = omap.scale;
		shipx = rand.nextInt(scale-1);
		shipy = rand.nextInt(scale-1);
		pirateShipImage = new Image("images/pirateship.gif",scale, scale, true, true);
		pirateShipImageView = new ImageView(pirateShipImage);

	}
	
	public ImageView getImageView() {
		return pirateShipImageView;
	}
	
	public int getShipLocationX() {
		return shipx;
	}
	
	public int getShipLocationY() {
		return shipy;
	}
	
	public void setShipLocation(int x, int y) {
		shipx = x;
		shipy = y;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Ship) {
			x1 =  ((Ship)o).getShipLocationX();
			y1 = ((Ship)o).getShipLocationY();

			movePirate();
		}
	}
	
	private void movePirate() {
		shipx = this.getShipLocationX();
		shipy = this.getShipLocationY();
		
		// use distance function to determine direction to move closer
		int currentDistanceX = shipx - x1;
		int currentDistanceY = shipx - x1;

		// moving down
		// if it is an option to move down check if moving that way would move you closer to the ship
		if (currentDistanceX > 0) {
			if ((shipx-1) > -1 && omap.oceanGrid[shipx-1][shipy] != true) { // moveLeft

				shipx = shipx - 1;
			}
			
		} else {
			if ((shipx+1) < omap.dimensions && omap.oceanGrid[shipx+1][shipy] != true) { //move right
				shipx = shipx + 1;
			}
		} 
		
		if (currentDistanceY > 0) {
			if ((shipy-1) > -1 && omap.oceanGrid[shipx][shipy-1] != true) { // move up
				shipy = shipy - 1;
			}
		} else {
			if ((shipy + 1) < omap.dimensions &&  omap.oceanGrid[shipx][shipy+1] != true) { // move down
				shipy = shipy + 1;

			} 
		}
		

		System.out.println(this.getShipLocationX());
		System.out.println(this.getShipLocationY());

		pirateShipImageView.setX(this.getShipLocationX() * scale);
		pirateShipImageView.setY(this.getShipLocationX() * scale);
		
	}


}
