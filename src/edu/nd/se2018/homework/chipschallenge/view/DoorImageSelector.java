package edu.nd.se2018.homework.chipschallenge.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DoorImageSelector implements IImageSelector {
private int scale = 25;
	
	public ImageView selectColor(String keyColor) {
		if (keyColor.equals("blue")) {
			return new ImageView(new Image("images/textures/blueKeyWall.png", scale, scale, false,false));
			
		} else if (keyColor.equals("green")) {
			return new ImageView(new Image("images/textures/greenKeyWall.png", scale, scale, false,false));

		} else if (keyColor.equals("yellow")) {
			return new ImageView(new Image("images/textures/yellowKeyWall.png", scale, scale, false,false));

		} else {
			return new ImageView(new Image("images/textures/redKeyWall.png", scale, scale, false,false));

		}
	}
}
