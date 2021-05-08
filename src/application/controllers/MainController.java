package application.controllers;

import application.models.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController extends Controller {
	@FXML
	public TextField joinText;
	@FXML
	public TextField createText;
	@FXML
	public Button createButton;
	@FXML
	public Button JoinButton;
	@FXML
	public Label status;
	
	/**
	 * Takes in user input, checks if room exists
	 * @param event Click event
	 */
	public void PressJoin(ActionEvent event) {

		String joinInput = joinText.getText();
		Login code = new Login("data");
		if(code.SearchForCode(joinInput , "data/login/UsersForApp.csv")) { 
			status.setText("Status: Joining Room");
			viewChanged("home");
		}
		else {
			status.setText("Status: Room Not Found Please Create");
		}
	}
	
	/**
	 * Takes user input, creates a new room
	 * @param event Click event
	 */
	public void PressCreate(ActionEvent event) { 
		String createinput = createText.getText();
		Login code = new Login("data");
		if(code.SearchForCode(createinput , "data/login/UsersForApp.csv")) {	//this is for the purpose of the video, will try and incoporate a search
			status.setText("Status: Room Already Exist Please Join");
		}
		else {
		status.setText("Status: Creating Room");
		code.CreatingNewCode(createinput , "data/login/UsersForApp.csv");
		viewChanged("home");
		}
	}
}
