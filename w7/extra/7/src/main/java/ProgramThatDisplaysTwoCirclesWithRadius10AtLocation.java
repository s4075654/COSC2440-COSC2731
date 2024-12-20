import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.Arrays;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

final public class ProgramThatDisplaysTwoCirclesWithRadius10AtLocation extends Application
{
   final Circle[] TWO_CIRCLES_WITH_RADIUS;
   Line aLineConnectingTheTwoCircles;
   Text theDistanceBetweenTheCircles;
   final Pane PANE;
   
   public ProgramThatDisplaysTwoCirclesWithRadius10AtLocation()
     {
	TWO_CIRCLES_WITH_RADIUS = new Circle[]
	  {
	     new Circle(40, 40, 10),
	     new Circle(120, 150, 10)
	  };
	aLineConnectingTheTwoCircles = new Line();
	aLineConnectingTheTwoCircles.setStartX(TWO_CIRCLES_WITH_RADIUS[0].getCenterX());
	aLineConnectingTheTwoCircles.setStartY(TWO_CIRCLES_WITH_RADIUS[0].getCenterY());
	aLineConnectingTheTwoCircles.setEndX(TWO_CIRCLES_WITH_RADIUS[1].getCenterX());
	aLineConnectingTheTwoCircles.setEndY(TWO_CIRCLES_WITH_RADIUS[1].getCenterY());
	theDistanceBetweenTheCircles = new Text((TWO_CIRCLES_WITH_RADIUS[0].getCenterX() + TWO_CIRCLES_WITH_RADIUS[1].getCenterX()) / 2, (TWO_CIRCLES_WITH_RADIUS[0].getCenterY() + TWO_CIRCLES_WITH_RADIUS[1].getCenterY()) / 2, String.valueOf(Math.sqrt(Math.pow(TWO_CIRCLES_WITH_RADIUS[1].getCenterX() - TWO_CIRCLES_WITH_RADIUS[0].getCenterX(), 2) + Math.pow(TWO_CIRCLES_WITH_RADIUS[1].getCenterY() - TWO_CIRCLES_WITH_RADIUS[0].getCenterY(), 2))));
	  
	Arrays.stream(TWO_CIRCLES_WITH_RADIUS)
	  .parallel()
	    .forEach(circle -> circle.setOnMouseDragged(event ->
							{
							   circle.setCenterX(event.getSceneX());
							   circle.setCenterY(event.getSceneY());
							   aLineConnectingTheTwoCircles.setStartX(TWO_CIRCLES_WITH_RADIUS[0].getCenterX());
							   aLineConnectingTheTwoCircles.setStartY(TWO_CIRCLES_WITH_RADIUS[0].getCenterY());
							   aLineConnectingTheTwoCircles.setEndX(TWO_CIRCLES_WITH_RADIUS[1].getCenterX());
							   aLineConnectingTheTwoCircles.setEndY(TWO_CIRCLES_WITH_RADIUS[1].getCenterY());
							   theDistanceBetweenTheCircles.setX((TWO_CIRCLES_WITH_RADIUS[0].getCenterX() + TWO_CIRCLES_WITH_RADIUS[1].getCenterX()) / 2);
							   theDistanceBetweenTheCircles.setY((TWO_CIRCLES_WITH_RADIUS[0].getCenterY() + TWO_CIRCLES_WITH_RADIUS[1].getCenterY()) / 2);
							   theDistanceBetweenTheCircles.setText(String.valueOf(Math.sqrt(Math.pow(TWO_CIRCLES_WITH_RADIUS[1].getCenterX() - TWO_CIRCLES_WITH_RADIUS[0].getCenterX(), 2) + Math.pow(TWO_CIRCLES_WITH_RADIUS[1].getCenterY() - TWO_CIRCLES_WITH_RADIUS[0].getCenterY(), 2))));
							}
							));
	
	PANE = new Pane();
	PANE.getChildren().addAll(TWO_CIRCLES_WITH_RADIUS);
	PANE.getChildren().addAll(aLineConnectingTheTwoCircles, theDistanceBetweenTheCircles);
     }
   
   public static void main(String[] args)
     {
	launch(args);
     }
   @Override
     public void start(Stage primaryStage)
       {
	  primaryStage.setScene(new Scene(PANE));
	  primaryStage.show();
       }
}
