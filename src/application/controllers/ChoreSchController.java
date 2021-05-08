package application.controllers;

import java.util.ArrayList;

import application.models.ChecklistItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * ChoreSchController [DEPRECATED] is a Java class that is the controller for ChoreSch.fxml. Designed to handle inputs of different roommates and chore  responsibilities in a gridpane weekly format.
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */

public class ChoreSchController extends Controller{
	/*@FXML public ScrollPane checklistPane;
	@FXML public VBox checklistVBox;
	public ArrayList<ChecklistItem> checklistItems = new ArrayList<ChecklistItem>();*/
	/**
	 * 
	 * @param e handles any action event, namely mouse clicks, takes user back to home screen.
	 */
	@FXML
	public void handleBackMove(ActionEvent e) {
		viewChanged("home");
	}
	
	@FXML
	public GridPane root = new GridPane();
	
	
	

	
}
