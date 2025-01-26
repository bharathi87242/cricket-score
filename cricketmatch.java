import java.util.Random;
import java.util.Scanner;

public class ManualCricketGame {

    static int totalRuns = 0;  // Tracks total runs scored
    static int wickets = 0;    // Tracks number of wickets
    static int ballsFaced = 0; // Tracks the number of balls faced
    static int overs = 0;      // Tracks the number of overs

    static final int MAX_OVERS = 5; // Number of overs per innings
    static final int MAX_BALLS_PER_OVER = 6; // Balls per over

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Manual Cricket Game!");
        System.out.println("You are the batsman. Try to score as many runs as you can.");
        
        // Main game loop: Play until all overs are completed or player gets out.
        while (overs < MAX_OVERS && wickets < 1) {
            System.out.println("\nOver " + (overs + 1) + ":");

            // Simulate bowling
            bowlOver(scanner);

            // Check if the player is out or all overs are completed
            if (wickets >= 1) {
                System.out.println("You are out! Your total score is: " + totalRuns + " runs.");
                break;
            }

            if (ballsFaced >= MAX_OVERS * MAX_BALLS_PER_OVER) {
                System.out.println("All overs are completed! Your total score is: " + totalRuns + " runs.");
                break;
            }
        }

        scanner.close();
    }

    // Simulate an over of bowling
    public static void bowlOver(Scanner scanner) {
        Random rand = new Random();

        // Bowl each ball in the over
        for (int ball = 1; ball <= MAX_BALLS_PER_OVER; ball++) {
            ballsFaced++;

            System.out.println("\nBall " + ball + ":");
            System.out.print("Press Enter to face the ball... ");
            scanner.nextLine(); // Wait for the user to press Enter

            // Generate a random outcome for the ball
            int outcome = rand.nextInt(6);  // Random number from 0 to 5

            switch (outcome) {
                case 0:
                    System.out.println("Dot ball! No runs.");
                    break;
                case 1:
                    System.out.println("You scored 1 run.");
                    totalRuns += 1;
                    break;
                case 2:
                    System.out.println("You scored 2 runs.");
                    totalRuns += 2;
                    break;
                case 3:
                    System.out.println("You scored 3 runs.");
                    totalRuns += 3;
                    break;
                case 4:
                    System.out.println("You hit a FOUR!");
                    totalRuns += 4;
                    break;
                case 5:
                    System.out.println("You are OUT!");
                    wickets += 1;  // Player is out
                    break;
                default:
                    System.out.println("Invalid outcome.");
                    break;
            }

            // Check if the batsman is out or overs are completed
            if (wickets >= 1) {
                break;
            }
        }
        overs++;  // Increment overs after each over
    }
}

Explanation of the Code:
Game Setup:

The game begins with a welcome message and sets up the number of overs (MAX_OVERS) and balls per over (MAX_BALLS_PER_OVER).
Main Gameplay Loop:

The game loops through each over and each ball in the over.
The user is prompted to "Press Enter" to face each ball.
The outcome of each ball is randomly generated:
Dot Ball: No runs.
Single: 1 run.
Double: 2 runs.
Triple: 3 runs.
Four: 4 runs.
Out: The player is out and the game ends.
Game End Conditions:

The game ends when the player is out or when all overs are completed (in this case, 5 overs).
Random Outcome:

The outcome of each ball is randomly generated using the Random class. Based on the random number, different actions occur (runs, four, or out).

Welcome to the Manual Cricket Game!
You are the batsman. Try to score as many runs as you can.

Over 1:
Ball 1:
Press Enter to face the ball... 
You hit a FOUR!
Ball 2:
Press Enter to face the ball... 
You scored 1 run.
Ball 3:
Press Enter to face the ball... 
Dot ball! No runs.
Ball 4:
Press Enter to face the ball... 
You scored 2 runs.
Ball 5:
Press Enter to face the ball... 
You are OUT!
You are out! Your total score is: 7 runs.

Game Features:
Simple user input: The user presses "Enter" to simulate facing a ball.
Random ball outcomes: The outcome of each ball is randomly chosen, with possibilities of scoring 0 to 4 runs or getting out.
Multiple overs: The game consists of a set number of overs (5 overs in this case).
Game end: The game ends when the player is out or all overs are played.
Extensions & Improvements:
Multiple Players: You can add functionality to switch between players for a two-player game (batting and bowling).
Different Bowling Types: Add the option to bowl different types of deliveries (like fast, spin) which might have varying outcomes.
Scores and Leaderboards: Track high scores or create a competitive leaderboard for multiple rounds.
Graphics & UI: If you want a more visual experience, you could move this to a GUI-based framework like JavaFX or Swing.
