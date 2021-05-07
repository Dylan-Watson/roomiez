package application.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Model {
	/**
	 *Passes ChecklistItem to .csv file for saving 
	 * @param ChecklistItem
	 */
	public void saveMoveInChecklistItem(ChecklistItem item) {
		String code = "abc123"; // TODO: Pull the current code from the login system
		
		File saveFile = null;
		try {
			saveFile = new File("data/checklists/" + code + "_movein.csv");
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
	
	public void removeMoveInChecklistItem(ChecklistItem item) {
		// TODO: This
	}
}
