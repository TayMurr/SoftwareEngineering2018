package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bug extends Sprite {

	public Bug(Point position, int scale, GameGrid gameGrid) {
		super(position, scale, gameGrid);		
		setImage("images/textures/bugUp.png");
	}

	@Override
	public void setImage(String direction) {
			if (direction.equals("left")) {
				imgView = new ImageView(new Image("images/textures/bugLeft.png", scale, scale, false, false));
			} else if (direction.equals("right")) {
				imgView = new ImageView(new Image("images/textures/bugRight.png", scale, scale, false, false));
			} else if (direction.equals("up")) {
				imgView = new ImageView(new Image("images/textures/bugUp.png", scale, scale, false, false));
			} else if (direction.equals("down")) {
				imgView = new ImageView(new Image("images/textures/bugDown.png", scale, scale, false, false));
			}
				
				
			imgView.setX(this.positionX * scale);
			imgView.setY(this.positionY * scale);
		
	}

}
