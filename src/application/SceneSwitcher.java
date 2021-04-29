package application;

import java.util.ArrayList;

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
