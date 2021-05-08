package application.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {

	public enum Checklist {
		MOVEIN,
		GROCERY
	}
	
	public ArrayList<ChecklistItem> loadChecklistItems(Checklist checklist) {
		String code = "abc123"; // TODO: Pull the current code from the login system
		String extension = checklist == Checklist.MOVEIN ? "_movein.csv" : "_grocery.csv";
		
		try {
			File file = new File("data/checklists/" + code + extension);
			file.createNewFile();
			Scanner input = new Scanner(file);
			input.useDelimiter("\n");
			ArrayList<ChecklistItem> loadedItems = new ArrayList<ChecklistItem>();
			while(input.hasNext()) {
				String[] row = input.next().split(",");
				ChecklistItem newItem = new ChecklistItem(row[0], null, Boolean.parseBoolean(row[1]));
				loadedItems.add(newItem);
			}
			input.close();
			return loadedItems;
		} catch (Exception e) {
			System.out.println("There was an error!");
			e.printStackTrace();
			return new ArrayList<ChecklistItem>();
		}
	}
	
	public void addChecklistItem(ChecklistItem item, Checklist checklist) {
	/**
	 *Passes ChecklistItem to .csv file for saving 
	 * @param ChecklistItem
	 */
	public void saveMoveInChecklistItem(ChecklistItem item) {
		String code = "abc123"; // TODO: Pull the current code from the login system
		String extension = checklist == Checklist.MOVEIN ? "_movein.csv" : "_grocery.csv";
		
		File saveFile = null;
		try {
			saveFile = new File("data/checklists/" + code + extension);
			saveFile.createNewFile();
			
			FileWriter writer = new FileWriter(saveFile, true);
			writer.append(item.name + "," + item.checked);
			writer.append("\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("There was an error!");
			e.printStackTrace();
			return;
		}
	}
	
	public void updateChecklistItem(ArrayList<ChecklistItem> items, Checklist checklist) {
		String code = "abc123"; // TODO: Pull the current code from the login system
		String extension = checklist == Checklist.MOVEIN ? "_movein.csv" : "_grocery.csv";
		
		File saveFile = null;
		try {
			saveFile = new File("data/checklists/" + code + extension);
			saveFile.createNewFile();
			
			FileWriter writer = new FileWriter(saveFile, false);
			String toWrite = "";
			for(ChecklistItem item : items) {
				toWrite += item.name + "," + item.checked + "\n";
			}
			
			writer.write(toWrite);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.out.println("There was an error!");
			e.printStackTrace();
			return;
		}
	}
}