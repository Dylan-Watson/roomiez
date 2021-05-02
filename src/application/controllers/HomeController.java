package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomeController extends Controller{

	@FXML
	public void handleMoveInBtnClick(ActionEvent e) {
		viewChanged("move");
	}
	
	@FXML
	public void handleRoomDesignBtnClick(ActionEvent e) {
		viewChanged("room");
	}

	
	@FXML
	public void handleGroceryListBtnClick(ActionEvent e) {
		viewChanged("grocery");
	}
}
