import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageSecond extends JFrame {

    private JTextField heightField;
    private JTextField weightField;
    private JLabel resultLabel;

    public PageSecond() {
        setTitle("BMI Project _ PageSecond");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(240, 248, 255));

        JButton backButton = new JButton("← Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 12));
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PageFirst().setVisible(true);
            }
        });

        JLabel titleLabel = new JLabel("Calculate BMI", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLUE);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBackground(new Color(240, 248, 255));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextArea text = new JTextArea();
        text.setText("\n            Hesab kardan BMI shoma kamelan raigan:)\n");
        text.setFont(new Font("Arial", Font.PLAIN, 16));
        text.setForeground(Color.BLACK);
        text.setOpaque(false);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setAlignmentX(CENTER_ALIGNMENT);

        //titleLabel.add(text, BorderLayout.CENTER);

        JLabel height = new JLabel("Height (cm):");
        heightField = new JTextField();

        JLabel weight = new JLabel("Weight (kg):");
        weightField = new JTextField();

        JButton calcButton = new JButton("Calculate");
        calcButton.setBackground(Color.BLUE);
        calcButton.setForeground(Color.WHITE);

        JButton resetButton = new JButton("Reset");
        resetButton.setBackground(Color.RED);
        resetButton.setForeground(Color.WHITE);

        inputPanel.add(height);
        inputPanel.add(heightField);
        inputPanel.add(weight);
        inputPanel.add(weightField);
        inputPanel.add(calcButton);
        inputPanel.add(resetButton);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBackground(new Color(240, 248, 255));
        resultPanel.setBorder(BorderFactory.createTitledBorder("Natije: "));

        resultLabel = new JLabel("Enter and click Calculate", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateBMI();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        JPanel upPanel = new JPanel(new BorderLayout());
        upPanel.setBackground(new Color(240, 248, 255));
        upPanel.add(backButton, BorderLayout.WEST);
        upPanel.add(titleLabel, BorderLayout.CENTER);
        upPanel.add(text, BorderLayout.SOUTH);

        mainPanel.add(upPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void calculateBMI() {
        try {
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());
            double height2 = height / 100;
            double bmi = weight / (height2 * height2);
            String natije;
            if (bmi < 18.5)
                natije = "Underweight";
            else if (bmi < 25)
                natije = "Normal";
            else if (bmi < 30)
                natije = "Overweight";
            else
                natije = "Obese";
            resultLabel.setText(String.format("BMI: %.2f - %s", bmi, natije));
            resultLabel.setForeground(getColorForCategory(natije));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Add moshkel dare.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Color getColorForCategory(String natije) {
        switch (natije) {
            case "Underweight":
                return Color.ORANGE;
            case "Normal":
                return Color.GREEN;
            case "Overweight":
                return Color.YELLOW;
            case "Obese":
                return Color.RED;
            default:
                return Color.BLACK;
        }
    }

    private void resetFields() {
        heightField.setText("");
        weightField.setText("");
        resultLabel.setText("Enter and click Calculate");
        resultLabel.setForeground(Color.BLACK);
    }
}
