import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CalculatorGUI {
    private JPanel calc;
    private JTextField input2;
    private JTextField input1;
    private JButton calcButton;
    private JLabel answer;
    private JTextField neg1;
    private JTextField neg2;
    private JButton calculate2;
    private JLabel diff;
    private JTextField mul1;
    private JTextField mul2;
    private JButton prodBut;
    private JLabel prod;
    private JTextField talj;
    private JTextField namn;
    private JLabel kvot;
    private JButton calculateButton;

    public CalculatorGUI() {
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(input1.getText());
                double b = Double.parseDouble(input2.getText());
                double c = a+b;
                answer.setText(""+c);
            }
        });
        calculate2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(neg1.getText());
                double b = Double.parseDouble(neg2.getText());
                double c = a-b;
                diff.setText(""+c);
            }
        });
        prodBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(mul1.getText());
                double b = Double.parseDouble(mul2.getText());
                double c = a*b;
                prod.setText(""+(c));
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double a = Double.parseDouble(talj.getText());
                double b = Double.parseDouble(namn.getText());
                double c = a/b;
                kvot.setText(""+c);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new CalculatorGUI().calc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(new Dimension(500, 200));
        frame.setVisible(true);
    }
}
