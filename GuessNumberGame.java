import java.util.Random;
import java.util.Scanner;

/**
 * A simple number guessing game.
 * The computer picks a random number between 1 and 100,
 * and the player tries to guess it with hints.
 */
public class GuessNumberGame {

    private static final int MIN = 1;
    private static final int MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + MIN + " and " + MAX + ".");

        do {
            int secretNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer.");
                    continue;
                }

                attempts++;

                if (guess < MIN || guess > MAX) {
                    System.out.println("Your guess is out of range. Guess between " + MIN + " and " + MAX + ".");
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");

        } while (playAgain);

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}