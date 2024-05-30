package interfaccia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import campo.CampoGioco;
import campo.Pedina;

public class GBarraStatistiche extends JPanel{
	
	private JLabel nomeGiocatore;
	private JLabel descrizioneAzione;
	private JPanel contatori;
	private JLabel contaFungo;
	private JLabel contaFarfalla;
	private JLabel contaFoglia;
	private JLabel contaLupo;
	private JLabel contaPiuma;
	private JLabel contaCiotola;
	private JLabel contaPergamena;
	
	public GBarraStatistiche(String nomeGiocatore, Pedina pedinaGiocatore) {
		
		this.setPreferredSize(new Dimension(100,100));
		this.setBackground(new Color(221, 214, 173));
		this.setLayout(new BorderLayout());
		
		this.nomeGiocatore = new JLabel(nomeGiocatore);
		this.nomeGiocatore.setFont(new Font("Segoe UI Black", Font.BOLD, 24));
		this.nomeGiocatore.setBorder(new EmptyBorder(10, 20, 10, 20)); //Metto un po di bordo per non fare stare il nome attaccato alla parte sinistra della finestra
		this.nomeGiocatore.setPreferredSize(new Dimension(400,300));
		coloraGiocatore(pedinaGiocatore);
		
		this.descrizioneAzione = new JLabel();
		this.descrizioneAzione.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		this.descrizioneAzione.setBorder(new EmptyBorder(10, 20, 10, 20)); //Metto un po di bordo per non fare stare il nome attaccato alla parte sinistra della finestra
		this.descrizioneAzione.setPreferredSize(new Dimension(400,300));
		
		contatori = new JPanel(new FlowLayout(FlowLayout.CENTER));
		contatori.setBackground(this.getBackground());
		
		
		contaFungo = new JLabel(new ImageIcon("Immagini/Simboli/iconaFungo.png"));
		contaFoglia = new JLabel(new ImageIcon("Immagini/Simboli/iconaFoglia.png"));
		contaFarfalla = new JLabel(new ImageIcon("Immagini/Simboli/iconaFarfalla.png"));
		contaLupo = new JLabel(new ImageIcon("Immagini/Simboli/iconaLupo.png"));
		contaPiuma = new JLabel(new ImageIcon("Immagini/Simboli/iconaPiuma.png"));
		contaCiotola = new JLabel(new ImageIcon("Immagini/Simboli/iconaCiotola.png"));
		contaPergamena = new JLabel(new ImageIcon("Immagini/Simboli/iconaPergamena.png"));
		
		createContatore(contaFungo);
		createContatore(contaFoglia);
		createContatore(contaFarfalla);
		createContatore(contaLupo);
		createContatore(contaPiuma);
		createContatore(contaCiotola);
		createContatore(contaPergamena);
        
        this.add(contatori, BorderLayout.CENTER);
		this.add(this.nomeGiocatore, BorderLayout.WEST);
		this.add(this.descrizioneAzione, BorderLayout.EAST);
		
		
		
		this.setVisible(true);
	}
	
	public void aggiornaContatori(CampoGioco c){
		
		contaFungo.setText(String.valueOf(c.getContaFungo()));
		contaFarfalla.setText(String.valueOf(c.getContaFarfalla()));
		contaFoglia.setText(String.valueOf(c.getContaFoglia()));
		contaLupo.setText(String.valueOf(c.getContaLupo()));
		contaPiuma.setText(String.valueOf(c.getContaPiuma()));
		contaCiotola.setText(String.valueOf(c.getContaCiotola()));
		contaPergamena.setText(String.valueOf(c.getContaPergamena()));
		
	}
	
	private void createContatore(JLabel contatore){
		
		contatore.setText("0");
		contatore.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		contatore.setHorizontalTextPosition(SwingConstants.TRAILING);
        contatore.setVerticalTextPosition(SwingConstants.CENTER);
        contatore.setPreferredSize(new Dimension(70, 50));
        contatori.add(contatore);
		
	}
	
	/**
	 * Assegna al Giocatore il colore della pedina
	 */
	
	private void coloraGiocatore(Pedina p){
		
		switch(p) {
		
		case ROSSA:
			this.nomeGiocatore.setForeground(new Color(139, 0, 0));
			break;
		
		case AZZURRA:
			this.nomeGiocatore.setForeground(new Color(70, 130, 180));
			break;
			
		case VERDE:
			this.nomeGiocatore.setForeground(new Color(0, 100, 0));
			break;
		
		case GIALLA:
			this.nomeGiocatore.setForeground(new Color(204, 153, 0));
			break;
			
		default:
			break;
		}
		
	}
	
	public void azioneCartaIniziale(){
	
		descrizioneAzione.setText("Scegli quale faccia della carta iniziale giocare");
	
	}
	
	public void azioneCartaObiettivo(){
		
		descrizioneAzione.setText("Scegli una tra le due carte obiettivo");
	
	}
	
	public void azioneScegliCartaDaGiocare(){
		
		descrizioneAzione.setText("Gioca una carta dalla tua mano");
	
	}
	
	public void azionePosizionaCartaInCampo() {
		
		descrizioneAzione.setText("Posizione la carta nel campo da gioco");
		
	}
	
	public void azionePescaCarta(){
		
		descrizioneAzione.setText("Pesca una carta dal centro campo");
	
	}
	
	public void azioneGiocoTerminato(){
		
		descrizioneAzione.setText("Il vinvitore è stato estratto e il gioco è concluso");
	
	}
	

}
