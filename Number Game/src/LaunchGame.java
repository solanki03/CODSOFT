import javax.swing.SwingUtilities;

import GUI.StartingPage;

public class LaunchGame {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new StartingPage().setVisible(true);
            }
        });
    }
}
