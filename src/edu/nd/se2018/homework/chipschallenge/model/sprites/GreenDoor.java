package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;
import java.util.Observer;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.layout.AnchorPane;

public class GreenDoor extends Door implements Observer {

	public GreenDoor(AnchorPane root, GameGrid gameGrid, Point p) {
		super(root, gameGrid, p);
		imgView = imageSelector.selectColor("green");
		imgView.setX(p.x * scale);
		imgView.setY(p.y * scale);
	}

}
