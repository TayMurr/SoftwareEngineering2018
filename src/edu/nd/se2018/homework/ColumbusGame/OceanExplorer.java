package edu.nd.se2018.homework.ColumbusGame;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import edu.nd.se2018.examples.observer.catmouse.Cat;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	boolean[][] islandMap;
	AnchorPane root;
	final int dimensions = 10;
	final int islandCount = 10;
	final int scale = 25;
	Image shipImage;
	ImageView shipImageView;
	OceanMap oceanMap;
	Scene scene;
	Ship ship;
	List<PirateShip> pirates;
	int numberOfPirates = 2;


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {

		root = new AnchorPane();
		
		oceanMap = new OceanMap();

		oceanMap.drawMap(root.getChildren(), scale);
		pirates = new LinkedList<PirateShip>();
		loadShipImage();

		loadPirateShips();
		
		oceanMap.placeIslands(root.getChildren());
		
		
		
		scene = new Scene(root, 625, 625);
		oceanStage.setScene(scene);
		oceanStage.setTitle("My Island");
		oceanStage.show();
		startSailing();
		
		System.out.println("daf");
	}
	
	public void loadShipImage() {
		ship = new Ship(oceanMap); // start the ship at the upper left 
		shipImage = new Image("images/ColumbusShip.png",scale, scale, true, true);
		shipImageView = new ImageView(shipImage);

		shipImageView.setX(ship.getShipLocationX() * scale);
		shipImageView.setY(ship.getShipLocationY() * scale);
		root.getChildren().add(shipImageView);
		
	}
	// create new pirates ships placed randomly
	public void loadPirateShips() {
		for (int i = 0; i < numberOfPirates; i++) {
			PirateShip p = new PirateShip(oceanMap);
			pirates.add(p);


		}

		for (PirateShip p: pirates) {
			ship.addObserver(p);
			ImageView pirateShipImageView = p.getImageView();
			pirateShipImageView.setX(p.getShipLocationX() * scale);
			pirateShipImageView.setY(p.getShipLocationY() * scale);
			root.getChildren().add(p.getImageView());

		}
		
		

	}
	
	private void startSailing(){
    	// Create a keypressed handler
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
        @Override
    	public void handle(KeyEvent ke) {
    		// Delegate movement decisions and actions to the ship
    			switch(ke.getCode()){

    				case RIGHT:
    					ship.moveRight();
    					break;
    				case LEFT:
    					ship.moveLeft();
    					break;
    				case DOWN:
    					ship.moveDown();
    					break;
    				case UP:
    					ship.moveUp();
    					break;
    				default:
    					break;	
    			}
    			
			shipImageView.setX(ship.getShipLocationX() * scale);
			shipImageView.setY(ship.getShipLocationY() * scale);
			
			
    		}						
        });
    }    
	

	

}
