import javafx.application.Application;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.text.Text;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.Scene;

final public class ProgramThatPicksAndDisplaysThreeCardsRandomlySelectedFromADeckOf52 extends Application
{
   private List<Integer> randomlySelected;
   private List<ObjectProperty<Image>> cards;
   private StringProperty totalPoints;
   
   final private static String PNG = ".png";
   
   public ProgramThatPicksAndDisplaysThreeCardsRandomlySelectedFromADeckOf52()
     {
	randomlySelected = new Random()
	  .ints(1, 53)
	    .limit(3)
	      .boxed()
		.collect(Collectors.toList());
	cards = new ArrayList<ObjectProperty<Image>>(3);
	for (byte card = 0; card < 3; ++card)
	  {
	     cards.add(new SimpleObjectProperty<Image>());
	     cards.get(card).set(new Image(getClass().getResourceAsStream("/cards/" + String.valueOf(randomlySelected.get(card)) + PNG)));
	  }
	totalPoints = new SimpleStringProperty(String.valueOf(total(randomlySelected)) + "points");
     }
   
   public static void main(String[] args)
     {
	launch(args);
     }
   private static int total(final List<Integer> POINTS)
     {
	return POINTS.parallelStream()
	  .map(point -> ((point - 1) % 13) + 1)
	    .reduce(0, Integer::sum);
     }
   
   @Override
     final public void start(Stage primaryStage)
       {
	  final HBox DISPLAYS_THREE_CARDS = new HBox();
	  ImageView[] threeCards = new ImageView[3];
	  for (byte card = 0; card < 3; ++card)
	    {
	       threeCards[card] = new ImageView();
	       threeCards[card].imageProperty().bind(cards.get(card));
	    }

	  DISPLAYS_THREE_CARDS.getChildren().addAll(threeCards);
	  
	  Text show = new Text();
	  show.textProperty().bind(totalPoints);
	  
	  final HBox DEAL_AND_EXIT = new HBox();
	  final Button DEAL = new Button("Deal");
	  DEAL.setOnAction(event -> {
	     randomlySelected = new Random()
	       .ints(1, 53)
		 .limit(3)
		   .boxed()
		     .collect(Collectors.toList());
	     for (byte card = 0; card < 3; ++card)
	       {
		  cards.get(card).set(new Image(getClass().getResourceAsStream("/cards/" + String.valueOf(randomlySelected.get(card)) + PNG)));
	       }
	     totalPoints.set(String.valueOf(total(randomlySelected)) + "points");
	  }
			   );
	  final Button EXIT = new Button("Exit");
	  EXIT.setOnAction(event -> primaryStage.close());
	  DEAL_AND_EXIT.getChildren().addAll(DEAL, EXIT);
	  
	  final VBox BOX = new VBox();
	  BOX.getChildren().addAll(DISPLAYS_THREE_CARDS, show, DEAL_AND_EXIT);
	  
	  primaryStage.setScene(new Scene(BOX));
	  primaryStage.show();
       }
}
