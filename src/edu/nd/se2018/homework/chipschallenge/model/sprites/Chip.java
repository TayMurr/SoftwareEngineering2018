package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip {
	private int positionX = 0;
	private int positionY = 0;
	private Image img;
	private ImageView imgView;
	private int scale = 25;
	GameGrid gameGrid;
	
	
	public Chip(Point position, int scale, GameGrid gameGrid) {
		this.positionX = position.x;
		this.positionY = position.y;
		this.scale = scale;
		img = new Image("images/textures/chipDown.png", scale, scale, false,false);
		imgView = new ImageView(img);
		imgView.setX(this.positionX * scale);
		imgView.setY(this.positionY * scale);
		this.gameGrid = gameGrid;
	}
	
	public Node getImageView() {
		return imgView;
	}
	
	public void moveLeft() {
	
		int temp = positionX - 1;

		if (temp > -1 && gameGrid.gameGrid[temp][positionY] != true) {
			this.positionX = temp;
		}
	}
	
	public void moveRight() {
		
		int temp = positionX + 1;
		
		if (temp < gameGrid.dimensions && gameGrid.gameGrid[temp][positionY] != true) {
			this.positionX = temp;
		}
	}

	public void moveDown() {
		int temp = positionY + 1;

		if (temp < gameGrid.dimensions && gameGrid.gameGrid[positionX][temp] != true) {
			this.positionY = temp;
		}
	}

	public void moveUp() {
		
		int temp = positionY - 1;

		if (temp > -1 && gameGrid.gameGrid[positionX][temp] != true) {
			this.positionY = temp;
		}
	}
	
	public void setImageViewXY() {
		imgView.setX(positionX * scale);
		imgView.setY(positionY * scale);
	}

	public int getChipLocationX() {
		return positionX;
	}
	
	public int getChipLocationY() {
		return positionY;
	}
	
	public Point getChipPoint() {
		return new Point(positionX, positionY);
	}

}
