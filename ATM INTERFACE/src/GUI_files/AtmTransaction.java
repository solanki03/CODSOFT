package GUI_files;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AtmTransaction extends JFrame implements ActionListener{

    JButton depositButton, withdrawlButton, fastCashButton, miniStatementButton, changePINButton, balanceEnquiryButton,exitButton;
    String pinNo;

    public AtmTransaction(String pinNo){

        // set the size of the GUI
        setSize(900, 900);

        // set layout null to place components in the page
        setLayout(null);

        // set GUI in the center of the screen
        setLocationRelativeTo(null);

        // prevent any resize of our GUI
        setResizable(false);

        // configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // remove the upper panel from the GUI ---> use Exit button to close the window
        setUndecorated(true);

        this.pinNo = pinNo;
        addComponents();
    }

    private void addComponents() {
        
        // add atm image to the frame
        ImageIcon atmLogo = new ImageIcon(ClassLoader.getSystemResource("Icons/atm_image.png"));
        Image img = atmLogo.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgIcon);
        imglabel.setBounds(0, 0, 900, 900);
        add(imglabel);

        // create a label to display msg
        JLabel textLabel = new JLabel("Please Select Your Transaction");
        textLabel.setBounds(240, 200, 250, 30);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        imglabel.add(textLabel);

        // CREATE A DEPOSIT BUTTON
        depositButton = new JButton("DEPOSIT");
        depositButton.setBounds(190, 300, 130, 20);
        depositButton.setFont(new Font("Calibri", Font.BOLD, 12));
        depositButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(depositButton);
        depositButton.addActionListener(this);

        // CREATE A WITHDRAWL BUTTON
        withdrawlButton = new JButton("CASH WITHDRAWL");
        withdrawlButton.setBounds(375, 300, 130, 20);
        withdrawlButton.setFont(new Font("Calibri", Font.BOLD, 12));
        withdrawlButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(withdrawlButton);
        withdrawlButton.addActionListener(this);

        // CREATE A WITHDRAWL BUTTON
        fastCashButton = new JButton("FAST CASH");
        fastCashButton.setBounds(190, 335, 130, 20);
        fastCashButton.setFont(new Font("Calibri", Font.BOLD, 12));
        fastCashButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(fastCashButton);
        fastCashButton.addActionListener(this);

        // CREATE A MINI STATEMENT BUTTON
        miniStatementButton = new JButton("MINI STATEMENT");
        miniStatementButton.setBounds(375, 335, 130, 20);
        miniStatementButton.setFont(new Font("Calibri", Font.BOLD, 12));
        miniStatementButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(miniStatementButton);
        miniStatementButton.addActionListener(this);

        // CREATE A CHANGE PIN BUTTON
        changePINButton = new JButton("CHANGE PIN");
        changePINButton.setBounds(190, 370, 130, 20);
        changePINButton.setFont(new Font("Calibri", Font.BOLD, 12));
        changePINButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(changePINButton);
        changePINButton.addActionListener(this);

        // CREATE A BALANCE ENQUIRY BUTTON
        balanceEnquiryButton = new JButton("BALANCE ENQUIRY");
        balanceEnquiryButton.setBounds(375, 370, 130, 20);
        balanceEnquiryButton.setFont(new Font("Calibri", Font.BOLD, 12));
        balanceEnquiryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(balanceEnquiryButton);
        balanceEnquiryButton.addActionListener(this);

        // CREATE A EXIT PIN BUTTON
        exitButton = new JButton("EXIT");
        exitButton.setBounds(375, 408, 130, 20);
        exitButton.setFont(new Font("Calibri", Font.BOLD, 12));
        exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        imglabel.add(exitButton);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == exitButton){
            System.exit(0);
        }
    }

}
