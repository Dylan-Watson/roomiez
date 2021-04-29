package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	try {
			// Define the basic calculator (default) scene
			Parent mainParent = FXMLLoader.load(getClass().getResource("/application/views/Main.fxml"));
			Scene mainScene = new Scene(mainParent,400,400);
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Define the date calculator scene
			Parent homeParent = FXMLLoader.load(getClass().getResource("/application/views/HomeScreen.fxml"));
			Scene homeScene = new Scene(homeParent,400,400);
			homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			
			// Define the temperature calculator scene
			Parent moveInChecklistParent = FXMLLoader.load(getClass().getResource("/application/views/MoveInChecklist.fxml"));
			Scene moveInChecklistScene = new Scene(moveInChecklistParent,400,400);
			moveInChecklistScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Add all of the scenes to the scene switcher
			SceneSwitcher.SetRoot(primaryStage);
			SceneSwitcher.AddScene(mainScene, "main");
			SceneSwitcher.AddScene(homeScene, "home");
			SceneSwitcher.AddScene(moveInChecklistScene, "move");
			
			// Set the default scene (basic calculator)
			primaryStage.setScene(mainScene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
