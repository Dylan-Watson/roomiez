package application.models;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Login {
	private static Scanner x;
	
	private String UserCode;
	
	public Login(String User){
		this.setCode_Name(User);
	}
	public String getCode_Name() {
		return UserCode;
	}

	public void setCode_Name(String user) {
		UserCode = user;
	}
	
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
