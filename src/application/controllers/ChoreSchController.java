package application.controllers;

import java.util.ArrayList;

import application.models.ChecklistItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ChoreSchController extends Controller{
	@FXML public ScrollPane checklistPane;
	@FXML public VBox checklistVBox;
	public ArrayList<ChecklistItem> checklistItems = new ArrayList<ChecklistItem>();
	
	@FXML
	public void handleBackMove(ActionEvent e) {
		viewChanged("home");
	}
	
	
}
