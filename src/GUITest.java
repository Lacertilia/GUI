import javax.swing.*;

public class GUITest {
    public static void createAndShowGUI(){
        JFrame frame = new JFrame("Fin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Mjoo");
        frame.getContentPane().add(label);



        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createAndShowGUI();
            }
        });
    }
}
