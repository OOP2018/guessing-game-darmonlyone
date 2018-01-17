/**
 * A main class for the DarmGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 * @author Manusporn Fukkham
 */
public class Main {

	public static void main(String[] args) {
		// upper limit for secret number in guessing game (should be more than 0)
		int upperBound = Integer.MAX_VALUE-1;
		NumberGame game = new DarmGame(upperBound);
//		NumberGame game = new SampleGame(upperBound);
//		NumberGame game = new PakanonGuessingGame(upperBound);
//		GameConsole ui = new GameConsole();
		GameSolver ui = new GameSolver();
		int solution = ui.play( game );
		System.out.println("The secret number is "+solution);
		System.out.println("You have try "+game.getCount()+" times");
	}
}
