package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MoveInChecklistController extends Controller {
	
	@FXML
	public void handleBackMove(ActionEvent e) {
		viewChanged("home");
	}

}
