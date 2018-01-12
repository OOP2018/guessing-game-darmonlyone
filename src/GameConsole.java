import java.util.Scanner;

/**
 *
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** console for playing a game
	 * @param  game is for game that choosing.
	 * @return guessing number that correct.
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println( game.toString() );
		
		// This is just an example.
		System.out.println( game.getMessage() );
		do {
			System.out.print("Your answer? ");
			int guess = console.nextInt();
			boolean correct = game.guess(guess);
			System.out.println(game.getMessage());
			if (correct) return guess;
		}while (true);

	}
	
}
