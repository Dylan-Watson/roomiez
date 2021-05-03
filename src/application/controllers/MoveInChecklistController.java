package application.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MoveInChecklistController extends Controller {
	
	@FXML
	public void handleBackMove(ActionEvent e) {
		viewChanged("home");
	}

	@FXML
	public void handleAddBtnClicked(ActionEvent e) {
		// Change the view to the add form thingy
			// save button, assignments(?), name
		// On save button press, send info to model to get saved to txt file
			// Model will use code + grocerylist to save the txt file, that way it can again be loaded in later after login
			// Login code needs to be stored in an accessible class (singleton?) in memory
				// Likely the login should act like a singleton but there is no need to write the logic to make it one
	}
	
	@FXML
	public void handleSubBtnClicked(ActionEvent e) {
		// How do I want this to work? The existance of this button means that the checklist items need to be selectable
	}
}
