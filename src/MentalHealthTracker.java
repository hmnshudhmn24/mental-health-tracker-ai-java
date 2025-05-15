
package mentalhealthtracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MentalHealthTracker {
    private JFrame frame;
    private JTextArea journalArea;
    private JButton analyzeButton;
    private JLabel resultLabel;

    public MentalHealthTracker() {
        frame = new JFrame("🧠 Mental Health Tracker with AI");
        journalArea = new JTextArea(10, 40);
        analyzeButton = new JButton("Analyze Sentiment");
        resultLabel = new JLabel("🧾 Sentiment Result Will Appear Here");

        analyzeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = journalArea.getText();
                String sentiment = analyzeSentiment(input);
                resultLabel.setText("Sentiment: " + sentiment);
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(journalArea));
        panel.add(analyzeButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private String analyzeSentiment(String text) {
        text = text.toLowerCase();
        if (text.contains("happy") || text.contains("joy") || text.contains("great")) {
            return "😊 Positive";
        } else if (text.contains("sad") || text.contains("depressed") || text.contains("tired")) {
            return "😢 Negative";
        } else {
            return "😐 Neutral";
        }
    }

    public static void main(String[] args) {
        new MentalHealthTracker();
    }
}
