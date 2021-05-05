package application;

import application.controllers.RoomDesignController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    //this is a test
    @Override
    public void start(Stage primaryStage) {
    	
    	
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
			
			Parent ChoreSchParent = FXMLLoader.load(getClass().getResource("/application/views/ChoreSch.fxml"));
			Scene choreListScene = new Scene(ChoreSchParent,675,425);
			choreListScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent roomDesignParent = FXMLLoader.load(getClass().getResource("/application/views/RoomDesign.fxml"));
			//Canvas canvas = new Canvas(675,425);
			//GraphicsContext GC = canvas.getGraphicsContext2D();
			//GC.setLineWidth(3.0);
			//GC.setFill(Color.DARKSEAGREEN);
			//GC.strokeRect(10, 10, 50, 50);
			//Pane roomDesignCanvas = new Pane();
			//roomDesignCanvas.getChildren().add(canvas);
			//Scene roomDesignScene = new Scene(roomDesignCanvas);
			Scene roomDesignScene = new Scene(roomDesignParent,600,425);
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
			SceneSwitcher.AddScene(choreListScene, "chore");

			
			primaryStage.setScene(mainScene);
			primaryStage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    }
}
