import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGame extends JFrame {

    private int lowerBound = 1;
    private int upperBound = 50;
    private int randomNumber = (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
    private int attempts = 0;

    private JTextField guessField;
    private JLabel resultLabel;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel promptLabel = new JLabel("Enter your guess:");
        guessField = new JTextField();
        JButton submitButton = new JButton("Submit");
        resultLabel = new JLabel();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(promptLabel);
        inputPanel.add(guessField);
        inputPanel.add(new JLabel()); // Empty label for spacing
        inputPanel.add(submitButton);

        add(inputPanel, BorderLayout.CENTER);
        add(resultLabel, BorderLayout.SOUTH);
    }

    private void checkGuess() {
        String input = guessField.getText();

        try {
            int userGuess = Integer.parseInt(input);
            attempts++;

            if (userGuess < randomNumber) {
                resultLabel.setText("Too low! Try again.");
            } else if (userGuess > randomNumber) {
                resultLabel.setText("Too high! Try again.");
            } else {
                resultLabel.setText("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessField.setEditable(false);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input. Please enter a number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGuessingGame().setVisible(true);
            }
        });
    }
}
