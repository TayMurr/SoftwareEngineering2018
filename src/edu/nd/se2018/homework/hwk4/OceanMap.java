package edu.nd.se2018.homework.hwk4;


import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;


public class OceanMap {

	Boolean oceanGrid[][] = new Boolean [25][25];
	final int dimensions = 25;
	int scale;
	int islands = 10;
	public void drawMap(ObservableList<Node> root, int scale) {
		this.scale = scale;
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.PALETURQUOISE);
				root.add(rect);
				oceanGrid[x][y] = false;
			}
		}
		
	}
	
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
	}
	
	
}
