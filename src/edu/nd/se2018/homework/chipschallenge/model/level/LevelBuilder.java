package edu.nd.se2018.homework.chipschallenge.model.level;

import java.awt.Point;
import java.util.HashMap;

import edu.nd.se2018.homework.chipschallenge.model.sprites.ComputerChip;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Door;
import edu.nd.se2018.homework.chipschallenge.model.sprites.DoorFactory;
import edu.nd.se2018.homework.chipschallenge.model.sprites.Key;
import javafx.scene.layout.AnchorPane;


public class LevelBuilder {
	AnchorPane root;
	GameGrid gameGrid;
	HashMap<Point, ComputerChip> compChips;
	HashMap<Point, Door> doors;
	HashMap<Point, Key> keys;
	
	public LevelBuilder(AnchorPane root, GameGrid gameGrid) {
		compChips = new HashMap<Point, ComputerChip>();
		doors = new HashMap<Point, Door>();
		keys = new HashMap<Point, Key>();
		this.root = root;
		this.gameGrid = gameGrid;
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
		DoorFactory doorFactory = new DoorFactory();
	
		doors.put(new Point(5, 5), doorFactory.createDoor("green", root, gameGrid, new Point(5, 5)));
		doors.put(new Point(4, 6), doorFactory.createDoor("blue", root, gameGrid, new Point(4, 6)));
		doors.put(new Point(4, 10), doorFactory.createDoor("red", root, gameGrid, new Point(4, 10)));
		doors.put(new Point(11, 11), doorFactory.createDoor("yellow", root, gameGrid, new Point(11, 11)));
		doors.put(new Point(13, 11), doorFactory.createDoor("yellow", root, gameGrid, new Point(13, 11)));
		doors.put(new Point(19, 5), doorFactory.createDoor("green", root, gameGrid, new Point(19, 5)));
		doors.put(new Point(20, 6), doorFactory.createDoor("red", root, gameGrid, new Point(20, 6)));
		doors.put(new Point(20, 10), doorFactory.createDoor("blue", root, gameGrid, new Point(20, 10)));
		
		// layout lvl one keys
		
		keys.put(new Point(2, 6), new Key(root, "yellow"));
		keys.put(new Point(22, 6), new Key(root, "yellow"));
		keys.put(new Point(5, 7), new Key(root, "blue"));
		keys.put(new Point(5, 9), new Key(root, "blue"));
		keys.put(new Point(19, 7), new Key(root, "red"));
		keys.put(new Point(19, 9), new Key(root, "red"));
		keys.put(new Point(13, 16), new Key(root, "green"));

	}
	
	public void buildLvlTwo() {
		clearLevel();

	}
	
	public void clearLevel() {
		compChips.clear();
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

}
