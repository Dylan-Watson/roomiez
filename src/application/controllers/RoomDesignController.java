package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class RoomDesignController extends Controller
{
	@FXML 
	public Canvas canvas = new Canvas();
	
	//public void initialize ()
	//{
		//this.canvas = canvas;
    	public GraphicsContext gc = canvas.getGraphicsContext2D();
    	

	//}
    
	
	
	@FXML
	public void handleBackMenu(ActionEvent e)
	{
		viewChanged("home");
	}
	
	@FXML
	public void handleRectangle(ActionEvent e)
	{
		drawRectangle(gc);
		System.out.println("Here!");
		
	}
	
	private void drawRectangle(GraphicsContext gc)
	{
		
		gc.setFill(Color.RED);
		gc.setFill(Color.RED);
        gc.setStroke(Color.RED);
        gc.setLineWidth(2.0);
        //gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 10, 30, 30);
        System.out.println("Should be rectangle here Lol!");
        //gc.strokeOval(60, 60, 30, 30);
	}
}



