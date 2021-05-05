package application.controllers;

import java.util.ArrayList;

import application.models.ChecklistItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ChoreSchController extends Controller{
	/*@FXML public ScrollPane checklistPane;
	@FXML public VBox checklistVBox;
	public ArrayList<ChecklistItem> checklistItems = new ArrayList<ChecklistItem>();*/
	
	@FXML
	public void handleBackMove(ActionEvent e) {
		viewChanged("home");
	}
	
	@FXML
	public GridPane root = new GridPane();
	
	//Label day1 = new Label("Monday");
	
	//root.setHgap(8);
	//root.setVgap(8);
	
	
	
	
	
	
	
	
	
}
