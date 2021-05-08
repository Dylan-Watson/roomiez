package application.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import application.models.Chore;
import application.models.ChoreSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class EnterChoreController {

    @FXML
    private TextField roomMate;

    @FXML
    private TextField calLabel;

    @FXML
    private TextField dayNum;//TODO delete

    @FXML
    private TextField choreName;

    @FXML
    private TextField choreNum;
   
    @FXML
    private ColorPicker colorPicker;

    @FXML
    private Button enter;
    
    @FXML
    private ToggleButton m;
    @FXML
    private ToggleButton t;
    @FXML
    private ToggleButton w;
    @FXML
    private ToggleButton r;
    @FXML
    private ToggleButton f;
    @FXML
    private ToggleButton sa;
    @FXML
    private ToggleButton su;
   
    
    private Stage prevStage;
    
    
    @FXML
    void submitInfo(ActionEvent event) {
    	ArrayList<ToggleButton> weekDaysArray = new ArrayList<>();
    	weekDaysArray.add(m);
    	weekDaysArray.add(t);
    	weekDaysArray.add(w);
    	weekDaysArray.add(r);
    	weekDaysArray.add(f);
    	weekDaysArray.add(sa);
    	weekDaysArray.add(su);
    	
    	//System.out.println("in submit info");
    	Stage thisStage = (Stage) enter.getScene().getWindow();
    	String strRoomie = roomMate.getText().trim();
    	String strLabel = calLabel.getText().trim();
    	String strChoreName = choreName.getText().trim();
    	String strChoreNumber = choreNum.getText().trim();
        int choreIndex = Integer.valueOf(strChoreNumber);
        //private ColorPicker color;
        
        ArrayList<Integer> weekDaysByNum = new ArrayList<Integer>();
        int dayNum = 1;
        for(ToggleButton dayButton :  weekDaysArray) {
        	dayButton.getEffect();
        	if(dayButton.isSelected()) {
        		weekDaysByNum.add(dayNum);
        	}
        	dayNum++;
        }
        
        
    	Chore newChore = new Chore(strChoreName, strRoomie, strLabel ,choreIndex , weekDaysByNum );
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/ChoreSchedule.fxml"));
			Parent root = loader.load();
			ChoreScheduleController cController = loader.getController();
			//try add to chore list, send chore list, add to cal gets last added to add
			cController.addToCal(newChore, true); //passing chore object to chore schedule controller
    		this.prevStage.setScene(new Scene(root));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	thisStage.close();   	
    }

    @FXML
    void tempSceneSelect(ActionEvent event) {

    }


	/**
	 * @return the prevStage
	 */
	public Stage getPrevStage() {
		return prevStage;
	}

	/**
	 * @param prevStage the prevStage to set
	 */

	public void setPrevStage(Stage prevStage) {
		this.prevStage = prevStage;
	}
	
	void loadWithData(Chore currChore) {
//		ArrayList<ToggleButton> weekDaysArray = new ArrayList<>();
//    	weekDaysArray.add(m);
//    	weekDaysArray.add(t);
//    	weekDaysArray.add(w);
//    	weekDaysArray.add(r);
//    	weekDaysArray.add(f);
//    	weekDaysArray.add(sa);
//    	weekDaysArray.add(su);
    	
        roomMate.setText(currChore.getRoomie());
        calLabel.setText(currChore.getLabelName());
        choreName.setText(currChore.getName());
        choreNum.setText(String.valueOf(currChore.getChoreNum()));


	}
}
