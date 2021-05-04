package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class RoomDesignController extends Controller
{
	@FXML 
	public Canvas cc;
	
	//public void initialize ()
	//{
    	private GraphicsContext gc = cc.getGraphicsContext2D();
	//}
    
	
	
	@FXML
	public void handleBackMenu(ActionEvent e)
	{
		viewChanged("home");
	}
	
	@FXML
	public void handleRectangle(ActionEvent e)
	{
		System.out.println("Hey!");
		
	}
	
	public void drawRectangle(GraphicsContext gc)
	{
		gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2.0);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
	}
}



