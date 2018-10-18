package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.util.Observable;

import edu.nd.se2018.homework.chipschallenge.view.IImageSelector;
import edu.nd.se2018.homework.chipschallenge.view.KeyImageSelector;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Key extends Observable {

	private AnchorPane root;
	ImageView imgView;
	IImageSelector imgSelector;
	
	public Key (AnchorPane root, String keyColor) {
		this.root = root;
		imgSelector = new KeyImageSelector();
		imgView = imgSelector.selectColor(keyColor);		
	}
	


	public void remove() {
		root.getChildren().remove(imgView);
		setChanged();
		notifyObservers();
	}



	public ImageView getImageView() {
		return imgView;
	}
}
