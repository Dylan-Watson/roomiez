package application.controllers;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.models.Chore;
import application.models.ChoreSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChoreScheduleController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // fx:id="addBtn"
    private Button addBtn; // Value injected by FXMLLoader

    @FXML // fx:id="subBtn"
    private Button subBtn; // Value injected by FXMLLoader
    
    @FXML
    private GridPane gridP;

    //private ArrayList<Chore> choreList = new ArrayList<>();
    private Label labelsM[] = new Label[6];
    private StackPane[][] allPanes = new StackPane[6][10];
    
    private static ChoreSchedule choreListObject = new ChoreSchedule(); //TODO STATIC?
    private static boolean loadedFromFile = false;
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws FileNotFoundException {
    	//System.out.println("Init");
    	
    	initGridNodes();
    	
    	//System.out.println("Init done");
    	//make and call function called load from file
    	if(!loadedFromFile) {
    		//System.out.println("loaded from file is not true");
    		
        	loadedFromFile = true;

        	File file = new File("choreList.csv");
        	if(file.exists()) {
        		choreListObject.loadChoresFromFile();
        	}
    	}
    	
 
    	for(Chore chore : ChoreScheduleController.choreListObject.getChoreList() ) {
    		//System.out.println("Getting chore from list");
    		addToCal(chore, false);
    	}
    	
        assert addBtn != null : "fx:id=\"addBtn\" was not injected: check your FXML file 'ChoreSchedule.fxml'.";
        assert subBtn != null : "fx:id=\"subBtn\" was not injected: check your FXML file 'ChoreSchedule.fxml'.";

    }
    
    private void initGridNodes() {
    	
        for(Node node : this.gridP.getChildren())
        {	
        	if(node instanceof StackPane && GridPane.getColumnIndex(node) != null) {
        		this.allPanes[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] = (StackPane) node;
        		//System.out.println("row "+ GridPane.getRowIndex(node)+" column  "+GridPane.getColumnIndex(node));
        	}
        	
        	if(node instanceof Label) {
        		//System.out.println(GridPane.getRowIndex(node)+" <-row ");
        		this.labelsM[GridPane.getRowIndex(node)] = (Label) node;
        	}
        }
    }
    
    @FXML
    void addChore(ActionEvent event) {
    	System.out.println("addchore started");
    	
    	Node node = (Node) event.getSource();
    	Stage currStage = (Stage) node.getScene().getWindow();

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/ChoreEntry.fxml"));
			Parent root = loader.load();
			EnterChoreController userEntryC = loader.getController();
			userEntryC.setPrevStage(currStage);
    		Stage newStage = new Stage();
    		newStage.setScene(new Scene(root));
			newStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }

    @FXML
    void remChor(ActionEvent event) {
    	//System.out.println("remove chore");
    }

    @FXML
    void saveToFile(ActionEvent event) throws IOException {
    	
    	ChoreSchedule.saveChoreList(choreListObject.getChoreList());
    	//System.out.println("saved to file");
    }
   

	protected void addToCal(Chore newChore, boolean justAdded) {
		//System.out.println("Addto cal, justAdded: "+ justAdded);
		if (justAdded) {
			ChoreScheduleController.choreListObject.addChore(newChore);
		}
		
//		for(Chore chore : ChoreScheduleController.choreListObject.getChoreList() ) {
//			System.out.println("\n\nNew Chore being added:\nChore label name "+ chore.getLabelName() + "\nName of chore " + chore.getName() + "\ncoord \n" +chore.getGridRow() + " " +chore.getGridColumn());
//    	} 
		
		//System.out.println("New Chore being added:\nChore label name"+ newChore.getLabelName() + "\nName of chore " + newChore.getName() + "\ncoord \n" +newChore.getGridRow() + " " +newChore.getWeekDay());
    
		for(int dayNum : newChore.getWeekDay()) {
			int row = newChore.getGridRow();
			Button button = createButton(newChore, row, dayNum);
	    	button.setMaxSize(44,35);
	    	
	    	//System.out.println("Adding new button to to pane, changing label.");
	    	
	    	this.labelsM[row].setText(newChore.getName());//TODO update after changing how 
	    	this.allPanes[row][dayNum].getChildren().add(button);
	    	//System.out.println("Succesfully put on screen.");
		}
		
    	
	}
	
 

    private Button createButton(Chore chore, int row, int dayNum) {
    	//System.out.println("In add button");
    	Button button = new Button(chore.getLabelName());
    	//System.out.println("added button");
        button.setOnAction(e -> {
        	//System.out.println("chore editor");
        	loadChoreFromButton((Node)e.getSource(), row, dayNum);
        	});
        return button ;
    }

	private void loadChoreFromButton(Node node, int row, int dayNum) {
		Chore clickedChore = null;
    	//Node node = (Node) event.getSource();
//		node.getScene
//		System.out.println(row-1);
//		System.out.println(dayNum);
		//find corresponding chore with that row-1 and that day
		for(Chore chore : ChoreScheduleController.choreListObject.getChoreList() ) {
    		if(chore.getGridRow()==row) {
    			for(int day : chore.getWeekDay()) {
    				if(day == dayNum) {
    					clickedChore = chore;
    					//System.out.println("New Chore being added:\nChore label name"+ chore.getLabelName() + "\nName of chore " + chore.getName() + "\ncoord \n" +chore.getGridRow() + " " +chore.getWeekDay());
    					break;
    				}
    			}
    		}
    		
    	}
    	Stage currStage = (Stage) node.getScene().getWindow();
    	
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/views/ChoreEntry.fxml"));
			Parent root = loader.load();
			EnterChoreController userEntryC = loader.getController();
			userEntryC.setPrevStage(currStage);
			if(clickedChore != null) {
				userEntryC.loadWithData(clickedChore);
			}
			
    		Stage newStage = new Stage();
    		newStage.setScene(new Scene(root));
			newStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
    

}
