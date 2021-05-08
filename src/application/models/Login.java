package application.models;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import application.controllers.GroceryListController;

/**
 * Login is a Java class designed to manage login functionality
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */
public class Login {
	private static Scanner x;
	
	private static String UserCode;
	
	/**
	 * Constructor
	 * @param User User access code
	 */
	public Login(String User){
		this.setCode_Name(User);
	}
	
	/**
	 * Getter for User access code
	 * @return User Access Code
	 */
	public static String getCode_Name() {
		return UserCode;
	}

	/**
	 * Setter for user access code
	 * @param user User Access Code
	 */
	public void setCode_Name(String user) {
		UserCode = user;
	}
	
	/**
	 * Method to search for a code in the save file
	 * @param userinput User code input
	 * @param FilePath file path to the save file
	 * @return was the code found
	 */
	public boolean SearchForCode (String userinput, String FilePath){
			boolean found = false;
			String name = "";
			String created = "";
			try {
				x = new Scanner (new File(FilePath));
				x.useDelimiter("[,\n]");
				
				while(x.hasNext() && !found) {
					name = x.next();
					created = x.next();
					if(name.equals(userinput)) {
						found = true;
						return found;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return found;
		}
	
	/**
	 * Method to create a new user code
	 * @param userinput User code input
	 * @param FilePath path to the save file
	 */
	public void CreatingNewCode (String userinput, String FilePath){
		String check = "created";
		try {
			FileWriter fw = new FileWriter(FilePath , true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(userinput + "," + check);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
