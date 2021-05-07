package application.controllers;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.scene.layout.Pane;


public class RoomDesignController extends Controller
{
	@FXML public Canvas canvas;
	@FXML public Pane pane;
	private GraphicsContext gc;
	private Group root;
	private Scene scene;
	private ArrayList<String> colorPalette = new ArrayList<String>();
	private int currentColor = 0;
	
	@FXML
	public void initialize() {
		gc = canvas.getGraphicsContext2D();
		root = new Group();
		scene = null;
		colorPalette.add("#fc3838"); //salmon red
		colorPalette.add("#ff7536"); //orange
		colorPalette.add("#ffb536"); //yellow
		colorPalette.add("#54ff65"); //green
		colorPalette.add("#5e74ff"); //blue
		colorPalette.add("#94009c"); //purple
		colorPalette.add("#ffffff"); //white
	}
	
	@FXML
	public void handlePaneMouseMoved(MouseEvent event) { // TODO: This is a really bad way of doing this, but it does work
		if(scene == null) {
			scene = ((Node)(event.getSource())).getScene();
			pane.getChildren().add(root);
			scene.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
				if(e.getButton() == MouseButton.SECONDARY) {
					drawRectangle(gc, e);
				}
			});
		}
	}
	
	@FXML
	public void handleBackMenu(ActionEvent e)
	{
		viewChanged("home");
	}
	
	@FXML
	public void handleRectangle(ActionEvent e)
	{
		drawRectangle(gc, null); // TODO: Fix this
	}
	
	private void drawRectangle(GraphicsContext gc, MouseEvent e)
	{
		Rectangle rect = new Rectangle(30,30);
		pane.getChildren().add(rect);
		if(currentColor == 7) currentColor = 0;
		rect.setFill(Paint.valueOf("transparent"));
		rect.setStroke(Paint.valueOf(colorPalette.get(currentColor)));
		rect.setStrokeWidth(2.0);
		Scale scaler = new Scale(1, 1);
		Translate center;
		if(e != null)
			center = new Translate(e.getX(), e.getY());
		else
			center = new Translate(30, 150);
		rect.getTransforms().add(center);
        rect.getTransforms().add(scaler);
        rect.addEventFilter(MouseEvent.MOUSE_DRAGGED, e2->{
            if(e2.getButton()==MouseButton.PRIMARY)
            {
                //resize with left drag
                double scaleX=e2.getSceneX()-rect.localToParent(0,0).getX();
                double scaleY=e2.getSceneY()-rect.localToParent(0,0).getY();
                scaler.setX(scaleX/100);
                scaler.setY(scaleY/100);
            } else if(e2.getButton()==MouseButton.MIDDLE)
            {
                //move with middle drag
                center.setX(e2.getSceneX());
                center.setY(e2.getSceneY());
            }
        });
		currentColor++;
	}
	
	@FXML
	public void handleCircle(ActionEvent e)
	{
		drawCircle(gc, null); // TODO: Fix this
	}
	
	private void drawCircle(GraphicsContext gc, MouseEvent e)
	{
		Circle circle = new Circle(15);
		pane.getChildren().add(circle);
		if(currentColor == 5) currentColor = 0;
		circle.setFill(Paint.valueOf("transparent"));
		circle.setStroke(Paint.valueOf(colorPalette.get(currentColor)));
		circle.setStrokeWidth(2.0);
		Scale scaler = new Scale(1, 1);
		Translate center;
		if(e != null)
			center = new Translate(e.getX(), e.getY());
		else
			center = new Translate(45, 120);
		circle.getTransforms().add(center);
		circle.getTransforms().add(scaler);
		circle.addEventFilter(MouseEvent.MOUSE_DRAGGED, e2->{
            if(e2.getButton()==MouseButton.PRIMARY)
            {
                //resize with left drag
                double scaleX=e2.getSceneX()-circle.localToParent(0,0).getX();
                double scaleY=e2.getSceneY()-circle.localToParent(0,0).getY();
                scaler.setX(scaleX/100);
                scaler.setY(scaleY/100);
            } else if(e2.getButton()==MouseButton.MIDDLE)
            {
                //move with middle drag
                center.setX(e2.getSceneX());
                center.setY(e2.getSceneY());
            }
        });
		currentColor++;
	}
	
	@FXML
	public void handleLine(ActionEvent e)
	{
		drawLine(gc, null); // TODO: Fix this
	}
	
	private void drawLine(GraphicsContext gc, MouseEvent e)
	{
		Line line = new Line(60, 120, 90, 120);
		pane.getChildren().add(line);
		if(currentColor == 5) currentColor = 0;
		line.setFill(Paint.valueOf("transparent"));
		line.setStroke(Paint.valueOf(colorPalette.get(currentColor)));
		line.setStrokeWidth(2.0);
		Scale scaler = new Scale(1, 1);
		Translate center;
		if(e != null)
			center = new Translate(e.getX(), e.getY());
		else
			center = new Translate(45, 120);
		line.getTransforms().add(center);
		line.getTransforms().add(scaler);
		line.addEventFilter(MouseEvent.MOUSE_DRAGGED, e2->{
            if(e2.getButton()==MouseButton.PRIMARY)
            {
                //resize with left drag
                double scaleX=e2.getSceneX()-line.localToParent(0,0).getX();
                double scaleY=e2.getSceneY()-line.localToParent(0,0).getY();
                scaler.setX(scaleX/100);
                scaler.setY(scaleY/100);
            } else if(e2.getButton()==MouseButton.MIDDLE)
            {
                //move with middle drag
                center.setX(e2.getSceneX());
                center.setY(e2.getSceneY());
            }
        });
		currentColor++;
	}
}



