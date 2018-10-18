package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;
import java.util.HashMap;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import edu.nd.se2018.homework.chipschallenge.model.level.LevelBuilder;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Bug;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Chip;
import edu.nd.se2018.homework.chipschallenge.model.sprites.ComputerChip;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Door;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Key;
import edu.nd.se2018.homework.chipschallenge.view.LevelDisplay;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
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
	private HashMap<Point, Bug> bugs;
	private Door levelGate;
	private Point portalPoint;
	ImageView chipImageView;

	private Chip chip;
	private Scene scene;
	private int level = 1;
	final int scale = 25;
	int chipCount = 11;
	
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		gameGrid = new GameGrid(root);
		gameGrid.drawMap(scale);
		
		
		gameGrid.drawLevelOne(); // draw level one
		portalPoint = new Point(gameGrid.portalX, gameGrid.portalY);
		// build the level objects
		levelBuilder = new LevelBuilder(root, gameGrid);
		levelBuilder.buildLvlOne();
		
		levelDisplay = new LevelDisplay(root, gameGrid);
		
		compchips = levelBuilder.getComputerChips();
		doors = levelBuilder.getDoors();
		keys = levelBuilder.getKeys();
		levelGate = levelBuilder.getLevelGate();
		
		levelDisplay.drawLevelOne(compchips, doors, keys, levelGate);
		
		chip = new Chip(new Point(12, 4), scale, gameGrid);
		chipImageView = (ImageView) chip.getImageView();
		chipImageView.setX(chip.getLocationX() * scale);
		chipImageView.setY(chip.getLocationY() * scale);
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
    			Point chipP = chip.getPoint();
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
    			
    			if (chipCount == 0) {

    				levelGate.unlock();
    			}
    			
    			
    			
    			if (chipP.x == portalPoint.x && chipP.y == portalPoint.y && level == 1) {
    				
    				root.getChildren().clear();
    				level = 2;
    				chipCount = 6;
    				gameGrid.drawLevelTwo();
    				levelBuilder.buildLvlTwo();	
    				
    				compchips = levelBuilder.getComputerChips();
    				doors = levelBuilder.getDoors();
    				keys = levelBuilder.getKeys();
    				bugs = levelBuilder.getBugs();
    				levelGate = levelBuilder.getLevelGate();
    				
    				levelDisplay.drawLevelTwo(compchips, doors, keys, levelGate, bugs);
    				
    				chip.setPosition(new Point(22, 23));
    				chipImageView = (ImageView) chip.getImageView();
    				chipImageView.setX(chip.getLocationX() * scale);
    				chipImageView.setY(chip.getLocationY() * scale);
    				root.getChildren().add(chipImageView);
    				
    			} else if (chipP.x == portalPoint.x && chipP.y == portalPoint.y && level == 2) {
    				System.out.println("Winner");
    				Platform.exit();
    			}
    			
    			if (level == 2) {
    				for (Bug b: bugs.values()) {
    					b.move();
    					b.getImageViewXY().setX(b.getLocationX() * scale);
    					b.getImageViewXY().setY(b.getLocationY() * scale);
    					
    					if (chipP.x == b.getPoint().x && chipP.y == b.getPoint().y) {
    						System.out.println("Game Over");
    	    				Platform.exit();

    					}
    				}
    				
    			}
    			
    			
    		}						
        });
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}
