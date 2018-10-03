package edu.nd.se2018.homework.chipschallenge;

import java.awt.Point;

import edu.nd.se2018.homework.chipschallenge.model.level.GameGrid;
import edu.nd.se2018.homework.chipschallenge.model.level.LevelBuilder;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Chip;
import edu.nd.se2018.homework.chipschallenge.view.LevelDisplay;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game  extends Application {
	private LevelBuilder levelBuilder;
	private LevelDisplay levelDisplay;
	private GameGrid gameGrid;
	private AnchorPane root;
	ImageView chipImageView;

	private Chip chip;
	private Scene scene;
	final int scale = 50;
	@Override
	public void start(Stage stage) throws Exception {
		root = new AnchorPane();
		gameGrid = new GameGrid();
		gameGrid.drawMap(root.getChildren(), scale);
		levelDisplay = new LevelDisplay(root);					
		
		chip = new Chip(new Point( 0, 0), scale);
		chipImageView = (ImageView) chip.getImageView();
		chipImageView.setX(chip.getChipLocationX() * scale);
		chipImageView.setX(chip.getChipLocationX() * scale);
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
    			
    			chipImageView.setX(chip.getChipLocationX() * scale);
    			chipImageView.setY(chip.getChipLocationY() * scale);
			
    		}						
        });
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}
