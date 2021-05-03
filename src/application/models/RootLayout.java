package application.models;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.control.SplitPane;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class RootLayout extends AnchorPane{
	
	    @FXML SplitPane base_pane;
	    @FXML AnchorPane right_pane;
	    @FXML VBox left_pane;

	    private DragIcon mDragOverIcon = null;

    public RootLayout() {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/RootLayout.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    private void initialize() 
    {
    	
    	mDragOverIcon = new DragIcon();
    	 
        mDragOverIcon.setVisible(false);
        mDragOverIcon.setOpacity(0.65);
        getChildren().add(mDragOverIcon); 

        for (int i = 0; i < 7; i++) 
        {
     
            DragIcon icn = new DragIcon();
     
            icn.setType(DragIconType.values()[i]);
            left_pane.getChildren().add(icn);
        }
    }
}
