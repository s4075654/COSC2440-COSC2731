import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;

final public class ProgramThatDrawsAFixedCircleCentredAt extends Application
{
   final Circle A_FIXED_CIRCLE_CENTRED_AT;
   Text aMessageIndicatingWhetherTheMousePointIsInsideTheCircleAtTheMousePointOrOutsideOfIt;
   final Pane PANE;
   
   public ProgramThatDrawsAFixedCircleCentredAt()
     {
	A_FIXED_CIRCLE_CENTRED_AT = new Circle(100, 60, 50);
	aMessageIndicatingWhetherTheMousePointIsInsideTheCircleAtTheMousePointOrOutsideOfIt = new Text();
	PANE = new Pane(A_FIXED_CIRCLE_CENTRED_AT, aMessageIndicatingWhetherTheMousePointIsInsideTheCircleAtTheMousePointOrOutsideOfIt);
	
	PANE.setOnMouseMoved(event -> aMessageIndicatingWhetherTheMousePointIsInsideTheCircleAtTheMousePointOrOutsideOfIt.setText((Math.sqrt(Math.pow(event.getX() - A_FIXED_CIRCLE_CENTRED_AT.getCenterX(), 2) + Math.pow(event.getY() - A_FIXED_CIRCLE_CENTRED_AT.getCenterY(), 2)) <= A_FIXED_CIRCLE_CENTRED_AT.getRadius()) ? "The mouse point is inside the circle at the mouse point." : "Outside of it."));
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
