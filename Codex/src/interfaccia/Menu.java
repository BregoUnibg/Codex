package interfaccia;	//penso che ho spiegatto tutto bene pero se ce alcun dubbio basta chiamarmi 

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class Menu {
    public static void main(String[] args) {
        // Esegue il metodo per creare e mostrare la finestra principale
        SwingUtilities.invokeLater(Menu::createAndShowFullScreenFrame);
    }

    // Metodo per creare e mostrare la finestra principale a schermo intero
    private static void createAndShowFullScreenFrame() {
        JFrame frame = new JFrame("Codex Naturalis Game"); // Crea il JFrame principale
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce l'operazione di chiusura della finestra
        frame.setSize(780, 700); // Definisce la dimensione della finestra
        frame.setLocationRelativeTo(null); // Centralizza la finestra sullo schermo
        frame.setVisible(true); // Rende visibile la finestra

        ImageIcon imageIcon = new ImageIcon("Icon2.png"); // Carica l'immagine del logo
        frame.setIconImage(imageIcon.getImage()); // Definisce l'icona della finestra

        ImageIcon backgroundImageIcon = new ImageIcon("GiocoCodex.png"); // Carica l'immagine di sfondo

        // Crea un pannello di contenuto con un'immagine di sfondo
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImageIcon.getImage(), 0, 0, getWidth(), getHeight(), this); // Disegna l'immagine di sfondo
                Color color = new Color(0, 0, 0, 135); // Colore con trasparenza
                g.setColor(color);
                g.fillRect(0, 0, getWidth(), getHeight()); // Riempe il pannello con il colore trasparente
            }
        };
        contentPane.setLayout(new GridBagLayout()); // Definisce il layout del pannello

        // Crea il bottone "Giocare" arrotondato
        JButton giocareButton = createRoundButton("Giocare");
        giocareButton.setFont(new Font("Serif", Font.BOLD, 28)); // Definisce il font del bottone
        giocareButton.setForeground(Color.BLACK); // Definisce il colore del testo del bottone
        giocareButton.setBackground(new Color(255, 165, 0)); // Definisce il colore di sfondo del bottone
        giocareButton.setOpaque(false); // Definisce il bottone come opaco
        giocareButton.setBorderPainted(false); // Rimuove il bordo del bottone
        giocareButton.setFocusPainted(false); // Rimuove l'effetto di focus del bottone
        giocareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPlayerSelectionFrame(); // Chiama il metodo per creare la schermata di selezione dei giocatori
            }
        });

        // Definisce le restrizioni del layout e aggiunge il bottone al pannello
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 100, 0); // Definisce il margine inferiore del bottone
        contentPane.add(giocareButton, gbc); // Aggiunge il bottone al pannello

        // Crea e definisce un bordo arancione per il pannello
        Border border = BorderFactory.createLineBorder(Color.ORANGE, 3);
        contentPane.setBorder(border);

        frame.setContentPane(contentPane); // Definisce il pannello come contenuto della finestra
        frame.setVisible(true); // Rende visibile la finestra
    }

    // Metodo per creare la finestra di selezione dei giocatori
    private static void createPlayerSelectionFrame() {
        JFrame playerFrame = new JFrame("Seleziona il numero di giocatori"); // Crea il JFrame per selezione dei giocatori
        playerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce l'operazione di chiusura della finestra
        playerFrame.setSize(400, 300); // Definisce la dimensione della finestra
        playerFrame.setLocationRelativeTo(null); // Centralizza la finestra sullo schermo
        playerFrame.setVisible(true); // Rende visibile la finestra

        ImageIcon imageIcon = new ImageIcon("Icon2.png"); // Carica l'immagine del logo
        playerFrame.setIconImage(imageIcon.getImage()); // Definisce l'icona della finestra

        // Crea un pannello con layout a griglia
        JPanel panel = new JPanel(new GridLayout(3, 1, 0, 20));
        panel.setBackground(new Color(255, 165, 0)); // Definisce il colore di sfondo del pannello
        Border border = BorderFactory.createLineBorder(Color.ORANGE, 3); // Crea un bordo arancione
        panel.setBorder(border); // Definisce il bordo del pannello
        playerFrame.add(panel); // Aggiunge il pannello alla finestra

        // Crea il bottone per selezionare 2 giocatori
        JButton twoPlayersButton = createRoundButton("2 Giocatori");
        twoPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerFrame.dispose(); // Chiude la finestra di selezione dei giocatori
                createPlayerDetailFrame(2); // Chiama il metodo per creare la schermata di selezione dei dettagli dei giocatori con 2 giocatori
            }
        });
        panel.add(twoPlayersButton); // Aggiunge il bottone al pannello

        // Crea il bottone per selezionare 3 giocatori
        JButton threePlayersButton = createRoundButton("3 Giocatori");
        threePlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerFrame.dispose(); // Chiude la finestra di selezione dei giocatori
                createPlayerDetailFrame(3); // Chiama il metodo per creare la schermata di selezione dei dettagli dei giocatori con 3 giocatori
            }
        });
        panel.add(threePlayersButton); // Aggiunge il bottone al pannello

        // Crea il bottone per selezionare 4 giocatori
        JButton fourPlayersButton = createRoundButton("4 Giocatori");
        fourPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerFrame.dispose(); // Chiude la finestra di selezione dei giocatori
                createPlayerDetailFrame(4); // Chiama il metodo per creare la schermata di selezione dei dettagli dei giocatori con 4 giocatori
            }
        });
        panel.add(fourPlayersButton); // Aggiunge il bottone al pannello
    }

    // Metodo per creare la finestra di inserimento dei dettagli dei giocatori (nome e colore)
    private static void createPlayerDetailFrame(int numPlayers) {
        JFrame detailFrame = new JFrame("Inserisci i dettagli dei giocatori"); // Crea il JFrame per inserimento dei dettagli dei giocatori
        detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce l'operazione di chiusura della finestra
        detailFrame.setSize(400, 300); // Definisce la dimensione della finestra
        detailFrame.setLocationRelativeTo(null); // Centralizza la finestra sullo schermo
        detailFrame.setVisible(true); // Rende visibile la finestra

        ImageIcon imageIcon = new ImageIcon("Icon2.png"); // Carica l'immagine del logo
        detailFrame.setIconImage(imageIcon.getImage()); // Definisce l'icona della finestra

        // Crea un pannello con layout a griglia
        JPanel panel = new JPanel(new GridLayout(4, 1, 0, 20));
        panel.setBackground(new Color(255, 255, 240)); // Definisce il colore di sfondo del pannello
        Border border = BorderFactory.createLineBorder(Color.ORANGE, 3); // Crea un bordo arancione
        panel.setBorder(border); // Definisce il bordo del pannello
        detailFrame.add(panel); // Aggiunge il pannello alla finestra

        JLabel playerLabel = new JLabel("Giocatore 1, inserisci il tuo nome:");
        JTextField nameField = new JTextField(); // Campo di testo per il nome del giocatore
        JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"VERDE", "ROSSO", "NERO", "GIALLO", "AZZURRO"}); // Combo box per selezione del colore
        JButton nextButton = createRoundButton("Prossimo"); // Bottone per avanzare al giocatore successivo

        panel.add(playerLabel);
        panel.add(nameField);
        panel.add(colorComboBox);
        panel.add(nextButton);

        // Variabili per memorizzare i dettagli dei giocatori
        String[] playerNames = new String[numPlayers];
        String[] playerColors = new String[numPlayers];
        Set<String> selectedColors = new HashSet<>();

        final int[] currentIndex = {0};

        // Azione del bottone "Prossimo"
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = nameField.getText();
                String playerColor = (String) colorComboBox.getSelectedItem();

                if (playerName.isEmpty()) {
                    JOptionPane.showMessageDialog(detailFrame, "Per favore, inserisci un nome.");
                    return;
                }

                if (playerColor == null) {
                    JOptionPane.showMessageDialog(detailFrame, "Per favore, seleziona un colore.");
                    return;
                }

                if (selectedColors.contains(playerColor)) {
                    JOptionPane.showMessageDialog(detailFrame, "Colore già selezionato! Scegli un altro colore.");
                    return;
                }

                playerNames[currentIndex[0]] = playerName;
                playerColors[currentIndex[0]] = playerColor;
                selectedColors.add(playerColor);

                currentIndex[0]++;

                if (currentIndex[0] < numPlayers) {
                    // Aggiorna l'indice e i campi per il prossimo giocatore
                    nameField.setText("");
                    colorComboBox.setSelectedIndex(-1);
                    playerLabel.setText("Giocatore " + (currentIndex[0] + 1) + ", inserisci il tuo nome:");
                } else {
                    // Tutti i giocatori hanno inserito i dettagli, chiude la finestra
                    detailFrame.dispose();
                    // Da qui, si può procedere con il prossimo passo del gioco, utilizzando playerNames e playerColors
                    // ad esempio, createGameBoard(playerNames, playerColors);
                }
            }
        });
    }

    // Metodo per creare bottoni arrotondati
    private static JButton createRoundButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                if (getModel().isArmed()) {
                    g.setColor(new Color(255, 165, 0).darker()); // Definisce il colore del bottone quando premuto
                } else {
                    g.setColor(getBackground()); // Definisce il colore del bottone normalmente
                }
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Disegna un rettangolo arrotondato
                super.paintComponent(g); // Chiama il metodo di pittura standard
            }

            @Override
            public void setBackground(Color bg) {
                super.setBackground(bg);
                setContentAreaFilled(false); // Definisce che l'area di contenuto non sarà riempita
            }
        };
        button.setOpaque(false); // Definisce il bottone come non opaco
        button.setBorderPainted(false); // Rimuove la pittura del bordo
        button.setFocusPainted(false); // Rimuove la pittura del focus
        button.setFont(new Font("Serif", Font.BOLD, 16)); // Definisce il font del bottone
        return button; // Ritorna il bottone creato
    }
}
