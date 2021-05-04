package application.models;

import javafx.scene.layout.HBox;

public class ChecklistItem {
	boolean checked;
	boolean selected;
	String name;
	HBox container;
	
	public ChecklistItem(String name, HBox container) {
		this.name = name;
		this.container = container;
		this.checked = false;
		this.selected = true;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public boolean getChecked() {
		return checked;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public boolean getSelected() {
		return selected;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setContainer(HBox container) {
		this.container = container;
	}
	
	public HBox getContainer() {
		return container;
	}
}