import java.util.Random;

/**
 * Game of guessing a secrect number.
 * @author Manusporn Fukkham
 */
public class DarmGame extends NumberGame{
    /** upper bound for secret number */
    private int upperBound;
    /** the solution of the game */
    private int secret;
    /** count the game play */
    private int count;
    /** Initialize a new default game. */
    public DarmGame(){
        this(100);
    }

    /**
     * Initialize a new game.
     * @param upperbound is too limit the max valus of this game.
     *                   upperbound should more than 0.
     */
    public DarmGame(int upperbound){
        if (upperbound < 1){
            System.out.println("Please set upperbound more than 0");
            System.exit(0);
        }
         setSecret(upperbound);
        System.out.println("I'm thinking of a number between 1 and "+upperbound);
    }

    public void setSecret(int secret) {
        Random rd = new Random();
        //set UpperBound
        this.upperBound = secret;
        //create secret number
        this.secret = rd.nextInt(upperBound)+1;
    }

    /**
     * Evaluate a user's guess.
     * @param number is the user's guess
     * @return true if guess is correct, false otherwise
     */
    @Override
    public boolean guess(int number){
        count++;
        setChanged();
        notifyObservers();
        if (number == secret) {
            setMessage("Correct! "+ secret +" is secret number");
            return true;
        }
        // the number close to solution less than 10 number
        if ((number - secret )>= -5 && (number - secret )<= 0 ) {
            setMessage("too small, you are so close");
        }
        // the number close to solution more than 10 number
        else if ((number - secret )<= 5 && (number - secret )>= 0 ) {
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
    @Override
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
    @Override
    public  int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
        setChanged();
        notifyObservers();
    }
}
