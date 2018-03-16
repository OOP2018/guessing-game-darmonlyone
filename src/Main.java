import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * A main class for the DarmGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * @author Manusporn Fukkham
 */
public class Main extends Application{

	/**Run the guessing game application*/
	public static void main(String[] args) {
		launch(args);
		// upper limit for secret number in guessing game (should be more than 0)
//		int upperBound = 100;
//		NumberGame game = new DarmGame(upperBound);
//		NumberGame game = new SampleGame(upperBound);
//		GameConsole ui = new GameConsole();
//		GameSolver ui = new GameSolver();
//		int solution = ui.play( game );
//		System.out.println("The secret number is "+solution);
//		System.out.println("You have try "+game.getCount()+" times");

	}

	/**
	 * run the FXML stage
	 * @param primaryStage XML stage
	 */
	@Override
	public void start(Stage primaryStage){
		try {
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("Guessing.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("The Guessing Game");
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch (Exception e){
			System.out.println("Exception creating scene: "+e.getMessage());
		}
	}
}
