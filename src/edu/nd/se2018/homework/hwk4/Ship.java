package edu.nd.se2018.homework.hwk4;

import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable {
	int x = 14;
	int y = 14;
	OceanMap omap;
	int scale;
	
	public Ship(OceanMap omap) {
		this.omap = omap;
	}
	
	public int getShipLocationX() {
		return this.x;
	}
	
	public int getShipLocationY() {
		return this.y;
	}

	public void moveRight() {
		int temp = this.x + 1;
		if (temp < omap.dimensions && omap.oceanGrid[temp][this.y] != true) {
			this.x = temp;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers(); 
		}
		
		
	}

	public void moveLeft() {
		int temp = this.x - 1;
		if (temp > -1 && omap.oceanGrid[temp][this.y] != true) {
			this.x = temp;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers(); 
		}
		
	}

	public void moveDown() {
		int temp = this.y + 1;
		if (temp < omap.dimensions && omap.oceanGrid[(int) this.x][(int) temp] != true) {
			this.y = temp;

			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();
		}
		 
	}

	public void moveUp() {
		int temp = this.y - 1;
		if (temp > -1  && omap.oceanGrid[(int) this.x][(int) temp] != true) {
			this.y = temp;
			setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
			notifyObservers();
		}
		 
	}
}
