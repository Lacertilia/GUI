import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Notepad {
    private JPanel rotPanel;
    private JTextArea textArea;
    private JButton saveButton;
    private JButton newButton;
    private JButton openButton;
    private JButton saveAsButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notepad");
        frame.setContentPane(new Notepad().rotPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);
    }

    public Notepad() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Path p = Paths.get("C:\\Users\\mara16\\IdeaProjects\\GUI\\pathDirFile.txt");
                File f = p.toFile();
                try {
                    Scanner scanner = new Scanner(f);
                    String filePath = scanner.nextLine();
                    String fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);


                    BufferedWriter writer = null;
                    try {

                        File logFile = new File(fileName);
                        System.out.println(logFile.getCanonicalPath());

                        writer = new BufferedWriter(new FileWriter(logFile));
                        writer.write(textArea.getText());
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            writer.close();
                        } catch (Exception e) {
                        }
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(null);

                if(returnVal == JFileChooser.APPROVE_OPTION){
                    try {
                        Scanner scan = new Scanner(fc.getSelectedFile());
                        while(scan.hasNext()){
                            textArea.setText(textArea.getText() + scan.nextLine() + "\n");
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                }else{
                    JOptionPane.showMessageDialog(null, "Du valde ingen fil.");
                }
            }
        });
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                textArea.setText("");
            }
        });
        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String fileName = JOptionPane.showInputDialog(null, "Vad ska filen heta?");

                BufferedWriter writer = null;
                try {

                    File logFile = new File(fileName + ".txt");
                    File f = new File("pathDirFile.txt");
                    writer = new BufferedWriter(new FileWriter(f));
                    writer.write("C:\\\\Users\\\\mara16\\\\IdeaProjects\\\\GUI\\\\" + fileName + ".txt");
                    writer.flush();
                    writer.close();
                    System.out.println(logFile.getCanonicalPath());

                    writer = new BufferedWriter(new FileWriter(logFile));
                    writer.write(textArea.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        writer.close();
                    } catch (Exception e) {
                    }
                }
            }
        });
        saveButton.setMnemonic(KeyEvent.VK_S);
    }
}