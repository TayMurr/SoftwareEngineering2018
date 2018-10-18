package edu.nd.se2018.homework.chipschallenge.model.level;



import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class GameGrid {

	public Boolean gameGrid[][] = new Boolean [25][25];
	public final int dimensions = 25;
	int scale;
	public int portalX = 12;
	public int portalY = 0;
	private AnchorPane root;

	public GameGrid(AnchorPane root) {
		this.root = root;
	}


	public void drawMap(int scale) {
		this.scale = scale;
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK);
				Image img = new Image("/images/textures/BlankTile.png");
				rect.setFill(new ImagePattern(img));
				root.getChildren().add(rect);
				gameGrid[x][y] = false;
			}
		}
		
		Rectangle rect = new Rectangle(portalX * scale, portalY * scale, scale, scale);
		rect.setStroke(Color.BLUE);
		Image img = new Image("/images/textures/portal.png");
		rect.setFill(new ImagePattern(img));
		root.getChildren().add(rect);		
		
	}
	
	
	public void drawLevelOne() {
		// Borders
		drawVerticalLine(0, 0, 24);
		drawVerticalLine(24, 0, 24);
		drawHorizontalLine(1, 1, 11);
		drawHorizontalLine(13, 1, 23);

		//Left Rooms
		drawVerticalLine(6, 2, 5);
		drawHorizontalLine(1, 5, 4);
		drawVerticalLine(4, 7, 9);
		drawHorizontalLine(1, 8, 4);
		drawHorizontalLine(1, 11, 10);
		drawVerticalLine(4, 11, 17);
		drawHorizontalLine(4, 17, 20);
		
		// Right Rooms
		
		drawVerticalLine(18, 2, 5);
		drawHorizontalLine(20, 5, 23);
		drawVerticalLine(20, 7, 9);
		drawHorizontalLine(21, 8, 23);
		drawHorizontalLine(14, 11, 23);
		drawVerticalLine(12, 11, 17);
		drawVerticalLine(20, 11, 17);

	}
	
	public void drawLevelTwo() {
		drawMap(scale);
		// vertical borders
		drawVerticalLine(0, 2, 24);
		drawVerticalLine(24, 2, 24);
		// top bars
		drawHorizontalLine(0, 0, 11);
		drawHorizontalLine(13, 0, 24);
		drawHorizontalLine(0, 1, 11);
		drawHorizontalLine(13, 1, 24);
		
		drawHorizontalLine(8, 21, 23);
		drawHorizontalLine(1, 17, 16);
		drawHorizontalLine(8, 13, 23);
		drawHorizontalLine(1, 9, 16);	
		drawHorizontalLine(8, 5, 23);
		
		drawVerticalLine(12, 20, 20);
		drawVerticalLine(12, 16, 18);
		drawVerticalLine(12, 12, 14);
		drawVerticalLine(12, 8, 10);
		drawVerticalLine(12, 4, 6);
		drawVerticalLine(19, 2, 2);
		drawVerticalLine(19, 4, 4);



	}
	
	
	public void drawVerticalLine(int startX, int startY, int endY) {
		for (int y = startY; y <= endY && y < dimensions; y++) {
			Rectangle rect = new Rectangle(startX * scale, y * scale, scale, scale);
			rect.setStroke(Color.BLACK);

			Image img = new Image("/images/textures/darktile.png");
			rect.setFill(new ImagePattern(img));
			root.getChildren().add(rect);
			gameGrid[startX][y] = true;
		}
	}
	
	public void drawHorizontalLine(int startX, int startY, int endX) {
		for (int x = startX; x <= endX && x < dimensions; x++) {
			Rectangle rect = new Rectangle(x * scale, startY * scale, scale, scale);
			rect.setStroke(Color.BLACK);

			Image img = new Image("/images/textures/darktile.png");
			rect.setFill(new ImagePattern(img));
			root.getChildren().add(rect);
			gameGrid[x][startY] = true;
		}
	}



}
