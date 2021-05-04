package application.controllers;

import application.SceneSwitcher;
import application.models.Model;
import application.models.ChecklistItem;

import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;

public class MoveInChecklistController extends Controller {
	
	@FXML public ScrollPane checklistPane;
	@FXML public VBox checklistVBox;
	public ArrayList<ChecklistItem> checklistItems = new ArrayList<ChecklistItem>();
	
	@FXML
	public void handleBackMove(ActionEvent e) {
		viewChanged("home");
	}

	@FXML
	public void handleAddBtnClicked(ActionEvent e) {
		Dialog<String> dialog = new TextInputDialog();
		dialog.setTitle("Add Item");
		dialog.setHeaderText("Item to add: ");
		dialog.setGraphic(null);
		dialog.initOwner(SceneSwitcher.GetRoot());
		dialog.initModality(Modality.APPLICATION_MODAL);
		
		DialogPane dialogPane = dialog.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("dialog.css").toExternalForm());
		dialogPane.getStyleClass().add("dialog");
		
		Optional<String> result = dialog.showAndWait();
		String text = "None";
		
		if(result.isPresent()) {
			text = result.get();
			if(text.equals("None") || text.equals("")) return;
		}
		
		ChecklistItem checklistItem = new ChecklistItem(text);
		checklistItems.add(checklistItem);
		
		CheckBox cb = new CheckBox();
		cb.setAllowIndeterminate(false);
		cb.getStyleClass().add("check-box");
		
		Text itemTitle = new Text(text);
		itemTitle.setFill(Paint.valueOf("#f4a261"));
		itemTitle.setFont(Font.font("Century Gothic", FontWeight.BOLD, 20));
		
		HBox itemBox = new HBox();
		itemBox.setSpacing(30);
		itemBox.setAlignment(Pos.CENTER_LEFT);
		itemBox.getChildren().add(cb);
		itemBox.getChildren().add(itemTitle);
		
		checklistVBox.getChildren().add(0, itemBox);
		
		Model model = new Model();
		model.saveMoveInChecklistItem(checklistItem);
		// Change the view to the add form thingy -> done
			// save button, assignments(?), name -> done
		// On save button press,
			// 1) show on screen -> done 
			// 2) send info to model to get saved to txt file
				// Model will use code + grocerylist to save the txt file, that way it can again be loaded in later after login
				// Login code needs to be stored in an accessible class (singleton?) in memory
					// Likely the login should act like a singleton but there is no need to write the logic to make it one
	}
	
	@FXML
	public void handleSubBtnClicked(ActionEvent e) {
		// How do I want this to work? The existance of this button means that the checklist items need to be selectable
	}
}