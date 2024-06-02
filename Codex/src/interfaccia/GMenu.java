package interfaccia;	//penso che ho spiegatto tutto bene pero se ce alcun dubbio basta chiamarmi 

import javax.swing.*;
import javax.swing.border.Border;

import campo.Giocatore;
import campo.Pedina;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
// 

/**
 * Menu iniziale per stabilire numero i credenziali dei giocatori
 * 
 * @author Gabriele Bregolin
 * @author Joao Pedro Moretti
 *
 */

public class GMenu {

	private static CountDownLatch latch;
	private static int nGiocatori;
	private static Giocatore giocatoreRestituito;
	private static Set<String> selectedColors = new HashSet<>();
    /**
     * Mostra su schermo una finestra di benvenuto per poter giocare
     */
	
    public static void finestraGioca() {
        
    	latch = new CountDownLatch(1);
    	
    	JFrame frame = new JFrame("Codex Naturalis"); // Crea il JFrame principale
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Definisce l'operazione di chiusura della finestra
        frame.setSize(780, 700); // Definisce la dimensione della finestra
        frame.setLocationRelativeTo(null); // Centralizza la finestra sullo schermo

        ImageIcon imageIcon = new ImageIcon("Immagini/Icon.png"); // Carica l'immagine del logo
        frame.setIconImage(imageIcon.getImage()); // Definisce l'icona della finestra

        ImageIcon backgroundImageIcon = new ImageIcon("Immagini/GiocoCodex.png"); // Carica l'immagine di sfondo

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
        JButton giocareButton = createRoundButton("Gioca");
        giocareButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 28)); // Definisce il font del bottone
        giocareButton.setForeground(Color.BLACK); // Definisce il colore del testo del bottone
        giocareButton.setBackground(new Color(255, 165, 0)); // Definisce il colore di sfondo del bottone
        giocareButton.setOpaque(false); // Definisce il bottone come opaco
        giocareButton.setBorderPainted(false); // Rimuove il bordo del bottone
        giocareButton.setFocusPainted(false); // Rimuove l'effetto di focus del bottone
        giocareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                latch.countDown(); //Imposto a 0 il countdownlatch terminando il metodo succesivamente
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
    
        try {
			latch.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        
        frame.dispose();
        
    }

    
    /**
     * Fa selezionare su schermo il numero di giocatori e lo restituisce in intero
     * @return numero di giocatori scelti
     */
    
    public static int slezionaNumGiocatori() {
    	
    	latch = new CountDownLatch(1);
    	
        JFrame playerFrame = new JFrame("Seleziona il numero di giocatori"); // Crea il JFrame per selezione dei giocatori
        playerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce l'operazione di chiusura della finestra
        playerFrame.setSize(400, 300); // Definisce la dimensione della finestra
        playerFrame.setLocationRelativeTo(null); // Centralizza la finestra sullo schermo

        ImageIcon imageIcon = new ImageIcon("Immagini/Icon.png"); // Carica l'immagine del logo
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
                nGiocatori = 2;
                latch.countDown();
                playerFrame.dispose(); // Chiude la finestra di selezione dei giocatori
            }
        });
        
        panel.add(twoPlayersButton); // Aggiunge il bottone al pannello

        // Crea il bottone per selezionare 3 giocatori
        JButton threePlayersButton = createRoundButton("3 Giocatori");
        threePlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	nGiocatori = 3;
                latch.countDown();
                playerFrame.dispose(); // Chiude la finestra di selezione dei giocatori
           }
        });
        
        panel.add(threePlayersButton); // Aggiunge il bottone al pannello

        // Crea il bottone per selezionare 4 giocatori
        JButton fourPlayersButton = createRoundButton("4 Giocatori");
        fourPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	nGiocatori = 4;
                latch.countDown();
                playerFrame.dispose(); // Chiude la finestra di selezione dei giocatori
            }
        });
        panel.add(fourPlayersButton); // Aggiunge il bottone al pannello
        playerFrame.setVisible(true); // Rende visibile la finestra
        
        try {
			latch.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        
        return nGiocatori;
        
    }

    /**
     * Crea un giocatore basandosi sulle infomrazini raccolte a schermo (nome e pedina)
     * @param pedine (lista di pedine disponibili)
     */
    public static Giocatore creaGiocatoriConDettagli(Set<Pedina> pedine) {
    	
    	latch = new CountDownLatch(1);
    	
        JFrame detailFrame = new JFrame("Inserisci i dettagli dei giocatori"); // Crea il JFrame per inserimento dei dettagli dei giocatori
        detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Definisce l'operazione di chiusura della finestra
        detailFrame.setSize(400, 300); // Definisce la dimensione della finestra
        detailFrame.setLocationRelativeTo(null); // Centralizza la finestra sullo schermo
        detailFrame.setVisible(true); // Rende visibile la finestra
        
        ImageIcon imageIcon = new ImageIcon("Immagini/Icon.png"); // Carica l'immagine del logo
        detailFrame.setIconImage(imageIcon.getImage()); // Definisce l'icona della finestra


        // Crea un pannello con layout a griglia
        JPanel panel = new JPanel(new GridLayout(4, 1, 0, 20));
        panel.setBackground(new Color(255, 255, 240)); // Definisce il colore di sfondo del pannello
        Border border = BorderFactory.createLineBorder(Color.ORANGE, 3); // Crea un bordo arancione
        panel.setBorder(border); // Definisce il bordo del pannello
        detailFrame.add(panel); // Aggiunge il pannello alla finestra

        JLabel playerLabel = new JLabel("inserisci il tuo nome, seleziona la pedina:");
        playerLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        
        JTextField nameField = new JTextField(); // Campo di testo per il nome del giocatore
        nameField.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        
        
        //String sPedine[] = (String[]) pedine.toArray();
        
        String[] sPedine = new String[pedine.size()];
        
        int i=0;
        for(Pedina p: pedine) {
        	sPedine[i] = String.valueOf(p);
        	i++;
        }
        
        JComboBox<String> colorComboBox = new JComboBox<>(sPedine); // Combo box per selezione del colore
        colorComboBox.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
        JButton nextButton = createRoundButton("Prossimo"); // Bottone per avanzare al giocatore successivo
        nextButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
        
        
        panel.add(playerLabel);
        panel.add(nameField);
        panel.add(colorComboBox);
        panel.add(nextButton);
        
        detailFrame.setVisible(true);
        
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

                selectedColors.add(playerColor);
                
                pedine.remove(Pedina.valueOf(playerColor));
                
                giocatoreRestituito = new Giocatore(playerName, Pedina.valueOf(playerColor));
                
                latch.countDown();
                
            }
        });
        
        try {
			latch.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        
        detailFrame.dispose();
        return giocatoreRestituito;
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
        button.setFont(new Font("Segoe UI Black", Font.PLAIN, 14)); // Definisce il font del bottone
        return button; // Ritorna il bottone creato
    }
}
