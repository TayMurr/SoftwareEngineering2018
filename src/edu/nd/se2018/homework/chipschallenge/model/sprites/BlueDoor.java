package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BlueDoor extends Door implements Observer {

	public BlueDoor(AnchorPane root, GameGrid gameGrid, Point p) {
		super(root, gameGrid, p);
		Image img = new Image("images/textures/blueKeyWall.png", scale, scale, false,false);
		imgView = new ImageView(img);
		
	}

}
