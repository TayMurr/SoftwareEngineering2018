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
		omap.oceanGrid[shipx][shipy] = true;
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
		
		
		int currentDistance = distance(shipx, x1, shipy, y1);
		System.out.println("current distance" + currentDistance);
		// moving down
		// if it is an option to move down check if moving that way would move you closer to the ship
		if ((shipy + 1) < omap.dimensions &&  omap.oceanGrid[shipx][shipy+1] != true) { // move down
			int distDown = distance(shipx, x1, shipy+1, y1);

			if (distDown < currentDistance) {
				shipy = shipy + 1;
			}
		} else if ((shipy-1) > -1 && omap.oceanGrid[shipx][shipy-1] != true) { // move up
			int distUp = distance(shipx, x1, shipy-1, y1);

			if (distUp < currentDistance) {
				shipy = shipy - 1;

			}
		} else if ((shipx+1) < omap.dimensions && omap.oceanGrid[shipx+1][shipy] != true) { //move right
			int distRight = distance(shipx+1, x1, shipy, y1);

			if (distRight < currentDistance) {
				shipx = shipx + 1;

			}
		} else if ((shipx-1) > -1 && omap.oceanGrid[shipx-1][shipy] != true) { // moveLeft
			int distLeft = distance(shipx-1, x1, shipy, y1);

			if (distLeft < currentDistance) {
				shipx = shipx - 1;

			}
		}
		System.out.println(this.getShipLocationX());
		System.out.println(this.getShipLocationY());

		pirateShipImageView.setX(this.getShipLocationX() * scale);
		pirateShipImageView.setY(this.getShipLocationX() * scale);
		
	}

	// calculate the square of the distance from the pirate ship to the regular ship
	
	public int distance(int x1, int x2, int y1, int y2) {
		return ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1));
	}

}
