import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        Random random=new Random();

        int minRange=1;
        int maxRange=100;
        boolean playAgain=true;

        System.out.println("Welcome to guess number game");
        System.out.println("You will be asked to guess a number to win the game");
        System.out.println("You have maximum 5 attempt limit");

        while (playAgain) {
            System.out.println("Select difficulty level:");
            System.out.println("1. Easy (1-30)");
            System.out.println("2. Medium (1-70)");
            System.out.println("3. Hard (1-100)");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    maxRange = 30;
                    break;
                case 2:
                    maxRange = 70;
                    break;
                case 3:
                    maxRange = 100;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                    continue;
            }
            int attempts=0;
            int maxAttempts=5;
            int targetNumber= random.nextInt(maxRange- minRange +1)+ minRange;
            while (attempts < maxAttempts) {
                System.out.println("Enter a guess number between 1 and "+ maxRange);
                int guess = scanner.nextInt();
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Your guess number is Smaller.");
                } else if (guess > targetNumber) {
                    System.out.println("Your guess number is Greater.");
                } else if (guess == targetNumber) {
                    System.out.println("OOhhOO!, Your number is correct. You win the game.");
                    break;
                }

                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts! The number was: " + targetNumber);
                }
            }
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }
        System.out.println("Thank you for playing!");
    }
}
