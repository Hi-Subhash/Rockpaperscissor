import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RockPaperScissorsGameWithGUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JLabel playerLabel;
    private JLabel computerLabel;
    private JLabel resultLabel;

    private String[] options = {"rock", "paper", "scissors"};
    private String playerChoice;
    private int computerChoice;

    public RockPaperScissorsGameWithGUI() {
        // Create the frame and panel
        frame = new JFrame("Rock Paper Scissors Game");
        panel = new JPanel(new GridLayout(4, 2));

        // Create the label and buttons
        label = new JLabel("Choose your move:");
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");
        playerLabel = new JLabel("Player's move:");
        computerLabel = new JLabel("Computer's move:");
        resultLabel = new JLabel("");

        // Add the label and buttons to the panel
        panel.add(label);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(rockButton);
        panel.add(paperButton);
        panel.add(scissorsButton);
        panel.add(new JLabel()); // Empty cell for spacing
        panel.add(playerLabel);
        panel.add(computerLabel);

        // Add action listeners to the buttons
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        // Set the frame properties and add the panel
        frame.add(panel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RockPaperScissorsGameWithGUI();
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rockButton) {
            playerChoice = "rock";
        } else if (e.getSource() == paperButton) {
            playerChoice = "paper";
        } else if (e.getSource() == scissorsButton) {
            playerChoice = "scissors";
        }

        // Generate the computer's choice
        Random random = new Random();
        computerChoice = random.nextInt(3);

        // Update the labels with the player's and computer's choices
        playerLabel.setText("Player's move: " + playerChoice);
        computerLabel.setText("Computer's move: " + options[computerChoice]);

        // Determine the winner and display the result
        String result = determineWinner(playerChoice, options[computerChoice]);
        resultLabel.setText(result);
    }

    // Determine the winner of the game
    public String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if (playerChoice.equals("rock") && computerChoice.equals("scissors") ||
                playerChoice.equals("paper") && computerChoice.equals("rock") ||
                playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            return "You win!";
        } else {
            return "The computer wins!";
        }
    }
}