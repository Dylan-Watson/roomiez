package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class GroceryListController extends Controller{
	
	@FXML
	public void handleBackGrocery(ActionEvent e) {
		viewChanged("home");
	}

}
