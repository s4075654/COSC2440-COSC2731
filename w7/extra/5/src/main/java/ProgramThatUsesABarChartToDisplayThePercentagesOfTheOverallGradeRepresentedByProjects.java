import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

final public class ProgramThatUsesABarChartToDisplayThePercentagesOfTheOverallGradeRepresentedByProjects extends Application
{
   final Rectangle[] BARS;
   final Text[] REPRESENTATIONS;
   HBox aBarChart;
   
   public ProgramThatUsesABarChartToDisplayThePercentagesOfTheOverallGradeRepresentedByProjects()
     {
	BARS = new Rectangle[4];
	REPRESENTATIONS = new Text[4];
	BARS[0] = new Rectangle(1, 20 / 100.0, Color.RED);
	REPRESENTATIONS[0] = new Text("Project -- 20%");
	BARS[1] = new Rectangle(1, 10 / 100.0, Color.BLUE);
	REPRESENTATIONS[1] = new Text("Quiz -- 20%");
	BARS[2] = new Rectangle(1, 30 / 100.0, Color.GREEN);
	REPRESENTATIONS[2] = new Text("Midterm -- 30%");
	BARS[3] = new Rectangle(1, 40 / 100.0, Color.ORANGE);
	REPRESENTATIONS[3] = new Text("Final -- 40%");
	final VBox[] BOXES = new VBox[4];
	for (byte bar = 0; bar < 4; ++bar)
	  {
	     REPRESENTATIONS[bar].getTransforms().add(new Scale(1, -1, REPRESENTATIONS[bar].getX(), REPRESENTATIONS[bar].getY()));
	     BOXES[bar] = new VBox(BARS[bar], REPRESENTATIONS[bar]);
	  }
	  
	aBarChart = new HBox(BOXES);
	aBarChart.setScaleY(-1);
     }
   
   public static void main(String[] args)
     {
	launch(args);
     }
   @Override
     public void start(Stage primaryStage)
       {
	  primaryStage.setScene(new Scene(aBarChart));
	  primaryStage.show();
       }
}
