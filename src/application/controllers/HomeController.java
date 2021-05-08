package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * HomeController is a Java class designed to function as the controller for the home screen
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */
public class HomeController extends Controller{
	/**
	 * Handle button click, takes user to Move-In Checklist screen
	 * @param event Click event
	 */
	@FXML
	public void handleMoveInBtnClick(ActionEvent e) {
		viewChanged("move");
	}
	/**
	 * Handle button click, takes user to Room Design screen
	 * @param event Click event
	 */
	@FXML
	public void handleRoomDesignBtnClick(ActionEvent e) {
		viewChanged("room");
	}

	/**
	 * Handle button click, takes user to Grocery List screen
	 * @param event Click event
	 */
	@FXML
	public void handleGroceryListBtnClick(ActionEvent e) {
		viewChanged("grocery");
	}
	/**
	 * Handle button click, takes user to Chore Scheduler screen
	 * @param event Click event
	 */
	@FXML
	public void ChoreSchBtnClick(ActionEvent e) {
		viewChanged("chore");
	}
}
