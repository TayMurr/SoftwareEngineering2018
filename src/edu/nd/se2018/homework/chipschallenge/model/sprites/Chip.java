package edu.nd.se2018.homework.chipschallenge.model.sprites;

import java.awt.Point;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Chip {
	private int positionX = 0;
	private int positionY = 0;
	private Image img;
	private ImageView imgView;
	private int scale = 25;
	
	public Chip(Point position, int scale) {
		this.positionX = position.x;
		this.positionY = position.y;
		this.scale = scale;
		img = new Image("images/textures/chipDown.png", scale, scale, false,false);
		imgView = new ImageView(img);
		imgView.setX(this.positionX * scale);
		imgView.setY(this.positionY * scale);
	}
	
	public Node getImageView() {
		return imgView;
	}
	
	public void moveLeft() {
		positionX -= 1;
	}
	
	public void moveRight() {
		positionX += 1;
	}

	public void moveDown() {
		positionY += 1;
	
	}

	public void moveUp() {
		positionY -= 1;
	}
	
	public void setImageViewXY() {
		imgView.setX(positionX * scale);
		imgView.setY(positionY * scale);
	}

	public int getChipLocationX() {
		// TODO Auto-generated method stub
		return positionX;
	}
	
	public int getChipLocationY() {
		// TODO Auto-generated method stub
		return positionY;
	}

}
