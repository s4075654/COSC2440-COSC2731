import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;

final public class ProgramThatDisplaysFourCountryFlagsInAGridPane extends Application
{
   final private Image[] FOUR_COUNTRY_FLAGS;
   final private ImageView[] DISPLAY;
   private GridPane aGridPane;
   final private static String COUNTRY_FLAG = "/CountryFlag.j";
   
   public ProgramThatDisplaysFourCountryFlagsInAGridPane()
     {
	FOUR_COUNTRY_FLAGS = new Image[]
	  {
	     new Image(getClass().getResourceAsStream(COUNTRY_FLAG + "fif")),
	     new Image(getClass().getResourceAsStream(COUNTRY_FLAG + "pe")),
	     new Image(getClass().getResourceAsStream(COUNTRY_FLAG + "peg")),
	     new Image(getClass().getResourceAsStream(COUNTRY_FLAG + "pg"))
	  };
	DISPLAY = new ImageView[]
	  {
	     new ImageView(FOUR_COUNTRY_FLAGS[0]),
	     new ImageView(FOUR_COUNTRY_FLAGS[1]),
	     new ImageView(FOUR_COUNTRY_FLAGS[2]),
	     new ImageView(FOUR_COUNTRY_FLAGS[3]),
	  };
	aGridPane = new GridPane();
	aGridPane.add(DISPLAY[0], 1, 1);
	aGridPane.add(DISPLAY[1], 0, 1);
	aGridPane.add(DISPLAY[2], 1, 0);
	aGridPane.add(DISPLAY[3], 0, 0);
     }

   public static void main(String[] args)
     {
	launch(args);
     }
   @Override
     final public void start(Stage primaryStage)
       {
	  primaryStage.setScene(new Scene(aGridPane));
	  primaryStage.show();
       }
}
