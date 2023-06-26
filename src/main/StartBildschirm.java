
package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartBildschirm extends Main {
    
    JPanel contentPane = new JPanel();
    JPanel panel = new JPanel();
    JFrame credits = new JFrame();
    JFrame settings = new JFrame();
    JComboBox<String> languageComboBox; // JComboBox für die Sprachauswahl
    JButton startBtn;
    JButton creditsBtn;
    JButton settinsBtn;

    public StartBildschirm() {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Hello World!");
            String[] languages = { "Deutsch", "English", "Français" };
            languageComboBox = new JComboBox<>(languages);

            startBtn = new JButton("Start");
            startBtn.setPreferredSize(new Dimension(90, 40));

            startBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Start!");
                    SpielFrame spielFrame = new SpielFrame();
                    frame.dispose();
                }
            });

            JButton creditsBtn = new JButton("Credits");
            creditsBtn.setPreferredSize(new Dimension(90, 40));
            creditsBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Credits!");
                    credits();
                }
            });

            JButton settingsBtn = new JButton("Settings");
            settingsBtn.setPreferredSize(new Dimension(90, 40));
            settingsBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Settings!");
                    settings();
                }
            });

            // Sprachauswahl ComboBox
            languageComboBox.setPreferredSize(new Dimension(150, 25));

            panel.setBackground(Color.ORANGE);
            panel.add(startBtn);
            panel.add(settingsBtn);
            panel.add(creditsBtn);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel);
            frame.setResizable(false);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        });
    }

    public void settings() {

        settings.setSize(400, 300);
        settings.add(languageComboBox);
        settings.setResizable(false); //
        settings.setLocationRelativeTo(null); // mittig platzieren
        settings.setTitle("Settings");
        settings.setVisible(true);
        String language = (String) languageComboBox.getSelectedItem();

        SpielPanel.setLanguage(language);
    }

    public void credits() {
        JLabel creditsLabel = new JLabel("<html>Ersteller: Marc Stölzel, Jason Hein, Leon Schobert<br><br>Leon: SpielFrame, StartBildschirm, SpielPanel,Blockmanager <br>Marc: SpielFrame, StartBildschirm, SpielPanel,Blockmanager <br>Jason: SpielFrame, StartBildschirm, SpielPanel,Blockmanager</html>");
        creditsLabel.setForeground(Color.BLACK);
        creditsLabel.setFont(null);

        
        contentPane.setBackground(Color.ORANGE);
        
        credits.setSize(400, 300);
        credits.setContentPane(contentPane);
        credits.setResizable(false);
        credits.setLocationRelativeTo(null);
        credits.setTitle("Credits");
        credits.getContentPane().add(creditsLabel);
        credits.setVisible(true);

    String language = (String) languageComboBox.getSelectedItem();
    }


}

