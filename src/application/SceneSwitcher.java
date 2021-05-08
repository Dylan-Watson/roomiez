package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * SceneSwitcher is a Java class designed to handle the storage and switching of GUI Views. 
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */
public class SceneSwitcher {

	private static Stage primaryStage; // Primary stage of the application
	
	private static ArrayList<SceneContainer> scenes = new ArrayList<SceneContainer>(); // ArrayList to contain all scenes in the application
	
	private static Application application;
	
	/**
	 * Setter for the Application variable of the project
	 * @param _application Application (Main.java) instance
	 */
	public static void SetApplication(Application _application) {
		application = _application;
	}
	
	/**
	 * Accessor method for the primaryStage variable
	 * @return The primary stage
	 */
	public static Stage GetRoot() {
		return primaryStage;
	}
	
	/**
	 * Set the primary stage
	 * @param _primaryStage primary stage (from start method)
	 */
	public static void SetRoot(Stage _primaryStage) {
		primaryStage = _primaryStage;
	}
	
	/**
	 * Adds a scene to the scenes arraylist
	 * @param scene Scene object to add
	 * @param identifier String identifier of the scene (used for switching)
	 */
	public static void AddScene(Scene scene, String identifier) {
		scenes.add(new SceneContainer(scene, identifier));
	}
	
	/**
	 * Switch the scene in the application
	 * @param selection String identifier of the desired scene
	 */
	public static void SwitchScenes(String selection) {
		for(SceneContainer container : scenes) {
			if(container.identifier.equals(selection)) {
				primaryStage.setScene(container.scene);
				primaryStage.show();
			}
		}
	}
	
	/**
	 * Method to initialize all pages that exist behind the login. This allows for the pages to run their initialization a group code has been established
	 */
	public static void InitializeBackScenes() {
		try { 
			Parent homeParent = FXMLLoader.load(application.getClass().getResource("/application/views/HomeScreen.fxml"));
			Scene homeScene = new Scene(homeParent,675,425);
			homeScene.getStylesheets().add(application.getClass().getResource("application.css").toExternalForm());			
			
			Parent moveInChecklistParent = FXMLLoader.load(application.getClass().getResource("/application/views/MoveInChecklist.fxml"));
			Scene moveInChecklistScene = new Scene(moveInChecklistParent,675,425);
			moveInChecklistScene.getStylesheets().add(application.getClass().getResource("application.css").toExternalForm());
			
			Parent ChoreSchParent = FXMLLoader.load(application.getClass().getResource("/application/views/ChoreSch.fxml"));
			Scene choreListScene = new Scene(ChoreSchParent,850,625);
			choreListScene.getStylesheets().add(application.getClass().getResource("application.css").toExternalForm());
			
			Parent roomDesignParent = FXMLLoader.load(application.getClass().getResource("/application/views/RoomDesign.fxml"));
			Scene roomDesignScene = new Scene(roomDesignParent,600,425);
			roomDesignScene.getStylesheets().add(application.getClass().getResource("application.css").toExternalForm());
	
			Parent groceryListParent = FXMLLoader.load(application.getClass().getResource("/application/views/GroceryList.fxml"));
			Scene groceryListScene = new Scene(groceryListParent,675,425);
			groceryListScene.getStylesheets().add(application.getClass().getResource("application.css").toExternalForm());
		
			Parent ChoreScheduleParent = FXMLLoader.load(application.getClass().getResource("/application/views/ChoreSchedule.fxml"));
			Scene ChoreScheduleScene = new Scene(ChoreScheduleParent,675,425);
			ChoreScheduleScene.getStylesheets().add(application.getClass().getResource("application.css").toExternalForm());

			Parent ChoreEntryParent = FXMLLoader.load(application.getClass().getResource("/application/views/ChoreEntry.fxml"));
			Scene ChoreEntryScene = new Scene(ChoreEntryParent,675,425);
			ChoreEntryScene.getStylesheets().add(application.getClass().getResource("application.css").toExternalForm());

			SceneSwitcher.AddScene(homeScene, "home");
			SceneSwitcher.AddScene(moveInChecklistScene, "move");
			SceneSwitcher.AddScene(roomDesignScene, "room");
			SceneSwitcher.AddScene(groceryListScene, "grocery");
			SceneSwitcher.AddScene(ChoreScheduleScene, "chore");
			SceneSwitcher.AddScene(ChoreEntryScene, "entChore");
		} catch (Exception e) {
			System.out.println("There was an error!");
			e.printStackTrace();
		}
	}
	
}

/**
 * SceneContainer is a Java class designed to store JavaFX Scenes and identifiers together. 
 * 
 * @author Dylan Watson (kgv351), Madeline Morales (ayv697), Jacob Ricondo (jgv856), Daniel Lugo-Diaz (hfp629), Stephanie Connolly (pwr781)
 * UTSA CS 3443.002 - Final Project
 * Spring 2021
 */
class SceneContainer {
	Scene scene;
	String identifier;
	
	/**
	 * @param scene scene to store
	 * @param identifier string to identify the scene by
	 */
	public SceneContainer(Scene scene, String identifier) {
		this.scene = scene;
		this.identifier = identifier;
	}
}
