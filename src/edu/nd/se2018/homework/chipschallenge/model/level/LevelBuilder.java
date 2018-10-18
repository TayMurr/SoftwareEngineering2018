package edu.nd.se2018.homework.chipschallenge.model.level;

import java.awt.Point;
import java.util.HashMap;

import edu.nd.se2018.homework.chipschallenge.model.sprites.Bug;
import edu.nd.se2018.homework.chipschallenge.model.sprites.ComputerChip;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Door;
import edu.nd.se2018.homework.chipschallenge.model.sprites.DoorFactory;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Frog;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Key;
import edu.nd.se2018.homework.chipschallenge.model.sprites.PortalGate;
import javafx.scene.layout.AnchorPane;


public class LevelBuilder {
	AnchorPane root;
	GameGrid gameGrid;
	HashMap<Point, ComputerChip> compChips;
	HashMap<Point, Door> doors;
	HashMap<Point, Key> keys;
	Door levelGate;
	DoorFactory doorFactory;
	HashMap<Point, Bug> bugs;
	int scale = 25;
	
	public LevelBuilder(AnchorPane root, GameGrid gameGrid) {
		compChips = new HashMap<Point, ComputerChip>();
		doors = new HashMap<Point, Door>();
		keys = new HashMap<Point, Key>();
		bugs = new HashMap<Point, Bug>();
		this.root = root;
		this.gameGrid = gameGrid;
		doorFactory = new DoorFactory();
	}
	
	public void buildLvlOne() {
		clearLevel();
		// lay out level one chips
		compChips.put(new Point(3, 4), new ComputerChip(root));
		compChips.put(new Point(2, 7), new ComputerChip(root));
		compChips.put(new Point(5, 8), new ComputerChip(root));
		compChips.put(new Point(2, 9), new ComputerChip(root));
		compChips.put(new Point(12, 10), new ComputerChip(root));
		compChips.put(new Point(11, 15), new ComputerChip(root));
		compChips.put(new Point(13, 15), new ComputerChip(root));
		compChips.put(new Point(19, 8), new ComputerChip(root));
		compChips.put(new Point(21, 4), new ComputerChip(root));
		compChips.put(new Point(22, 7), new ComputerChip(root));
		compChips.put(new Point(22, 10), new ComputerChip(root));
		
		// lay out lvl one key doors
		Door greenDoor1 = doorFactory.createDoor("green", root, gameGrid, new Point(5, 5));
		Door blueDoor1 = doorFactory.createDoor("blue", root, gameGrid, new Point(4, 6));
		Door redDoor1 = doorFactory.createDoor("red", root, gameGrid, new Point(4, 10));
		Door yellowDoor1 = doorFactory.createDoor("yellow", root, gameGrid, new Point(11, 11));
		Door yellowDoor2 = doorFactory.createDoor("yellow", root, gameGrid, new Point(13, 11));
		Door greenDoor2 = doorFactory.createDoor("green", root, gameGrid, new Point(19, 5));
		Door redDoor2 = doorFactory.createDoor("red", root, gameGrid, new Point(20, 6));
		Door blueDoor2 = doorFactory.createDoor("blue", root, gameGrid, new Point(20, 10));
		
		doors.put(new Point(5, 5), greenDoor1);
		doors.put(new Point(4, 6), blueDoor1);
		doors.put(new Point(4, 10), redDoor1);
		doors.put(new Point(11, 11), yellowDoor1);
		doors.put(new Point(13, 11), yellowDoor2);
		doors.put(new Point(19, 5), greenDoor2);
		doors.put(new Point(20, 6), redDoor2);
		doors.put(new Point(20, 10), blueDoor2);
		
		// layout lvl one keys
		Key yellowkey1 = new Key(root, "yellow");
		yellowkey1.addObserver(yellowDoor1);
		keys.put(new Point(2, 6), yellowkey1);
		
		Key yellowkey2 = new Key(root, "yellow");
		yellowkey2.addObserver(yellowDoor2);
		keys.put(new Point(22, 6), yellowkey2);
		
		Key bluekey1 = new Key(root, "blue");
		bluekey1.addObserver(blueDoor1);
		keys.put(new Point(5, 7), bluekey1);
		
		Key bluekey2 = new Key(root, "blue");
		bluekey2.addObserver(blueDoor2);
		keys.put(new Point(5, 9), bluekey2);
		
		Key redkey1 = new Key(root, "red");
		redkey1.addObserver(redDoor1);
		keys.put(new Point(19, 7), redkey1);
		
		Key redkey2 = new Key(root, "red");
		redkey2.addObserver(redDoor2);
		keys.put(new Point(19, 9), redkey2);
		
		Key greenkey1 = new Key(root, "green");
		greenkey1.addObserver(greenDoor1);
		keys.put(new Point(13, 16), greenkey1);
		
		Key greenkey2 = new Key(root, "green");
		greenkey2.addObserver(greenDoor2);
		keys.put(new Point(11, 16), greenkey2);
		
		// gate blocking access to the portal to next level
		levelGate = new PortalGate(root, gameGrid, new Point(12, 1));
		
		

	}
	
	public void buildLvlTwo() {
		clearLevel();
		compChips.put(new Point(4, 21), new ComputerChip(root));
		compChips.put(new Point(20, 16), new ComputerChip(root));
		compChips.put(new Point(4, 13), new ComputerChip(root));
		compChips.put(new Point(19, 9), new ComputerChip(root));
		compChips.put(new Point(4, 5), new ComputerChip(root));
		compChips.put(new Point(21, 3), new ComputerChip(root));
		
		Door blueDoor1 = doorFactory.createDoor("blue", root, gameGrid, new Point(19, 3));
		Door redDoor1 = doorFactory.createDoor("red", root, gameGrid, new Point(12, 7));
		Door yellowDoor1 = doorFactory.createDoor("yellow", root, gameGrid, new Point(12, 11));
		Door greenDoor1 = doorFactory.createDoor("green", root, gameGrid, new Point(12, 15));
		Door blueDoor2 = doorFactory.createDoor("blue", root, gameGrid, new Point(12, 19));
		
		doors.put(new Point(19, 3), blueDoor1);
		doors.put(new Point(12, 7), redDoor1);
		doors.put(new Point(12, 11), yellowDoor1);
		doors.put(new Point(12, 15), greenDoor1);
		doors.put(new Point(12, 19), blueDoor2);
		
	
		Key bluekey1 = new Key(root, "blue");
		bluekey1.addObserver(blueDoor2);
		keys.put(new Point(5, 21), bluekey1);
		
		Key greenkey1 = new Key(root, "green");
		greenkey1.addObserver(greenDoor1);
		keys.put(new Point(21, 17), greenkey1);
		
		Key yellowkey1 = new Key(root, "yellow");
		yellowkey1.addObserver(yellowDoor1);
		keys.put(new Point(6, 13), yellowkey1);
		
		Key redkey1 = new Key(root, "red");
		redkey1.addObserver(redDoor1);
		keys.put(new Point(20, 9), redkey1);
		
		Key bluekey2 = new Key(root, "blue");
		bluekey2.addObserver(blueDoor1);
		keys.put(new Point(5, 5), bluekey2);

		bugs.put(new Point(2, 19), new Bug(new Point(2, 19), scale , gameGrid));
		bugs.put(new Point(17, 7), new Bug(new Point(17, 7), scale , gameGrid));
		bugs.put(new Point(2, 11), new Bug(new Point(2, 11), scale , gameGrid));
		bugs.put(new Point(17, 15), new Bug(new Point(17, 15), scale , gameGrid));
		bugs.put(new Point(2, 3), new Bug(new Point(2, 3), scale , gameGrid));

		levelGate = new PortalGate(root, gameGrid, new Point(12, 1));

	}
	
	public void clearLevel() {
		compChips.clear();
		doors.clear();
		keys.clear();
		
	}
	
	public HashMap<Point, ComputerChip> getComputerChips() {
		return compChips;
	}

	public HashMap<Point, Door> getDoors() {
		return doors;
	}
	
	public HashMap<Point, Key> getKeys() {
		return keys;
	}
	
	public HashMap<Point, Bug> getBugs() {
		return bugs;
	}
	

	public Door getLevelGate() {
		return levelGate;
	}



}
