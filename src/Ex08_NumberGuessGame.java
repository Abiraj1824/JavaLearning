
import java.util.Scanner;
import java.util.Random;

public class Ex08_NumberGuessGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(10) + 1;
        int guess = 0;

        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Guess a number between 1 and 10.");

        while (guess != secretNumber) {

            System.out.print("Enter your guess: ");
            guess = input.nextInt();

            if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed correctly.");
            }
        }

        input.close();
    }
}
