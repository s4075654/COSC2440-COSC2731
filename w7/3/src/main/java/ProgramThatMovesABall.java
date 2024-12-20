import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

final class PaneClass extends Pane
{
   private Circle aBall;
   
   PaneClass(final Circle A_BALL)
     {
	aBall = A_BALL;
     }
   
   final void checkTheBoundary()
     {
	aBall.setCenterX(Math.max(aBall.getRadius(), Math.min(aBall.getCenterX(), this.getWidth() - aBall.getRadius())));
	aBall.setCenterY(Math.max(aBall.getRadius(), Math.min(aBall.getCenterY(), this.getHeight() - aBall.getRadius())));
     }
   final void moveLeft()
     {
	aBall.setCenterX(aBall.getCenterX() - 1);
	checkTheBoundary();
     }
   final void moveRight()
     {
	aBall.setCenterX(aBall.getCenterX() + 1);
	checkTheBoundary();
     }
   final void moveUp()
     {
	aBall.setCenterY(aBall.getCenterY() - 1);
	checkTheBoundary();
     }
   final void moveDown()
     {
	aBall.setCenterY(aBall.getCenterY() + 1);
	checkTheBoundary();
     }
}

final public class ProgramThatMovesABall extends Application
{
   final Circle A_BALL;
   final PaneClass A_PANE;
   final Button[] BUTTONS;
   final HBox GUI_BUTTONS;
   final VBox BOX;
   
   public ProgramThatMovesABall()
     {
	A_BALL = new Circle(1);
	A_PANE = new PaneClass(A_BALL);
	A_PANE.setPrefSize(2, 2);
	A_PANE.getChildren().add(A_BALL);
	A_PANE.setOnKeyPressed(event -> 
			       {
				  switch (event.getCode())
				    {
				       case KeyCode.LEFT ->
					 {
					    A_PANE.moveLeft();
					    break;
					 }
				       case KeyCode.RIGHT ->
					 {
					    A_PANE.moveRight();
					    break;
					 }
				       case KeyCode.UP ->
					 {
					    A_PANE.moveUp();
					    break;
					 }
				       case KeyCode.DOWN ->
					 {
					    A_PANE.moveDown();
					 }
				    }
			       }
			       );
	
	BUTTONS = new Button[]
	  {
	     new Button("Left"),
	     new Button("Right"),
	     new Button("Up"),
	     new Button("Down")
	  };
	BUTTONS[0].setOnAction(event -> A_PANE.moveLeft());
	BUTTONS[1].setOnAction(event -> A_PANE.moveRight());
	BUTTONS[2].setOnAction(event -> A_PANE.moveUp());
	BUTTONS[3].setOnAction(event -> A_PANE.moveDown());
	GUI_BUTTONS = new HBox(BUTTONS);
	
	BOX = new VBox(A_PANE, GUI_BUTTONS);  
     }
   
   public static void main(String[] args)
     {
	launch(args);
     }
   @Override
     public void start(Stage primaryStage)
       {
	  primaryStage.setScene(new Scene(BOX));
	  primaryStage.show();
       }
}
