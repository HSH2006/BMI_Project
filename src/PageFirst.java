import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageFirst extends JFrame {

    public PageFirst() {
        setTitle("BMI Project _ PageFirst");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("BMI", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.GREEN);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon icon = new ImageIcon(getClass().getResource("/health.png"));
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));

        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(Color.GREEN);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusPainted(false);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PageSecond().setVisible(true);
            }
        });

        imagePanel.add(imageLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(startButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(imagePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        new PageFirst().setVisible(true);
    }
}
