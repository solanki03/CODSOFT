import javax.swing.SwingUtilities;

import GUI_files.LoginPage;
//import GUI_files.SignUpPg1;

public class AtmLauncher {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new LoginPage().setVisible(true);
                //new SignUpPg1().setVisible(true);
            }
        });
    }
}
