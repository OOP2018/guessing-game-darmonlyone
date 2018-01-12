/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {

	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100000;
		NumberGame game = new GuessingGame(upperBound);
//		NumberGame game = new SampleGame(upperBound)
//		NumberGame game = new PakanonGuessingGame(upperBound);
//		GameConsole ui = new GameConsole();
		GameSolver ui = new GameSolver();
		int solution = ui.play( game );
		System.out.println("The secret number is "+solution);
		System.out.println("You have try "+game.getCount()+" times");
	}
}
