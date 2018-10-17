package edu.nd.se2018.homework.chipschallenge.model.sprites;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class ComputerChip {

	private AnchorPane root;
	Rectangle rect;

	public ComputerChip(AnchorPane root) {
		this.root = root;
	}
	
	
	public void remove() {
		root.getChildren().remove(rect);
	}
	
	public void setImageRectangle(Rectangle rect) {
		this.rect = rect;
	}
	
}
