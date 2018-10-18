package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import edu.nd.se2018.homework.chipschallenge.view.DoorImageSelector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class RedDoor extends Door implements Observer {

	public RedDoor(AnchorPane root, GameGrid gameGrid, Point p) {
		super(root, gameGrid, p);
		imgView = imageSelector.selectColor("red");
		imgView.setX(p.x * scale);
		imgView.setY(p.y * scale);
	}

}
