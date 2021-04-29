package application.controllers;

import application.SceneSwitcher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * Controller is a Java class designed to be a parent for all controllers used by the application. 
 * 
 * @author Dylan Watson (kgv351)
 * UTSA CS 3443.002 - Extra Credit
 * Spring 2021
 */
public class Controller{
	
	/**
	 * Handle button click to switch views
	 * @param event Click event
	 */
	@FXML
	public void viewButtonChanged(ActionEvent event) { // Most likely deprecated, for use with a MenuButton (FXML Dropdown). If this isn't used by the end of the project's development, delete it.
		String selection = ((MenuItem)event.getSource()).getText();
		viewChanged(selection);
	}
	
	public void viewChanged(String selection) {
		SceneSwitcher.SwitchScenes(selection);
	}
}
