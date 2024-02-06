package com.example;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static int playerWins = 0;
    private static int computerWins = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors!");

        String playerName = getPlayerName();

        playRPS(playerName);

        scanner.close();
    }

    private static String getPlayerName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    private static void playRPS(String playerName) {
        int gameCount = 0;

        while (true) {
            System.out.println("\n" + playerName + ", please enter:\n1 for Rock,\n2 for Paper, or\n3 for Scissors:");
            int playerChoice = getPlayerChoice();

            int computerChoice = random.nextInt(3) + 1;

            System.out.println("\n" + playerName + ", you chose " + getStringForChoice(playerChoice) + ".");
            System.out.println("Computer chose " + getStringForChoice(computerChoice) + ".\n");

            String gameResult = decideWinner(playerChoice, computerChoice);
            System.out.println(gameResult);

            gameCount++;
            System.out.println("\nGame count: " + gameCount);
            System.out.println(playerName + "'s wins: " + playerWins);
            System.out.println("Computer wins: " + computerWins);

            if (!playAgain(playerName)) {
                break;
            }
        }

        System.out.println("\nThank you for playing!");
    }

    private static int getPlayerChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 3) {
                    return choice;
                } else {
                    System.out.println("Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String getStringForChoice(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid choice";
        }
    }

    private static String decideWinner(int playerChoice, int computerChoice) {
        if ((playerChoice == 1 && computerChoice == 3) ||
            (playerChoice == 2 && computerChoice == 1) ||
            (playerChoice == 3 && computerChoice == 2)) {
            playerWins++;
            return "Congratulations, you win!";
        } else if (playerChoice == computerChoice) {
            return "It's a tie!";
        } else {
            computerWins++;
            return "Sorry, computer wins!";
        }
    }

    private static boolean playAgain(String playerName) {
        while (true) {
            System.out.print("\nPlay again, " + playerName + "? (Y/N): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("y")) {
                return true;
            } else if (input.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }
}
