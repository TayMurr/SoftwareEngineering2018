package edu.nd.se2018.homework.chipschallenge.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class KeyImageSelector {
	private int scale = 25;
	
	public ImageView selectKeyColor(String keyColor) {
		if (keyColor.equals("blue")) {
			return new ImageView(new Image("images/textures/blueKey.png", scale, scale, false,false));
			
		} else if (keyColor.equals("green")) {
			return new ImageView(new Image("images/textures/greenKey.png", scale, scale, false,false));

		} else if (keyColor.equals("yellow")) {
			return new ImageView(new Image("images/textures/yellowKey.png", scale, scale, false,false));

		} else {
			return new ImageView(new Image("images/textures/redKey.png", scale, scale, false,false));

		}
	}

}
