package Backend;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GUI.GameView;

public class Calculations {

    // GET A RANDOM NUMBER
    static int randomNumber = generateRandomNumber();

    // CONTAINS THE USERNAME OF THE PLAYER
    public static String playerName;

    // DISPLAYS THE TOTAL SCORE AFTER COMPLETION OF ALL 3 ROUNDS
    public static int countTotal = 0;

    // GET THE USER NAME
    public static void getUserName(String username) {
        playerName = username;
    }

    private static int generateRandomNumber() {
        // generate random number
        return GameView.minNum + (int) (Math.random() * (GameView.maxNum - GameView.minNum + 1));
    }

    // USED TO APPLY GAME MODE CONDITIONS, AND COUNT ATTEMPTS LEFT
    public static int applyGameConditions(String selectGameMode, JLabel attemptsJLable) {
        switch (selectGameMode) {
            case "1":
                GameView.countAttempts = 10;
                attemptsJLable.setText("Attempts left: " + GameView.countAttempts);
                break;
            case "2":
                GameView.countAttempts = 6;
                attemptsJLable.setText("Attempts left: " + GameView.countAttempts);
                break;
            case "3":
                GameView.countAttempts = 3;
                attemptsJLable.setText("Attempts left: " + GameView.countAttempts);
                break;
        }
        return GameView.countAttempts;
    }

    // CHECKS WIN CONDITIONS AND DISPLAYS THE OUTPUT IN FEED BACK SECTION
    public static void checkForWin(JTextField guessTextField, Component guessButton, JLabel feedBackJLabel,
            int attemptsLeft, JLabel attemptsJLable, JLabel roundCountLabel, String selectGameMode,
            JLabel scoreBoardLable) {

        // GET THE GUESSED VALUE
        String userGuess = guessTextField.getText();
        int guess;
        int getTotalUserScore;

        // -------- CHECK FOR VALID INPUTS --------

        try {
            guess = Integer.parseInt(userGuess);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(guessButton, "Invalid input!\n" + "Please enter a valid guess.");
            return;
        }

        // ----------- WINNING CONDITIONS ------------

        if (guess < GameView.minNum || guess > GameView.maxNum) {
            // display out of range
            feedBackJLabel.setText(playerName + ", your guess is out of the valid range!");

        } else if (guess == randomNumber) {
            // return true. you guessed it right.
            feedBackJLabel.setText("Congratulations " + playerName + "! You guessed it right.");
            JOptionPane.showMessageDialog(guessButton, "Bravo! You win this round!");

        } else if (guess < randomNumber) {
            // your guess is too low. try again.
            feedBackJLabel.setText(playerName + ", your guess is too low. Try again.");

        } else {
            // your guess is too high. try again.
            feedBackJLabel.setText(playerName + ", your guess is too high. Try again.");
        }

        // UPDATE NO. OF LEFT ATTEMPTS
        GameView.attemptsLeft = GameView.attemptsLeft - 1;
        attemptsJLable.setText("Attempts left: " + GameView.attemptsLeft);

        if (GameView.attemptsLeft == 0 || guess == randomNumber) {

            // DISPLAY USER SCORE
            getTotalUserScore = calculateScore(GameView.countAttempts, GameView.attemptsLeft);
            scoreBoardLable.setText("Your Score in round " + GameView.roundCount + " = " + getTotalUserScore);

            countTotal = countTotal + getTotalUserScore;

            // If the user is out of attempts or win the game, increment the round count
            GameView.roundCount++;

            if (GameView.roundCount <= 3) {

                // RE-INITIALISE THE ATTEMPTS BASED ON THE CURRENT GAME MODE
                int reInit = applyGameConditions(selectGameMode, attemptsJLable);
                GameView.attemptsLeft = reInit;
                attemptsJLable.setText("Attempts left: " + GameView.attemptsLeft);

                // Update the round count label
                roundCountLabel.setText("Current Round: " + GameView.roundCount);

                if (guess != randomNumber) {

                    feedBackJLabel
                            .setText(playerName + ", you're out of attempts! The number was: " + randomNumber);
                }
                JOptionPane.showMessageDialog(guessButton, "Welcome to the new round!");

                // Generate a new random number for new round
                randomNumber = generateRandomNumber();

            } else {

                JOptionPane.showMessageDialog(guessButton, "Game Over!\nThank you for playing the game!");
                guessButton.setEnabled(false);
                feedBackJLabel.setText(
                        "<html>After 3 rounds, " + playerName + "'s total score is " + countTotal + " out of 450"
                                + "<br><b>GAME OVER!</b></html>");

            }

        }

        // CLEAR THE GUESS TEXT FIELD
        guessTextField.setText("");

    }

    private static int calculateScore(int countAttempts, int attemptsLeft) {
        int points = 0;

        switch (countAttempts) {
            case 3:
                points = 50;
                break;
            case 6:
                points = 25;
                break;
            case 10:
                points = 15;
                break;
        }

        return attemptsLeft * points;

    }

}
