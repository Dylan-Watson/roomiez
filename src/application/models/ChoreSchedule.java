package application.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ChoreSchedule is a Java class designed to manage data interactions for chore data
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */
public class ChoreSchedule {
	private ArrayList<Chore> choreList;
	//File 
	//TODO create function to read data into file
	
	/**
	 * Constructor
	 */
	public ChoreSchedule() {
		this.choreList = new ArrayList<>();
	}

	/**
	 * @return the choreList
	 */
	public ArrayList<Chore> getChoreList() {
		return choreList;
	}

	/**
	 * @param choreList the choreList to set
	 */
	public void setChoreList(ArrayList<Chore> choreList) {
		this.choreList = choreList;
	}
	
	/**
	 * Adds a chore
	 * @param chore chore object to add
	 */
	public void addChore(Chore chore) {
		choreList.add(chore);
	}
	
	/**
	 * Loads in chores from the save file
	 * @throws FileNotFoundException File IO Exception
	 */
	public void loadChoresFromFile() throws FileNotFoundException {
		File file = new File("choreList.csv");
		//TODO open file with teamname_chorelist
		//if it doesn't exist, create one
		//or create one as soon as a new group of teammates is started, in sign in and out portion
		
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] splitString = line.split(",");
			String name = splitString[0];
			String roomie = splitString[1];
			String labelName = splitString[2];
			String choreNumStr = splitString[3];
			int y = Integer.valueOf(choreNumStr);
					
			int i = 4;
			ArrayList<Integer> weekDaysByNum = new ArrayList<Integer>();
			while(i < splitString.length) {
				String strDay = splitString[i];
				int dayNum = Integer.valueOf(strDay);
				weekDaysByNum.add(dayNum);
				i++;
			}

			
			Chore chore = new Chore(name,roomie, labelName, y-1, weekDaysByNum);
			choreList.add(chore);
		}
		scanner.close();
	}
	
	/**
	 * Saves the list of chores to a file
	 * @param choreList List of chores to save
	 * @throws IOException IO Exception
	 */
	public static void saveChoreList(ArrayList<Chore> choreList) throws IOException {
		//System.out.println("Saving to file(eventually");
		//TODO create file with teamname_chorelist
		FileWriter writer = new FileWriter("choreList.csv", false);//boolean append = false
		String string;
		for(Chore chore : choreList ) {
			string = chore.getName() + ","+ chore.getRoomie()  + "," + chore.getLabelName() + 
					"," +chore.getGridRow();
			for(int dayNum :chore.getWeekDay()) {
				string += ","+ dayNum;
			}
			string += "\n";
			writer.write(string);
		} 
		writer.close();
	}
}
