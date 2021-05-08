package application.controllers;

import application.SceneSwitcher;
import application.models.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * MainController is a Java class designed to be a controller for the main/login screen
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */
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
		String data = joinInput;
		if(data.equals("")) {
			status.setText("Status: Input a code!");
			return;
		}
		Login code = new Login(data);
		if(code.SearchForCode(joinInput , "data/login/UsersForApp.csv")) { 
			status.setText("Status: Joining Room");
			SceneSwitcher.InitializeBackScenes();
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
		String data = createinput;
		if(data.equals("")) {
			status.setText("Status: Input a code!");
			return;
		}
		Login code = new Login(data);
		if(code.SearchForCode(createinput , "data/login/UsersForApp.csv")) {	//this is for the purpose of the video, will try and incoporate a search
			status.setText("Status: Room Already Exist Please Join");
		}
		else {
			status.setText("Status: Creating Room");
			code.CreatingNewCode(createinput , "data/login/UsersForApp.csv");
			SceneSwitcher.InitializeBackScenes();
			viewChanged("home");
		}
	}
}
