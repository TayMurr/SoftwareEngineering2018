package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;
import java.util.Observer;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.layout.AnchorPane;

public class YellowDoor extends Door implements Observer {

	public YellowDoor(AnchorPane root, GameGrid gameGrid, Point p) {
		super(root, gameGrid, p);
		imgView = imageSelector.selectColor("yellow");
		imgView.setX(p.x * scale);
		imgView.setY(p.y * scale);
	}


}
