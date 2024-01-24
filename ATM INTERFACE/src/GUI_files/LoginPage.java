package GUI_files;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPage extends BaseInterface {

    public LoginPage() {
        addGuiComponents();
    }

    private void addGuiComponents() {

        // create a Jlable for welcome note
        JLabel titleLable = new JLabel("WELCOME TO ATM");
        titleLable.setBounds(180, 30, 290, 50);
        titleLable.setForeground(TEXT_COLOR);
        titleLable.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLable.setHorizontalAlignment(SwingConstants.CENTER);

        // create a Jlable for card no.
        JLabel cardNoLable = new JLabel("Enter the card no. :");
        cardNoLable.setBounds(110, 180, 200, 20);
        cardNoLable.setForeground(TEXT_COLOR);
        cardNoLable.setFont(new Font("Tahoma", Font.BOLD, 20));

        // create a JTextField to get card no.
        JTextField cardnoTextField = new JTextField();
        cardnoTextField.setBounds(330, 180, 200, 25);
        cardnoTextField.setFont(new Font("Arial", Font.PLAIN, 15));

        // create a Jlable for pin no.
        JLabel pinJLable = new JLabel("Enter the pin :");
        pinJLable.setBounds(110, 220, 190, 22);
        pinJLable.setForeground(TEXT_COLOR);
        pinJLable.setFont(new Font("Tahoma", Font.BOLD, 20));

        // create a JTextField to get the pin
        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(330, 220, 200, 25);
        pinTextField.setFont(new Font("Arial", Font.PLAIN, 15));

        // CREATE A Login BUTTON
        JButton loginButton = new JButton("LOG IN");
        loginButton.setBounds(350, 300, 150, 26);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // CREATE A registration BUTTON
        JButton registrationButton = new JButton("SIGN UP");
        registrationButton.setBounds(180, 300, 150, 26);
        registrationButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        registrationButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // CREATE A clear BUTTON
        JButton clearButton = new JButton("CLEAR");
        clearButton.setBounds(180, 350, 320, 26);
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add components
        add(titleLable);
        add(cardNoLable);
        add(cardnoTextField);
        add(pinJLable);
        add(pinTextField);
        add(loginButton);
        add(registrationButton);
        add(clearButton);

        // add action listener for Login button
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Ctext = cardnoTextField.getText();
                String Ptext = pinTextField.getText();

                // check fields are blank or not
            }
            
        });

        // add action listener for Sign up button
        registrationButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Ctext = cardnoTextField.getText();
                String Ptext = pinTextField.getText();
                
                // check fields are blank or not
            }
            
        });

        // add action listener for Clear button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Ctext = cardnoTextField.getText();
                String Ptext = pinTextField.getText();

                // check fields are blank or not
                if(Ctext.isBlank() && Ptext.isBlank()){
                    JOptionPane.showMessageDialog(clearButton, "Both fields are already empty!");
                } else {
                    cardnoTextField.setText("");
                    pinTextField.setText("");
                }
            }
        });

    }

}
