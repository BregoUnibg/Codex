package campo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import carte.Angolo;
import carte.Carta;
import carte.CartaIniziale;
import carte.CartaObiettivo;
import carte.CartaOro;
import carte.CartaRisorsa;
import carte.Colore;
import carte.Figura;
import requisiti.ReqAngoliCoperti;
import requisiti.ReqCartaDoppia;
import requisiti.ReqCartaSingola;
import requisiti.ReqCarteObliqueCrescenti;
import requisiti.ReqFiguraDoppia;
import requisiti.ReqFiguraSingola;
import requisiti.ReqFiguraTripla;
import requisiti.ReqLBluRossa;
import requisiti.ReqLRossaVerde;
import requisiti.ReqLVerdeViola;
import requisiti.ReqLViolaBlu;

public class CentroCampo {
	
	//Il centro campo contiene I mazzi e le 2 carte risorsa, oro e obiettivo scoperte
	
	
	//LA SEGUENTE E' UN'IMPLEMENTAZIONE ABBASTANZA INUTILE CHE HO COMMENTATO
	//Per come vengono gestite le interfacce sarebbe utile gestire le 4 carte risorsa e oro centrali sia 
	//Come collezione che come singoli attributi
	
	private Mazzo mazzoCartaOro; 
	private Mazzo mazzoCartaRisorsa; 
	private Mazzo mazzoCartaObiettivo; 
	private Mazzo mazzoCartaIniziale; 
	
	private Carta cartaOro1;
	private Carta cartaOro2;
	
	private Carta cartaRisorsa1;
	private Carta cartaRisorsa2;
	
	private Carta cartaObiettivo1;
	private Carta cartaObiettivo2;
	
	//Attributi per inserimento da file 
	private String carteRisorsa="CarteRisorsa.txt";
	private String carta;
	
	//private ArrayList <Carta> carteSelezionabili;
	
	public CentroCampo() {
		
		mazzoCartaOro = new Mazzo();
		mazzoCartaRisorsa = new Mazzo();
		mazzoCartaObiettivo = new Mazzo();
		mazzoCartaIniziale = new Mazzo();
	
		preparaCentroCampo();
		
		cartaOro1 = mazzoCartaOro.pesca();
		cartaOro2 = mazzoCartaOro.pesca();
		
		cartaRisorsa1 = mazzoCartaRisorsa.pesca();
		cartaRisorsa2 = mazzoCartaRisorsa.pesca();
		
		cartaObiettivo1 = mazzoCartaObiettivo.pesca();
		cartaObiettivo2 = mazzoCartaObiettivo.pesca();
		
		/*
		
		carteSelezionabili = new ArrayList <Carta>();
		carteSelezionabili.add(cartaOro1);
		carteSelezionabili.add(cartaOro2);
		carteSelezionabili.add(cartaRisorsa1);
		carteSelezionabili.add(cartaRisorsa2);
		
		*/
	}
	
	/**
	 * Prende la carta di un certo id dal centrocampo
	 * @param id
	 * @return
	 */
	
	/*
	public Carta prendiCartaid(int id) {
		
		
		if(id == cartaOro1.getId()) {
		
			return prendiCartaOro1();
		
		}else if(id == cartaOro2.getId()) {
			
			return prendiCartaOro2();
		
		}else if(id == cartaRisorsa1.getId()) {
			
			return prendiCartaRisorsa1();
		}
		else if(id == cartaRisorsa2.getId()){
			return prendiCartaRisorsa2();
		}
		else
			return null;
		
		
	}
	
	*/
	
	public Carta prendiCartaOro1() {
		
		Carta cartapresa = cartaOro1;
		//carteSelezionabili.remove(cartapresa);
		cartaOro1 = mazzoCartaOro.pesca();
		//carteSelezionabili.add(cartaOro1);
		return cartapresa;
		
	}
	
	public Carta prendiCartaOro2() {
		
		Carta cartapresa = cartaOro2;
		//carteSelezionabili.remove(cartapresa);
		cartaOro2 = mazzoCartaOro.pesca();
		//carteSelezionabili.add(cartaOro2);
		return cartapresa;
		
	}
	
	
	public Carta prendiCartaRisorsa1() {
		
		Carta cartapresa = cartaRisorsa1;
		//carteSelezionabili.remove(cartapresa);
		cartaRisorsa1 = mazzoCartaRisorsa.pesca();
		//carteSelezionabili.add(cartaRisorsa1);
		return cartapresa;
		
	}
	
	public Carta prendiCartaRisorsa2() {
		
		Carta cartapresa = cartaRisorsa2;
		//carteSelezionabili.remove(cartapresa);
		cartaRisorsa2 = mazzoCartaRisorsa.pesca();
		//carteSelezionabili.add(cartaRisorsa2);
		return cartapresa;
		
	}
	
	public Carta pescaDalMazzoOro() {
		
		return mazzoCartaOro.pesca();
		
	}
	
	public Carta pescaDalMazzoRisorsa() {
		
		return mazzoCartaRisorsa.pesca();
		
	}
	
	public Carta pescaDalMazzoObiettivo() {
		
		return mazzoCartaObiettivo.pesca();
		
	}
	
	public Carta pescaDalMazzoIniziale() {
		
		return mazzoCartaIniziale.pesca();
		
	}
	
	public boolean mazziVuoti(){
		
		return (this.mazzoCartaOro.vuoto() && this.mazzoCartaRisorsa.vuoto());
		
	}
	
	//Getter carte nel campo
	
	public Carta getCartaOro1() {
		return cartaOro1;
	}
	
	
	
	public Carta getCartaOro2() {
		return cartaOro2;
	}
	
	
	
	public Carta getCartaRisorsa1() {
		return cartaRisorsa1;
	}
	
	
	
	public Carta getCartaRisorsa2() {
		return cartaRisorsa2;
	}
	
	
	
	public Carta getCartaObiettivo1() {
		return cartaObiettivo1;
	}
	
	
	
	public Carta getCartaObiettivo2() {
		return cartaObiettivo2;
	}
	
	
	
	
	
	//Istanziamento dei mazzi
	



	private void preparaCentroCampo() {
		
		creaMazzoRisorsa();
		creaMazzoOro();
		creaMazzoObiettivo();
		creaMazzoIniziale();
		
		//Per mescolare le carte
		
		mazzoCartaRisorsa.mischia();
		mazzoCartaOro.mischia();
		mazzoCartaObiettivo.mischia();
		mazzoCartaIniziale.mischia();
		
		
	}
	
	public void creaMazzoRisorsa() {
		
		//40 CARTE RISORSA 
		
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(false), "Immagini/Carte/xcarta001.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO), new Angolo(false),  new Angolo(), "Immagini/Carte/xcarta002.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO), "Immagini/Carte/xcarta003.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO), "Immagini/Carte/xcarta004.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA), new Angolo(Figura.FUNGO), "Immagini/Carte/xcarta005.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.CIOTOLA), new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta006.png"));	
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA), new Angolo(Figura.PERGAMENA), new Angolo(), "Immagini/Carte/xcarta007.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(false), "Immagini/Carte/xcarta008.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(), new Angolo(), "Immagini/Carte/xcarta009.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(false), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(), "Immagini/Carte/xcarta010.png"));		

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false), "Immagini/Carte/xcarta011.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo(), "Immagini/Carte/xcarta012.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA), "Immagini/Carte/xcarta013.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA), "Immagini/Carte/xcarta014.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA), "Immagini/Carte/xcarta015.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo(Figura.CIOTOLA), "Immagini/Carte/xcarta016.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta017.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false), "Immagini/Carte/xcarta018.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA), "Immagini/Carte/xcarta019.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(), "Immagini/Carte/xcarta020.png"));	

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false), "Immagini/Carte/xcarta021.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta022.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO), new Angolo(), "Immagini/Carte/xcarta023.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta024.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.CIOTOLA), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta025.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.PERGAMENA), "Immagini/Carte/xcarta026.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), "Immagini/Carte/xcarta027.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo(), "Immagini/Carte/xcarta028.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta029.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false), "Immagini/Carte/xcarta030.png"));	

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(false), "Immagini/Carte/xcarta031.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA), "Immagini/Carte/xcarta032.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(), "Immagini/Carte/xcarta033.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA), "Immagini/Carte/xcarta034.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.LUPO), new Angolo(Figura.FARFALLA), "Immagini/Carte/xcarta035.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.PERGAMENA), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FUNGO), "Immagini/Carte/xcarta036.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FOGLIA), new Angolo(Figura.CIOTOLA), new Angolo(false), "Immagini/Carte/xcarta037.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(), new Angolo(), "Immagini/Carte/xcarta038.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FARFALLA), "Immagini/Carte/xcarta039.png"));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(), "Immagini/Carte/xcarta040.png"));
		 
		 /*
		 try {
		       // Apre il file
		       BufferedReader reader = new BufferedReader(new FileReader(carteRisorsa));
		        
		       // Leggo ogni riga del file fino alla fine
		       while ((carta = reader.readLine()) != null) {
		           // Aggiunge ogni riga nell'ArrayList
		    	   mazzoCartaRisorsa.add(new CartaRisorsa(carta));
		       }
		        
		       // Chiude il BufferedReader dopo aver finito di leggere i dati da file
		       reader.close();

		   } catch (IOException e) {
		       // Gestisce eventuali eccezioni di IO, ad esempio se il file non esiste o non può essere letto
		       System.err.println("Errore durante la lettura del file: ");
		   } */
	}
	
	public void creaMazzoOro() {
		
		//40 CARTE ORO

		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.LUPO,1), new ReqFiguraSingola(Figura.PIUMA, 1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PIUMA), "Piazzamento:\t 2 figure fungo e 1 figura lupo\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta", "Immagini/Carte/xcarta041.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FOGLIA,1), new ReqFiguraSingola(Figura.CIOTOLA, 1), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), "Piazzamento:\t 2 figure fungo e 1 figura foglia\nObiettivo:\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta042.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FARFALLA,1), new ReqFiguraSingola(Figura.PERGAMENA, 1), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 2 figure fungo e 1 figura farfalla\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta043.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 2, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.LUPO,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure fungo e 1 figura lupo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta044.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 2, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FOGLIA,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure fungo e 1 figura foglia\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta045.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 2, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FARFALLA,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure fungo e 1 figura farfalla\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta046.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 3, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), "Piazzamento:\t 3 figure fungo\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta047.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 3, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure fungo\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta048.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 3, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure fungo\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta049.png"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 5, new ReqFiguraSingola(Figura.FUNGO,5), new Angolo(), new Angolo(false), new Angolo(), new Angolo(false), "Piazzamento:\t 5 figure fungo\nObiettivo:\t 5 punti immediati ", "Immagini/Carte/xcarta050.png"));		

		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FARFALLA,1), new ReqFiguraSingola(Figura.PIUMA, 1), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 2 figure foglia e 1 figura farfalla\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta051.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FUNGO,1), new ReqFiguraSingola(Figura.PERGAMENA, 1), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(), "Piazzamento:\t 2 figure foglia e 1 fungo\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta052.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.LUPO,1), new ReqFiguraSingola(Figura.CIOTOLA, 1), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(), "Piazzamento:\t 2 figure foglia e 1 figura lupo\nObiettivo:\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta053.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 2, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FARFALLA,1), new ReqAngoliCoperti(), new Angolo(false), new Angolo(), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure foglia e 1 figura farfalla\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta054.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 2, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.LUPO,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure foglia e 1 figura lupo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta055.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 2, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FUNGO,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure foglia e 1 figura fungo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta056.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 3, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(false), "Piazzamento:\t 3 figure foglia\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta057.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 3, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure foglia\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta058.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 3, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure foglia\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta059.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 5, new ReqFiguraSingola(Figura.FOGLIA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 5 figure foglia\nObiettivo:\t 5 punti immediati ", "Immagini/Carte/xcarta060.png"));	

		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FARFALLA,1), new ReqFiguraSingola(Figura.CIOTOLA, 1), new Angolo(Figura.CIOTOLA), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 2 figure lupo e 1 figura farfalla\nObiettivo:\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta061.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FOGLIA,1), new ReqFiguraSingola(Figura.PERGAMENA, 1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PERGAMENA), "Piazzamento:\t 2 figure lupo e 1 figura foglia\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta062.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FUNGO,1), new ReqFiguraSingola(Figura.PIUMA, 1), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(), "Piazzamento:\t 2 figure lupo e 1 figura fungo\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta063.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 2, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FARFALLA,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure lupo e 1 figura farfalla\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta064.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 2, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FUNGO,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure lupo e 1 figura fungo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta065.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 2, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FOGLIA,1), new ReqAngoliCoperti(), new Angolo(false), new Angolo(), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure lupo e 1 figura foglia\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta066.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 3, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), "Piazzamento:\t 3 figure lupo\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta067.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 3, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure lupo\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta068.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 3, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), "Piazzamento:\t 3 figure lupo\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta069.png"));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 5, new ReqFiguraSingola(Figura.LUPO,5), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 5 figure lupo\nObiettivo:\t 5 punti immediati ", "Immagini/Carte/xcarta070.png"));

		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FOGLIA,1), new ReqFiguraSingola(Figura.PIUMA, 1), new Angolo(), new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(), "Piazzamento:\t 2 figure farfalla e 1 figura foglia\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta ", "Immagini/Carte/xcarta071.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.LUPO,1), new ReqFiguraSingola(Figura.PERGAMENA, 1), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(), "Piazzamento:\t 2 figure farfalla e 1 figura lupo\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta  ", "Immagini/Carte/xcarta072.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FUNGO,1), new ReqFiguraSingola(Figura.CIOTOLA, 1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.CIOTOLA), "Piazzamento:\t 2 figure farfalla e 1 figura fungo\nObiettivo:\\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta  ", "Immagini/Carte/xcarta073.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 2, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.LUPO,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure farfalla e 1 figura lupo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta074.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 2, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FOGLIA,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure farfalla e 1 figura foglia\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta075.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 2, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FUNGO,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure farfalla e 1 figura fungo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata ", "Immagini/Carte/xcarta076.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 3, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure farfalla\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta077.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 3, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure farfalla\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta078.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 3, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(false), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(), "Piazzamento:\t 3 figure farfalla\nObiettivo:\t 3 punti immediati ", "Immagini/Carte/xcarta079.png"));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 5, new ReqFiguraSingola(Figura.FARFALLA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 5 figure farfalla\nObiettivo:\t 5 punti immediati ", "Immagini/Carte/xcarta080.png"));
		
	}
	
	public void creaMazzoObiettivo() {
		
		//16 CARTE OBIETTIVO 
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCarteObliqueCrescenti(Colore.ROSSO, true), "2 punti se nel campo ci sono 3 carte rosse in diagonale (da sinistra a destra e dal basso verso l'alto), la carta centrale deve avere l'angolo in basso a sinistra e in alto a destra occupati dalle altre 2 carte rosse", "Immagini/Carte/xcarta087.png" ));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCarteObliqueCrescenti(Colore.VERDE, false), "2 punti se nel campo ci sono 3 carte verdi in diagonale (da sinistra a destra e dall'alto verso il basso), la carta centrale deve avere l'angolo in alto a sinistra e in basso a destra occupati dalle altre 2 carte verdi", "Immagini/Carte/xcarta088.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCarteObliqueCrescenti(Colore.BLU, true), "2 punti se nel campo ci sono 3 carte blu in diagonale (da sinistra a destra e dal basso verso l'alto), la carta centrale deve avere l'angolo in basso a sinistra e in alto a destra occupati dalle altre 2 carte blu ", "Immagini/Carte/xcarta089.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCarteObliqueCrescenti(Colore.VIOLA, false), "2 punti se nel campo ci sono 3 carte viola in diagonale (da sinistra a destra e dall'alto verso il basso), la carta centrale deve avere l'angolo in basso a destra e in alto a sinistra occupati dalle altre 2 carte viola ", "Immagini/Carte/xcarta090.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqLRossaVerde(), "3 punti se nel campo ci sono 2 rosse e 1 verde. Le 2 carte rosse devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta verde deve occupare l'angolo in basso a destra della carta rossa più in basso ", "Immagini/Carte/xcarta091.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqLVerdeViola(), "3 punti se nel campo ci sono 2 due verdi e 1 viola. Le 2 carte verdi devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta viola deve occupare l'angolo in basso a sinistra della carta verde più in basso ", "Immagini/Carte/xcarta092.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqLBluRossa(), "3 punti se nel campo ci sono 2 blu e 1 rossa. Le 2 carte blu devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta rossa deve occupare l'angolo in alto a destra della carta blu più in alto ", "Immagini/Carte/xcarta093.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqLViolaBlu(), "3 punti se nel campo ci sono 2 viola e 1 blu. Le 2 carte viola devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta blu deve occupare l'angolo in alto a sinistra della carta viola più in alto ", "Immagini/Carte/xcarta094.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FUNGO,3), "2 punti se nel campo ci sono 3 figura fungo ", "Immagini/Carte/xcarta095.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FOGLIA,3), "2 punti se nel campo ci sono 3 figura foglia ", "Immagini/Carte/xcarta096.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.LUPO,3), "2 punti se nel campo ci sono 3 figura lupo ", "Immagini/Carte/xcarta097.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FARFALLA,3), "2 punti se nel campo ci sono 3 figura farfalla ", "Immagini/Carte/xcarta098.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqFiguraTripla(Figura.CIOTOLA,1, Figura.PERGAMENA,1, Figura.PIUMA,1), "3 punti se nel campo c'è 1 figura piuma, 1 figura ciotola e 1 figura pergamena ", "Immagini/Carte/xcarta099.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PERGAMENA,2), "2 punti se nel campo ci sono 2 figura pergamena ", "Immagini/Carte/xcarta100.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.CIOTOLA,2), "2 punti se nel campo ci sono 2 figura ciotola ", "Immagini/Carte/xcarta101.png"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PIUMA,2), "2 punti se nel campo ci sono 2 figura piuma ", "Immagini/Carte/xcarta102.png"));
		
	}
	
	public void creaMazzoIniziale() {
		
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FARFALLA, null, null, new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta081.png", "Immagini/Carte/xcarta081retro.png"));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FUNGO, null, null, new Angolo(Figura.LUPO), new Angolo(), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA), "Immagini/Carte/xcarta082.png", "Immagini/Carte/xcarta082retro.png"));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FOGLIA, Figura.FUNGO, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), "Immagini/Carte/xcarta083.png", "Immagini/Carte/xcarta083retro.png"));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.LUPO, Figura.FARFALLA, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), "Immagini/Carte/xcarta084.png", "Immagini/Carte/xcarta084retro.png"));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.LUPO, Figura.FARFALLA, Figura.FOGLIA, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), "Immagini/Carte/xcarta085.png", "Immagini/Carte/xcarta085retro.png"));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FOGLIA, Figura.LUPO, Figura.FUNGO, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.LUPO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), "Immagini/Carte/xcarta086.png", "Immagini/Carte/xcarta086retro.png"));
		
	}
	
}
