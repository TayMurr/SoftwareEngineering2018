package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Door implements Observer{
	private AnchorPane root;
	private GameGrid gameGrid;
	protected ImageView imgView;
	private Point position;
	protected int scale = 25;
	public Door (AnchorPane root, GameGrid gameGrid, Point p) {
		this.root = root;
		this.gameGrid = gameGrid;
		this.position = p;
		gameGrid.gameGrid[position.x][position.y] = true;

	}
	public void unlock() {
		root.getChildren().remove(imgView);
		gameGrid.gameGrid[position.x][position.y] = false;
	}
	public ImageView getImageView() {
		return imgView;
	}
	
	public Point getDoorPoint() {
		return position;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Key) {
			unlock();
		}
		
	};
}
