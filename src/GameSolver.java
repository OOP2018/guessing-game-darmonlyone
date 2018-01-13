import java.util.Random;
/**
 * Automatically find the secret to any NumberGame.
 * @author Manusporn fukkham
 */
public class GameSolver {
    /**
     * Play a NumberGame and return the solution.
     * The NumberGame object must povide message (getMassage)
     * containing the phrase "too samll" if a guess is too small
     * and "too large" if a guess is to large, for efficient
     * solution.
     *
     * @param game is the NumberGame to solve
     * @return the solution of the game
     */
    public int play(NumberGame game) {
        Random rd = new Random();
        // for limit lowest guess after time
        int lowestGuess = 1;
        // for limit the highest after time
        int highestGuess = game.getUpperBound();
        System.out.println(game.toString());
        System.out.println(game.getMessage());
        while (true) {
            System.out.print("Your answer? ");
            int guess = rd.nextInt(highestGuess) + 1;
                if (guess < lowestGuess)
                    guess = lowestGuess + Math.abs((highestGuess - lowestGuess) / 2);
            System.out.println(guess);
            boolean correct = game.guess(guess);
            System.out.println(game.getMessage());
            if (correct) return guess;
            //set the limit lowest guess
            if (game.getMessage().contains("small")) {
                lowestGuess = guess+1;
            }//set the limit highest guess
            else if (game.getMessage().contains("large")) {
                highestGuess = guess-1;
            }

        }

    }
}
