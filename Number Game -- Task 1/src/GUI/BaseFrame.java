package GUI;

import java.awt.Color;
import javax.swing.JFrame;

public class BaseFrame extends JFrame{
    public static Color TEXT_COLOR = Color.decode("#5E1D6C");

    public BaseFrame(){
        //set the title of the game
        super("Number Game");

        //set the size of the GUI
        setSize(650,450);

        //set layout null to place components in the page
        setLayout(null);
         
        //set GUI in the center of the screen
        setLocationRelativeTo(null);

        // prevent any resize of our GUI
        setResizable(false);

        // configure GUI to end the program's process once it has been closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the background color of GUI
        final Color PRIMARY_COLOR = Color.decode("#F2C9FB");
        getContentPane().setBackground(PRIMARY_COLOR);
    }
    
}
