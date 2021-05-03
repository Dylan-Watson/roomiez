package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
			
			Parent homeParent = FXMLLoader.load(getClass().getResource("/application/views/HomeScreen.fxml"));
			Scene homeScene = new Scene(homeParent,675,425);
			homeScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());			
			
			Parent moveInChecklistParent = FXMLLoader.load(getClass().getResource("/application/views/MoveInChecklist.fxml"));
			Scene moveInChecklistScene = new Scene(moveInChecklistParent,675,425);
			moveInChecklistScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent roomDesignParent = FXMLLoader.load(getClass().getResource("/application/views/RootLayout.fxml"));
			Scene roomDesignScene = new Scene(roomDesignParent,675,425);
			roomDesignScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			Parent groceryListParent = FXMLLoader.load(getClass().getResource("/application/views/GroceryList.fxml"));
			Scene groceryListScene = new Scene(groceryListParent,675,425);
			groceryListScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			// Add all of the scenes to the scene switcher
			SceneSwitcher.SetRoot(primaryStage);
			SceneSwitcher.AddScene(mainScene, "main");
			SceneSwitcher.AddScene(homeScene, "home");
			SceneSwitcher.AddScene(moveInChecklistScene, "move");
			SceneSwitcher.AddScene(roomDesignScene, "room");
			SceneSwitcher.AddScene(groceryListScene, "grocery");

			
			primaryStage.setScene(homeScene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	//root.setCenter(new RootLayout());
    }
}
