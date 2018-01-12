
import java.util.Random;

/**
 * Game of guessing a secrect number.
 * @author Manusporn Fukkham
 */
public class GuessingGame extends NumberGame{
    /** upper bound for secret number */
    private int upperBound;
    /** the solution of the game */
    private int secret;
    /** count the game play */
    private int count;
    /** Initialize a new default game. */
    public GuessingGame(){
        this(100);
    }

    public GuessingGame(int upperbound){
         Random rd = new Random();
        //set UpperBound
        this.upperBound = upperbound;
        //create secret number
        secret = rd.nextInt(upperBound)+1;
        System.out.println("I'm thinking of a number between 1 and "+upperbound);
    }

    /**
     * Evaluate a user's guess.
     * @param number is the user's guess
     * @return true if guess is correct, false otherwise
     */
    @Override
    public boolean guess(int number){
        count++;
        if (number == secret) {
            setMessage("Correct! the secret number is "+secret);
            return true;
        }
        // the number close to solution less than 10 number
        if ((number - secret )>= -10 && (number - secret )<= 0 ) {
            setMessage("too small, you are so close");
        }
        // the number close to solution more than 10 number
        else if ((number - secret )<= 10 && (number - secret )>= 0 ) {
            setMessage("too large, you are so close");
        }
        else if (number < secret) {
            setMessage("too small");
        }
        else if (number > secret) {
            setMessage("too large");
        }
        return false;
    }

    /**
     *
     * @return UpperBound for the solution
     */
    public int getUpperBound(){
        return Math.abs(upperBound);
    }

    @Override
    public String toString() {
        return "Guess a secret number between 1 and "+Math.abs(upperBound);
    }

    /**
     *
     * @return count number game that you have guess
     */
    public  int getCount() {
        return count;
    }
}
