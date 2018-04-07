package GuessingGame;

import java.util.Scanner;

/**
 *
 *  Play guessing game on the console.
 * @author Manusporn Fukkham
 */
public class GameConsole {

	/** console for playing a game
	 * @param  game is for game that choosing.
	 * @return guessing number that correct.
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		// describe the game
		System.out.println(game);
		int guess;
		boolean correct;
		do {
			System.out.print("Your answer? ");
			guess = console.nextInt();
			correct = game.guess(guess);
			System.out.println(game.getMessage());
		}while (!correct);
		return guess;
	}
	
}
