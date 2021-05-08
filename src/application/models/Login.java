package application.models;


import java.io.File;
import java.io.FileNotFoundException;
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
					System.out.println(name);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return found;
		}
}
