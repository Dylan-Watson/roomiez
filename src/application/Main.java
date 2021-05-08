package application;

import java.util.ArrayList;

import application.models.Chore;
import application.models.ChoreSchedule;
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
    	
    	//BorderPane root = new BorderPane();
    	
    	try {
    		
    		Parent mainParent = FXMLLoader.load(getClass().getResource("/application/views/Main.fxml"));
			Scene mainScene = new Scene(mainParent,675,425);
			mainScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    		
    		Parent choreScheduleParent = FXMLLoader.load(getClass().getResource("/application/views/ChoreSchedule.fxml"));
			Scene choreScene = new Scene(choreScheduleParent,675,425);
			choreScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent enterChoreParent = FXMLLoader.load(getClass().getResource("/application/views/ChoreEntry.fxml"));
			Scene enterChoreScene = new Scene(enterChoreParent,360,520);
			enterChoreScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent homeParent = FXMLLoader.load(getClass().getResource("/application/views/HomeScreen.fxml"));
			Scene homeScene = new Scene(homeParent,675,425);
			homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			
			Parent moveInChecklistParent = FXMLLoader.load(getClass().getResource("/application/views/MoveInChecklist.fxml"));
			Scene moveInChecklistScene = new Scene(moveInChecklistParent,675,425);
			moveInChecklistScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent roomDesignParent = FXMLLoader.load(getClass().getResource("/application/models/RootLayout.fxml"));
			Scene roomDesignScene = new Scene(roomDesignParent,675,425);
			roomDesignScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Add all of the scenes to the scene switcher
			SceneSwitcher.SetRoot(primaryStage);
			SceneSwitcher.AddScene(mainScene, "main");
			SceneSwitcher.AddScene(homeScene, "home");
			SceneSwitcher.AddScene(moveInChecklistScene, "move");
			SceneSwitcher.AddScene(roomDesignScene, "room");
			SceneSwitcher.AddScene(choreScene, "chore");
			SceneSwitcher.AddScene(enterChoreScene, "entChore");

			primaryStage.setScene(mainScene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	//root.setCenter(new RootLayout());
    }
    
    public ChoreSchedule currChoreList() {
    	ChoreSchedule currChoreList = new ChoreSchedule();
    	
    	
		return currChoreList;
	}
    
    
}
