import java.util.Scanner;
import java .util.Random;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to the Number Guessing Game!");
            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 7;

            while (true) {
                System.out.print("Enter your guess (1-100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You have reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (y/n): ");
            String userResponse = scanner.next();
            playAgain = userResponse.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing! Your final score is " + score + ".");
    }
}
