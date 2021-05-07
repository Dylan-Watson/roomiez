package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

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
