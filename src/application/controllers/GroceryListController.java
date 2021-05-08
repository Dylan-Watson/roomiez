package application.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import application.SceneSwitcher;
import application.models.ChecklistItem;
import application.models.Model;
import application.models.Model.Checklist;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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

public class GroceryListController extends Controller implements Initializable{
	// TODO: Combine this and MoveInChecklist using polymorphism
	
	@FXML public ScrollPane groceryPane;
	@FXML public VBox groceryVBox;
	public ArrayList<ChecklistItem> groceryItems = new ArrayList<ChecklistItem>();
	Model model = new Model();

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		ArrayList<ChecklistItem> loadedItems = model.loadChecklistItems(Checklist.GROCERY);
		for(ChecklistItem loadedItem : loadedItems) {
			HBox itemBox = new HBox();
			itemBox.setSpacing(30);
			itemBox.setAlignment(Pos.CENTER_LEFT);
			itemBox.getStyleClass().add("hbox");
			itemBox.setPrefWidth(400);
			itemBox.setPadding(new Insets(0,10,0,10));
			itemBox.setOnMouseClicked(clickEvent -> {
				for(ChecklistItem item : groceryItems)
					item.getContainer().getStyleClass().remove("hbox-active");
				((HBox)(clickEvent.getSource())).getStyleClass().add("hbox-active");
			});
			
			loadedItem.setContainer(itemBox);
			
			CheckBox cb = new CheckBox();
			cb.setAllowIndeterminate(false);
			cb.getStyleClass().add("check-box");
			cb.setSelected(loadedItem.getChecked());
			cb.setOnAction(checkedEvent -> {
				handleCheckboxCheckedEvent(checkedEvent, loadedItem.getName());
			});
			
			Text itemTitle = new Text(loadedItem.getName());
			itemTitle.setFill(Paint.valueOf("#f4a261"));
			itemTitle.setFont(Font.font("Century Gothic", FontWeight.BOLD, 20));
			
			itemBox.getChildren().add(cb);
			itemBox.getChildren().add(itemTitle);
			
			groceryVBox.getChildren().add(0, itemBox);
			groceryItems.add(loadedItem);
		}
	}
	
	@FXML
	public void handleBackGrocery(ActionEvent e) {
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
		
		HBox itemBox = new HBox();
		itemBox.setSpacing(30);
		itemBox.setAlignment(Pos.CENTER_LEFT);
		itemBox.getStyleClass().add("hbox");
		itemBox.setPrefWidth(400);
		itemBox.setPadding(new Insets(0,10,0,10));
		itemBox.setOnMouseClicked(clickEvent -> {
			for(ChecklistItem item : groceryItems)
				item.getContainer().getStyleClass().remove("hbox-active");
			((HBox)(clickEvent.getSource())).getStyleClass().add("hbox-active");
		});
		
		ChecklistItem checklistItem = new ChecklistItem(text, itemBox);
		groceryItems.add(checklistItem);
		
		CheckBox cb = new CheckBox();
		cb.setAllowIndeterminate(false);
		cb.getStyleClass().add("check-box");
		cb.setOnAction(checkedEvent -> {
			handleCheckboxCheckedEvent(checkedEvent, checklistItem.getName());
		});
		
		Text itemTitle = new Text(text);
		itemTitle.setFill(Paint.valueOf("#f4a261"));
		itemTitle.setFont(Font.font("Century Gothic", FontWeight.BOLD, 20));
		
		itemBox.getChildren().add(cb);
		itemBox.getChildren().add(itemTitle);
		
		groceryVBox.getChildren().add(0, itemBox);
		

		model.addChecklistItem(checklistItem, Checklist.GROCERY);
	}
	
	@FXML
	public void handleSubBtnClicked(ActionEvent e) {
		ChecklistItem toRemove = null;
		for(ChecklistItem item : groceryItems) {
			if(item.getContainer().getStyleClass().contains("hbox-active")) {
				toRemove = item;
				break;
			}
		}
		
		if(toRemove == null) return;
		
		groceryVBox.getChildren().remove(toRemove.getContainer());
		groceryItems.remove(toRemove);
		model.updateChecklistItem(groceryItems, Checklist.GROCERY);
	}
	
	public void handleCheckboxCheckedEvent(ActionEvent checkedEvent, String name) {
		CheckBox cb = (CheckBox) checkedEvent.getSource();
		boolean checked = cb.isSelected();
		ChecklistItem affectedItem = null;
		for(ChecklistItem item : groceryItems) {
			if(item.getName().equals(name))
				affectedItem = item;
		}
		if(affectedItem == null) {
			System.out.println("There was an error!");
			cb.setSelected(!checked);
			return;
		}
		affectedItem.setChecked(checked);
		model.updateChecklistItem(groceryItems, Checklist.GROCERY);
	}

}
