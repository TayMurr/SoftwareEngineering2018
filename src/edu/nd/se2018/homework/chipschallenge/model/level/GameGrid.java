package edu.nd.se2018.homework.chipschallenge.model.level;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class GameGrid {

	Boolean gameGrid[][] = new Boolean [25][25];
	final int dimensions = 25;
	int scale;
	
	public void drawMap(ObservableList<Node> root, int scale) {
		this.scale = scale;
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				Image img = new Image("/images/textures/BlankTile.png");
				rect.setFill(new ImagePattern(img));
				root.add(rect);
				gameGrid[x][y] = false;
			}
		}
		
	}
	
	/*
	public void placeIslands(ObservableList<Node> root) {
		Random r = new Random();
		int i = 0;
		int randX, randY;
		while (i < islands) {
			randX = r.nextInt(dimensions);
			randY = r.nextInt(dimensions);
			if (oceanGrid[randX][randY] != true) {
				Rectangle rect = new Rectangle(randX * scale, randY * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.ANTIQUEWHITE);
				root.add(rect);
				oceanGrid[randX][randY] = true;
				i++;
			}
		}
	}*/
}
