package application.models;

import javafx.scene.layout.HBox;

/**
 * ChecklistItem is a Java class designed to hold a single checklist item
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */
public class ChecklistItem {
	boolean checked;
	boolean selected;
	String name;
	HBox container;
	
	/**
	 * Constructor
	 * @param name Name of the item
	 * @param container HBox it is contained in
	 */
	public ChecklistItem(String name, HBox container) {
		this.name = name;
		this.container = container;
		this.checked = false;
		this.selected = false;
	}
	
	/**
	 * Constructor
	 * @param name Name of the item
	 * @param container HBox it is contained in
	 * @param checked Whether or not the checkbox is checked
	 */
	public ChecklistItem(String name, HBox container, boolean checked) {
		this.name = name;
		this.container = container;
		this.checked = checked;
		this.selected = false;
	}
	
	/**
	 * Setter for the checked variable
	 * @param checked if the checkbox is checked
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	/**
	 * Getter for the checked variable
	 * @return if the checkbox is checked
	 */
	public boolean getChecked() {
		return checked;
	}
	
	/**
	 * Setter for the selected variable
	 * @param selected checkbox is selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	/**
	 * Getter for the selected variable
	 * @return checkbox is selected
	 */
	public boolean getSelected() {
		return selected;
	}
	
	/**
	 * Setter for the name
	 * @param name name of the item
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter for the name
	 * @return the name of the item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for the container
	 * @param container HBox node of the item
	 */
	public void setContainer(HBox container) {
		this.container = container;
	}
	
	/**
	 * Getter for the container
	 * @return HBox node of the item
	 */
	public HBox getContainer() {
		return container;
	}
}