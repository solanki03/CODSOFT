package GUI_files;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Constants.CommonConstants;

public class LoginPage extends JFrame implements ActionListener{

    JLabel titleLable, cardNoLable, pinJLable;
    JTextField cardnoTextField;
    JPasswordField pinPWField;
    JButton loginButton, registrationButton, clearButton;

    public LoginPage() {
        // set the tite of the frame
        super("Automated Teller Machine");

        // set the size of the GUI
        setSize(700, 520);

        // set layout null to place components in the page
        setLayout(null);

        // set GUI in the center of the screen
        setLocationRelativeTo(null);

        // prevent any resize of our GUI
        setResizable(false);

        // configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the background color of GUI
        getContentPane().setBackground(CommonConstants.PRIMARY_COLOR);

        addGuiComponents();
    }

    private void addGuiComponents() {

        // add logo to the frame
        ImageIcon logo1 = new ImageIcon(ClassLoader.getSystemResource("Icons/bankLogo.png"));
        Image img = logo1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon imgIcon = new ImageIcon(img);
        JLabel imglabel = new JLabel(imgIcon);
        imglabel.setBounds(160, 20, 60, 60);

        // create a Jlable for welcome note
        titleLable = new JLabel("WELCOME TO ATM");
        titleLable.setBounds(230, 30, 290, 50);
        titleLable.setForeground(CommonConstants.TEXT_COLOR);
        titleLable.setFont(new Font("Tahoma", Font.BOLD, 30));
        titleLable.setHorizontalAlignment(SwingConstants.CENTER);

        // create a Jlable for card no.
        cardNoLable = new JLabel("Enter the card no. :");
        cardNoLable.setBounds(110, 180, 200, 20);
        cardNoLable.setForeground(CommonConstants.TEXT_COLOR);
        cardNoLable.setFont(new Font("Tahoma", Font.BOLD, 20));

        // create a JTextField to get card no.
        cardnoTextField = new JTextField();
        cardnoTextField.setBounds(330, 180, 200, 25);
        cardnoTextField.setFont(new Font("Arial", Font.BOLD, 15));

        // create a Jlable for pin no.
        pinJLable = new JLabel("Enter the pin :");
        pinJLable.setBounds(110, 220, 190, 22);
        pinJLable.setForeground(CommonConstants.TEXT_COLOR);
        pinJLable.setFont(new Font("Tahoma", Font.BOLD, 20));

        // create a JTextField to get the pin
        pinPWField = new JPasswordField();
        pinPWField.setBounds(330, 220, 200, 25);
        pinPWField.setFont(new Font("Arial", Font.PLAIN, 15));

        // CREATE A Login BUTTON
        loginButton = new JButton("LOG IN");
        loginButton.setBounds(350, 300, 150, 26);
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // CREATE A registration BUTTON
        registrationButton = new JButton("SIGN UP");
        registrationButton.setBounds(180, 300, 150, 26);
        registrationButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        registrationButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // CREATE A clear BUTTON
        clearButton = new JButton("CLEAR");
        clearButton.setBounds(180, 350, 320, 26);
        clearButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add components
        add(imglabel);
        add(titleLable);
        add(cardNoLable);
        add(cardnoTextField);
        add(pinJLable);
        add(pinPWField);
        add(loginButton);
        add(registrationButton);
        add(clearButton);

        // add ActionListener
        loginButton.addActionListener(this);
        registrationButton.addActionListener(this);
        clearButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            // clear both text fields
            cardnoTextField.setText("");
            pinPWField.setText("");
        } else if (e.getSource() == loginButton) {

        } else if (e.getSource() == registrationButton){
            setVisible(false);
            new SignUpPg1().setVisible(true);

        }
    }

}
