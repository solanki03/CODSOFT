package GUI;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Backend.Calculations;

public class GameView extends BaseFrame {
    public static int maxNum = 100;
    public static int minNum = 1;
    public static int roundCount = 1;
    public static int countAttempts = 0; // it displays the no. of attempts
    public static int attemptsLeft = 0;
    private String easyMode = "1";
    private String mediumMode = "2";
    private String hardMode = "3";
    String selectGameMode;

    public GameView() {
        addGuiComponents();
    }

    private void addGuiComponents() {
        // CREATE GAME MODE LABLE
        JLabel gameMode = new JLabel(
                "<html><b>Select between gaming modes:</b><br>" + "Press: Easy = 1, Medium = 2, Hard = 3</html>");
        gameMode.setBounds(50, 10, 300, 50);
        gameMode.setForeground(TEXT_COLOR);
        gameMode.setFont(new Font("Arial Bold", Font.PLAIN, 15));

        // CREATE A GAME MODE TEXT FIELD
        JTextField gameModeTextField = new JTextField();
        gameModeTextField.setBounds(390, 20, 60, 30);
        gameModeTextField.setForeground(TEXT_COLOR);
        gameModeTextField.setFont(new Font("Arial", Font.PLAIN, 15));

        // CREATE A SUBMIT BUTTON
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(240, 70, 150, 25);
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        submitButton.setHorizontalAlignment(SwingConstants.CENTER);

        // CREATE A LABLE TO DISPLAY CURRENT ROUND
        JLabel roundCountLable = new JLabel("Current Round: " + roundCount);
        roundCountLable.setBounds(170, 100, 300, 50);
        roundCountLable.setForeground(TEXT_COLOR);
        roundCountLable.setFont(new Font("Tahoma", Font.BOLD, 15));
        roundCountLable.setHorizontalAlignment(SwingConstants.CENTER);

        // CREATE ASK FOR GUESS LABLE
        JLabel askGuessLable = new JLabel("Enter your guess (between " + minNum + " to " + maxNum + ") :");
        askGuessLable.setBounds(50, 135, 280, 50);
        askGuessLable.setForeground(TEXT_COLOR);
        askGuessLable.setFont(new Font("Arial Bold", Font.PLAIN, 15));

        // CREATE A GUESS TEXT FIELD
        JTextField guessTextField = new JTextField();
        guessTextField.setBounds(350, 145, 60, 30);
        guessTextField.setForeground(TEXT_COLOR);
        guessTextField.setFont(new Font("Arial", Font.PLAIN, 15));

        // CREATE A LABLE TO DISPLAY ATTEMPTS LEFT
        JLabel attemptsJLable = new JLabel();
        attemptsJLable.setBounds(265, 175, 300, 50);
        attemptsJLable.setForeground(TEXT_COLOR);
        attemptsJLable.setFont(new Font("Tahoma", Font.BOLD, 15));

        // CREATE A GUESS BUTTON
        JButton guessButton = new JButton("Guess");
        guessButton.setBounds(240, 230, 150, 25);
        guessButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        guessButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        guessButton.setHorizontalAlignment(SwingConstants.CENTER);

        // CREATE A SCORE BOARD LABLE
        JLabel scoreBoardLable = new JLabel();
        scoreBoardLable.setBounds(50, 260, 300, 50);
        scoreBoardLable.setForeground(TEXT_COLOR);
        scoreBoardLable.setFont(new Font("Tahoma", Font.PLAIN, 15));

        // CREATE A FEEDBACK DISPLAY LABLE
        JLabel feedbackJLable = new JLabel();
        feedbackJLable.setBounds(50, 290, 460, 70);
        feedbackJLable.setForeground(TEXT_COLOR);
        feedbackJLable.setFont(new Font("Tahoma", Font.PLAIN, 15));

        // DISABLE GUESS TEXT FIELD & GUESS BUTTON
        guessTextField.setEditable(false);
        guessButton.setEnabled(false);

        // ACTION LISTENER FOR SUBMIT BUTTON
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // GET THE GAME MODE CHOICE
                selectGameMode = gameModeTextField.getText();

                // CHECK FOR VALID INPUT
                if (selectGameMode.isBlank()) {

                    JOptionPane.showMessageDialog(submitButton,
                            "This field is Empty!\n" + "Please enter the gaming mode.");

                } else if (!selectGameMode.equals(easyMode) && !selectGameMode.equals(mediumMode)
                        && !selectGameMode.equals((hardMode))) {

                    JOptionPane.showMessageDialog(submitButton, "Please enter the relevant gaming mode.");

                } else {

                    // DISABLE THE GAME MODE TEXT FIELD & THE SUBMIT BUTTON
                    gameModeTextField.setEditable(false);
                    submitButton.setEnabled(false);

                    // ENABLE GUESS TEXT FIELD & GUESS BUTTON
                    guessTextField.setEditable(true);
                    guessButton.setEnabled(true);
                }

                // METHOD TO APPLY THE GAME CONDITIONS
                attemptsLeft = Calculations.applyGameConditions(selectGameMode, attemptsJLable);
            }

        });

        // ACTION LISTENER FOR GUESS BUTTON
        guessButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Calculations.checkForWin(guessTextField, guessButton, feedbackJLable, attemptsLeft, attemptsJLable,
                        roundCountLable, selectGameMode, scoreBoardLable);

            }

        });

        // ADD COMPONENTS
        add(gameMode);
        add(gameModeTextField);
        add(submitButton);
        add(roundCountLable);
        add(askGuessLable);
        add(guessTextField);
        add(attemptsJLable);
        add(guessButton);
        add(scoreBoardLable);
        add(feedbackJLable);

    }

}
