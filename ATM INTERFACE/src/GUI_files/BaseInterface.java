package GUI_files;

import javax.swing.JFrame;

import java.awt.Color;

public class BaseInterface extends JFrame {

    public static Color TEXT_COLOR = Color.decode("#FFC300");

    public BaseInterface() {
        // set the tite of the game
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
        final Color PRIMARY_COLOR = Color.decode("#170F5C");
        getContentPane().setBackground(PRIMARY_COLOR);

    }
}
