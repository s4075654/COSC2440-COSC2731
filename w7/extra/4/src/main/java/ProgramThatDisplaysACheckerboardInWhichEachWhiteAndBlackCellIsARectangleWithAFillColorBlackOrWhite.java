import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

final public class ProgramThatDisplaysACheckerboardInWhichEachWhiteAndBlackCellIsARectangleWithAFillColorBlackOrWhite extends Application
{
   final Rectangle[][] RECTANGLES;
   GridPane checkerboard;
   
   public ProgramThatDisplaysACheckerboardInWhichEachWhiteAndBlackCellIsARectangleWithAFillColorBlackOrWhite()
     {
	RECTANGLES = new Rectangle[8][8];
	checkerboard = new GridPane();
	for (byte row = 0; row < 8; ++row)
	  {
	     for (byte cell = 0; cell < 8; ++cell)
	       {
		  RECTANGLES[row][cell] = new Rectangle(1, 1);
		  checkerboard.add(RECTANGLES[row][cell], cell, row);
		  if (row % 2 == cell % 2)
		    {
		       RECTANGLES[row][cell].setFill(Color.WHITE);
		    }
	       }
	  }
     }
   
   public static void main(String[] args)
     {
	launch(args);
     }
   @Override
     public void start(Stage primaryStage)
       {
	  primaryStage.setScene(new Scene(checkerboard));
	  primaryStage.show();
       }
}
