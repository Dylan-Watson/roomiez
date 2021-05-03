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
	    
	    private EventHandler mIconDragOverRoot=null;
	    private EventHandler mIconDragDropped=null;
	    private EventHandler mIconDragOverRightPane=null;

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
            
            addDragDetection(icn);
     
            icn.setType(DragIconType.values()[i]);
            left_pane.getChildren().add(icn);
        }
        
        buildDragHandlers();
    }
    
    pprivate void buildDragHandlers() {
        
    //drag over transition to move widget form left pane to right pane
    mIconDragOverRoot = new EventHandler <DragEvent>() {

        @Override
        public void handle(DragEvent event) {
 
            Point2D p = right_pane.sceneToLocal(event.getSceneX(), event.getSceneY());

            if (!right_pane.boundsInLocalProperty().get().contains(p)) {
                mDragOverIcon.relocateToPoint(new Point2D(event.getSceneX(), event.getSceneY()));
                return;
            }

            event.consume();
        }
    };
 
    mIconDragOverRightPane = new EventHandler <DragEvent> () {

        @Override
        public void handle(DragEvent event) {

            event.acceptTransferModes(TransferMode.ANY);
 
            mDragOverIcon.relocateToPoint(
                    new Point2D(event.getSceneX(), event.getSceneY())
                )
            );

            event.consume();
        }
    };
 
    mIconDragDropped = new EventHandler <DragEvent> () {

        @Override
        public void handle(DragEvent event) {
 
            event.setDropCompleted(true);

            right_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverRightPane);
            right_pane.removeEventHandler(DragEvent.DRAG_DROPPED, mIconDragDropped);
            base_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverRoot);
 
            mDragOverIcon.setVisible(false);
 
            event.consume();
        }
    };

    this.setOnDragDone (new EventHandler <DragEvent> (){
            
        @Override
    public void handle (DragEvent event) {

        right_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverRightPane);
        right_pane.removeEventHandler(DragEvent.DRAG_DROPPED, mIconDragDropped);
        base_pane.removeEventHandler(DragEvent.DRAG_OVER, mIconDragOverRoot);
                
        mDragOverIcon.setVisible(false);
                
        event.consume();
    }
    });
});
    
    private void addDragDetection(DragIcon dragIcon) {

        dragIcon.setOnDragDetected (new EventHandler <MouseEvent> () {

            @Override
            public void handle(MouseEvent event) {

                // set the other drag event handles on their respective objects
            base_pane.setOnDragOver(mIconDragOverRoot);
                right_pane.setOnDragOver(mIconDragOverRightPane);
                right_pane.setOnDragDropped(mIconDragDropped);
            
                // get a reference to the clicked DragIcon object
                DragIcon icn = (DragIcon) event.getSource();

                //begin drag ops
                mDragOverIcon.setType(icn.getType());
                mDragOverIcon.relocateToPoint(new Point2D (event.getSceneX(), event.getSceneY()));

                ClipboardContent content = new ClipboardContent();
                content.putString(icn.getType().toString());

                mDragOverIcon.startDragAndDrop (TransferMode.ANY).setContent(content);
                mDragOverIcon.setVisible(true);
                mDragOverIcon.setMouseTransparent(true);
                event.consume();
            }
        });
    }
}
