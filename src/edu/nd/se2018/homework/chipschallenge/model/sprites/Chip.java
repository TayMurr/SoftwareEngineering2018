package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip extends Sprite {

	public Chip(Point position, int scale, GameGrid gameGrid) {
		super(position, scale, gameGrid);
		setImage("images/textures/chipDown.png");
	}

	@Override
	public void setImage(String direction) {
		// TODO Auto-generated method stub
		if (direction.equals("left")) {
			
			imgView = new ImageView(new Image("images/textures/chipLeft.png", scale, scale, false, false));
		} else if (direction.equals("right")) {
			imgView = new ImageView(new Image("images/textures/chipRight.png", scale, scale, false, false));

		} else if (direction.equals("up")) {
			imgView = new ImageView(new Image("images/textures/chipUp.png", scale, scale, false, false));

		} else if (direction.equals("down")) {
			imgView = new ImageView(new Image("images/textures/chipDown.png", scale, scale, false, false));

		}
		
		imgView.setX(positionX * scale);
		imgView.setY(positionY * scale);
	}


}
