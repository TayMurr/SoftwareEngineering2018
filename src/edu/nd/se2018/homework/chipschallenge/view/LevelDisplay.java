package edu.nd.se2018.homework.chipschallenge.view;

import java.awt.Point;
import java.util.HashMap;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import edu.nd.se2018.homework.chipschallenge.model.sprites.ComputerChip;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Door;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Key;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class LevelDisplay {

	AnchorPane root;
	private int scale = 25;
	
	public LevelDisplay(AnchorPane root, GameGrid gameGrid){
		this.root = root;
	
	}

	public void drawLevelOne(HashMap<Point, ComputerChip> compChips, HashMap<Point, Door> doors, HashMap<Point, Key> keys) {
		for (Point p: compChips.keySet()) {
			Rectangle rect = new Rectangle(p.x * scale, p.y * scale, scale, scale);
			rect.setStroke(Color.BLACK);
			Image img = new Image("/images/textures/compchip.png");
			rect.setFill(new ImagePattern(img));
			root.getChildren().add(rect);
			compChips.get(p).setImageRectangle(rect);
			
		}
		
		for (Point p: doors.keySet()) {
			ImageView imgView = doors.get(p).getImageView();
			imgView.setX(p.x * scale);
			imgView.setY(p.y * scale);
			root.getChildren().add(imgView);
		}
		
		for (Point p: keys.keySet()) {
			ImageView imgView = keys.get(p).getImageView();
			imgView.setX(p.x * scale);
			imgView.setY(p.y * scale);
			root.getChildren().add(imgView);
		}
	}

	
	
}
