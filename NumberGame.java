
import java.util.Random;
import java.util.*;

public class NumberGame {

    public static void main(String[] args) {
        playMultipleRounds();
    }

    private static void playMultipleRounds() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int roundsPlayed = 0;
        int roundsWon = 0;
        do {
            playGame(random);
            roundsPlayed++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        } while (true);

        System.out.println("\nRounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);
    }

    private static void playGame(Random random) {
        final int lL = 1;
        final int uL = 100;
        int target = random.nextInt(uL - lL + 1) + lL;
        int maxAttempts = 10;
        int attempts = 0;

        System.out.println("Guess the number between " + lL + " and " + uL+ ":");

        while (attempts < maxAttempts) {
            int userGuess = getUserInput();

            if (userGuess == target) {
                System.out.println("Congratulations! You guessed the correct number " + target + " in " +
                        (attempts + 1) + " attempts.");
                break;
            } else if (userGuess < target) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attempts++;
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + target + ".");
        }
    }

    private static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        int userGuess = 0;

        try {
            System.out.print("Enter your guess: ");
            userGuess = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            userGuess = getUserInput();
        }

        return userGuess;
    }
}
