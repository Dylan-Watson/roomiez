package application.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Chore {
	private String name;
	private String roomie;
	private String roomieIn;
	private int choreNum; 
	//private int dayOfWeek;
	private ArrayList<Integer> weekDaysByNum;
	
	public Chore(String name, String roomie, String labelName, int choreNum, ArrayList<Integer> weekDays) {
		this.setName(name);
		this.setRoomie(roomie);
		this.setLabelName(labelName);
		this.setChoreNum(choreNum); 
		//this.setDayOfWeek(dayOfWeek);
		this.setWeekDays(weekDays);
	}

	/**
	 * @return the choreNum
	 */
	public int getChoreNum() {
		return choreNum;
	}

	/**
	 * @param choreNum the choreNum to set
	 */
	public void setChoreNum(int choreNum) {
		this.choreNum = choreNum;
	}

	/**
	 * @return the labelName
	 */
	public String getLabelName() {
		return roomieIn;
	}

	/**
	 * @param labelName the labelName to set
	 */
	public void setLabelName(String labelName) {
		this.roomieIn = labelName;
	}

	/**
	 * @return the roomie
	 */
	public String getRoomie() {
		return roomie;
	}

	/**
	 * @param roomie the roomie to set
	 */
	public void setRoomie(String roomie) {
		this.roomie = roomie;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public int getGridRow() {
		return choreNum+1;
	}

	/**
	 * @return the weekDay
	 */
	public ArrayList<Integer> getWeekDay() {
		return weekDaysByNum;
	}

	/**
	 * @param weekDays the weekDay to set
	 */
	public void setWeekDays(ArrayList<Integer> weekDays) {
		this.weekDaysByNum = weekDays;
	}
	
}
