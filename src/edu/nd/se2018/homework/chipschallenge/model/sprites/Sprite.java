package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Sprite {
	protected int positionX = 0;
	protected int positionY = 0;
	protected Image img;
	protected ImageView imgView;
	protected int scale = 25;
	private int startX;
	private int startY;
	private int pathWidth = 5;
	private int pathHeight = 2;
	GameGrid gameGrid;
	
	
	
	public Sprite(Point position, int scale, GameGrid gameGrid) {
		this.positionX = position.x;
		this.positionY = position.y;
		this.scale = scale;
		this.startX = position.x;
		this.startY = position.y;
		this.gameGrid = gameGrid;
		setImage("up");
	}
	
	public abstract void setImage(String direction);
	
	public Node getImageView() {
		return imgView;
	}
	
	public void moveLeft() {
	
		int temp = positionX - 1;

		if (temp > -1 && gameGrid.gameGrid[temp][positionY] != true) {
			this.positionX = temp;
		}
		setImage("left");
	}
	
	public void moveRight() {
		
		int temp = positionX + 1;
		
		if (temp < gameGrid.dimensions && gameGrid.gameGrid[temp][positionY] != true) {
			this.positionX = temp;
		}
		setImage("right");

	}

	public void moveDown() {
		int temp = positionY + 1;

		if (temp < gameGrid.dimensions && gameGrid.gameGrid[positionX][temp] != true) {
			this.positionY = temp;
		}
		setImage("down");

	}

	public void moveUp() {
		
		int temp = positionY - 1;

		if (temp > -1 && gameGrid.gameGrid[positionX][temp] != true) {
			this.positionY = temp;
		}
		setImage("up");

	}
	
	public ImageView getImageViewXY() {
		return imgView;
	}
	
	public void setImageViewXY() {
		imgView.setX(positionX * scale);
		imgView.setY(positionY * scale);
	}

	public int getLocationX() {
		return positionX;
	}
	
	public int getLocationY() {
		return positionY;
	}
	
	public Point getPoint() {
		return new Point(positionX, positionY);
	}

	public void setPosition(Point point) {
		positionX = point.x;
		positionY = point.y;
		imgView.setX(this.positionX * scale);
		imgView.setY(this.positionY * scale);
	}

	public void move() {
		
		if (positionX < startX + pathWidth && positionY < startY + pathHeight) {
			moveRight();
		} 
		if (positionX == startX + pathWidth && positionY < startY + pathHeight) {
			moveDown();
		} 
		if (positionY == startY + pathHeight && positionX <= startX + pathWidth) {
			moveLeft();
		}
		if (positionX == startX && positionY <= startY + pathHeight) {
			moveUp();
		}
		
	}

	protected Image getImg() {
		return img;
	}
	
	protected void setImg(Image img) {
		this.img = img;
	}
}
