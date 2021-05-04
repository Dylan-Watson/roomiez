package application.models;

public class ChecklistItem {
	boolean checked;
	String name;
	
	public ChecklistItem(String name) {
		this.name = name;
		this.checked = false;
	}
	
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public boolean getChecked() {
		return checked;
	}
}