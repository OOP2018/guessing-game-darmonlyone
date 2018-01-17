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
        int guess = 0;
        boolean correct = false;
        // for limit the lowest number of guessing after time
        int lowestGuess = 1;
        // for limit the highest number of guessing after time
        int highestGuess = game.getUpperBound();
        System.out.println(game);
        while (!correct) {
            guess = lowestGuess + (highestGuess - lowestGuess) / 2;
            correct = game.guess(guess);
            System.out.printf("Your answer? %d %n%s %n",guess ,game.getMessage());
            //set the lowest guess
            if ((game.getMessage().toLowerCase()).contains("small")) {
                lowestGuess = guess + 1;
            }//set the highest guess
            else if ((game.getMessage().toLowerCase()).contains("large")) {
                highestGuess = guess - 1;
            }
        }
        return guess;
    }
}
