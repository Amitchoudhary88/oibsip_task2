package project;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 5;

    private int targetNumber;
    private int attempts;
    private int score;
    private int rounds;

    public NumberGuessingGame() {
        targetNumber = generateRandomNumber();
        attempts = 0;
        score = 0;
        rounds = 0;
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Guess the Number game!");
        System.out.println("I have chosen a number between " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

        boolean playAgain = true;

        while (playAgain) {
            rounds++;
            attempts = 0;
            targetNumber = generateRandomNumber();

            boolean guessedCorrectly = false;

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine();

                attempts++;

                if (guess == targetNumber) {
                    guessedCorrectly = true;
                    int roundScore = MAX_ATTEMPTS - attempts + 1;
                    score += roundScore;
                    System.out.println("Congratulations! You guessed the number correctly!");
                    System.out.println("Round Score: " + roundScore);
                    System.out.println("Total Score: " + score);
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Oops! You couldn't guess the number. The number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.nextLine();

            if (!playAgainChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Final Score: " + score);
        System.out.println("Total Rounds Played: " + rounds);

        scanner.close();
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.play();
    }
}
