package GUI;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Backend.Calculations;

public class StartingPage extends BaseFrame{
    public StartingPage(){
        addGuiComponents();
    }

    private void addGuiComponents() {
        // CREATE A GAME LABLE
        JLabel gameLable = new JLabel("Number Game"); 
        gameLable.setBounds(175, 10, 280, 50);
        gameLable.setForeground(TEXT_COLOR);
        gameLable.setFont(new Font("Tahoma", Font.BOLD, 25));
        gameLable.setHorizontalAlignment(SwingConstants.CENTER);

        // CREATE A INTRO LABLE
        JLabel introLabel = new JLabel("<html><b>Welcome to the Number Game!</b><br>" +
                "<b>Instructions:</b><br>" +
                "✿ <b>Guessing Range:</b> Guess a number between 1 and 100.<br>" +
                "✿ <b>Difficulty Levels:</b> Choose from Easy, Medium, or Hard difficulty.<br>" +
                "✿ <b>Round Limits:</b> Each difficulty level consists of a maximum of 3 rounds, totaling 450 points.<br>" +
                "✿ <b>Round Display:</b> Stay informed about the current round during gameplay.<br>" +
                "✿ <b>Limited Attempts:</b> Easy (10 attempts), Medium (6 attempts), Hard (3 attempts) per round.<br>" +
                "✿ <b>Points System:</b> Earn points for each move: Easy (15 points/move), Medium (25 points/move), Hard (50 points/move).<br>" +
                "✿ <b>Scoring Rounds:</b> Accumulate points across rounds to reach a maximum score.<br>" +
                "✿ <b>Accuracy:</b> Make precise guesses to maximize your score.<br>" +
                "✿ <b>User Score:</b> Your total score will be displayed out of 450 points. Aim for a perfect score!</html>");
        introLabel.setBounds(40, 0, 520, 350);
        introLabel.setForeground(TEXT_COLOR);
        introLabel.setFont(new Font("Arial Bold", Font.PLAIN, 13));
        introLabel.setHorizontalAlignment(SwingConstants.LEFT);

        // CREATE A USER NAME LABEL 
        JLabel usernameLabel = new JLabel("Enter your username:");
        usernameLabel.setBounds(50, 300, 180, 25);
        usernameLabel.setForeground(TEXT_COLOR);
        usernameLabel.setFont(new Font("Arial Bold",Font.BOLD,17));

        //CRAETE A USER NAME TEXT FIELD 
        JTextField userenameTextField = new JTextField();
        userenameTextField.setBounds(250, 300, 220, 25);
        userenameTextField.setForeground(TEXT_COLOR);
        userenameTextField.setFont(new Font("Arial",Font.PLAIN,15));

        //CREATE A PLAY BUTTON 
        JButton playButton = new JButton("Lets Play!");
        playButton.setBounds(240, 350, 150, 25);
        playButton.setFont(new Font("Tahoma",Font.BOLD,15));
        playButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        playButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //GET THE USERNAME
                String username = userenameTextField.getText();
                
                //CHECK IF THE USERNAME FIELD IS EMPTY OR NOT
                if(username.isBlank()){
                    // field is empty
                    JOptionPane.showMessageDialog(playButton, "This field is Empty!\nPlease enter your name.");
                }
                
                // Call a method to share the username
                Calculations.getUserName(username);
            }
        });
        
        //ADD FUNCTIONALITY TO SWITCH FROM STARTING PAGE FRAM TO GAMING VIEW FRAM
        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                //DISPOSE STARTING PAGE GUI
                StartingPage.this.dispose();
                //LAUNCH THE GAME VIEW GUI
                new GameView().setVisible(true);
            }
        });

        // ADD COMPONENTS
        add(gameLable);
        add(introLabel);
        add(usernameLabel);
        add(userenameTextField);
        add(playButton);

    }
}
