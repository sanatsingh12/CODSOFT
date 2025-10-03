import java.util.Scanner;
import java.util.Random;

class GuessGame {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int score = 0;
        String playAgain = "yes";

        while (playAgain.equals("yes")) {
            int number = rand.nextInt(100) + 1;  
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("I have chosen a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed it in " + attempts + " tries.");
                    score++;
                    guessed = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
            }

            if (!guessed) {
                System.out.println("Out of attempts! The number was " + number);
            }

            System.out.println("Score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().toLowerCase();
        }

        System.out.println("Game Over. Final Score: " + score);
        sc.close();
    }
}
