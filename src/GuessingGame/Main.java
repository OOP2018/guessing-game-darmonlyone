package GuessingGame;

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
		NumberGame game = new DarmGame(100);

		try {
			FXMLLoader load =new FXMLLoader(getClass().getResource("Guessing.fxml"));
			Parent root = load.load();

			GuessingController guessingController = load.getController();
			guessingController.setUpperBound(100);
			guessingController.setGame(game);

			Scene scene = new Scene(root);
			primaryStage.setTitle("The Guessing Game");
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch (Exception e){
			System.out.println("Exception creating scene: "+e.getMessage());
		}
		CountView guessingView = new CountView(game);
		game.addObserver(guessingView);
		GuessView counterView = new GuessView(game);
		game.addObserver(counterView);
		guessingView.run();
		counterView.run();
	}
}
