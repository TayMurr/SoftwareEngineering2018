package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import java.util.HashMap;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import edu.nd.se2018.homework.chipschallenge.model.level.LevelBuilder;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Chip;
import edu.nd.se2018.homework.chipschallenge.model.sprites.ComputerChip;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Door;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Key;
import edu.nd.se2018.homework.chipschallenge.view.LevelDisplay;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game  extends Application {
	private LevelDisplay levelDisplay;
	private LevelBuilder levelBuilder;
	private GameGrid gameGrid;
	private AnchorPane root;
	private HashMap<Point, ComputerChip> compchips;
	private HashMap<Point, Door> doors;
	private HashMap<Point, Key> keys;

	ImageView chipImageView;

	private Chip chip;
	private Scene scene;
	final int scale = 25;
	int chipCount = 11;
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		gameGrid = new GameGrid(root);
		gameGrid.drawMap(scale);
		gameGrid.drawLevelOne(); // draw level one
		// build the level objects
		levelBuilder = new LevelBuilder(root, gameGrid);
		levelBuilder.buildLvlOne();
		levelDisplay = new LevelDisplay(root, gameGrid);
		
		compchips = levelBuilder.getComputerChips();
		doors = levelBuilder.getDoors();
		keys = levelBuilder.getKeys();
		
		levelDisplay.drawLevelOne(compchips, doors, keys);
		
		chip = new Chip(new Point(12, 4), scale, gameGrid);
		chipImageView = (ImageView) chip.getImageView();
		chipImageView.setX(chip.getChipLocationX() * scale);
		chipImageView.setY(chip.getChipLocationY() * scale);
		root.getChildren().add(chipImageView);

		scene = new Scene(root, 625, 625);
		stage.setTitle("Chip's Challenge");
		stage.setScene(scene);
		stage.show();
		
		startGamePlay();
	}
	

	

	private void startGamePlay(){
    	// Create a keypressed handler
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
        @Override
    	public void handle(KeyEvent ke) {
    		// Delegate movement decisions and actions to the ship
    			switch(ke.getCode()){

    				case RIGHT:
    					chip.moveRight();
    					break;
    				case LEFT:
    					chip.moveLeft();
    					break;
    				case DOWN:
    					chip.moveDown();
    					break;
    				case UP:
    					chip.moveUp();
    					break;
    				default:
    					break;	
    			}
    			Point chipP = chip.getChipPoint();
    			chipImageView.setX(chipP.x * scale);
    			chipImageView.setY(chipP.y * scale);
    			
    			if (compchips.containsKey(chipP)) {
    		    	compchips.get(chipP).remove();
    				compchips.remove(chipP);
    				chipCount -= 1;
    				
    			}
    			
    			if (keys.containsKey(chipP)) {
    				keys.get(chipP).remove();
    			}
    			
    		}						
        });
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}
