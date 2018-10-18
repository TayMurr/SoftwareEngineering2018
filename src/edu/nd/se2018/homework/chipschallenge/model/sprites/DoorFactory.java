package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.layout.AnchorPane;

public class DoorFactory {
	// produce a door of the specified color
	public Door createDoor(String doorType, AnchorPane root, GameGrid gameGrid, Point p) {
		
		if (doorType.equals("blue")) {
			return new BlueDoor(root, gameGrid, p);
		} else if (doorType.equals("green")) {
			return new GreenDoor(root, gameGrid, p);
		} else if (doorType.equals("red")) {
			return new RedDoor(root, gameGrid, p);
		} else if (doorType.equals("yellow")) {
			return new YellowDoor(root, gameGrid, p);
		} else {
			return new PortalGate(root, gameGrid, p);
		}
	}
}
