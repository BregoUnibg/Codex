package campo;

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
		
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO), new Angolo(false),  new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.CIOTOLA), new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(Figura.LUPO)));	
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA), new Angolo(Figura.PERGAMENA), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(), new Angolo(Figura.FUNGO), new Angolo(), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(Figura.FUNGO), new Angolo(false), new Angolo(), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.ROSSO, 1, new Angolo(false), new Angolo(), new Angolo(Figura.FUNGO), new Angolo()));		

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.PIUMA), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(false), new Angolo(Figura.CIOTOLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FOGLIA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VERDE, 1, new Angolo(false), new Angolo(Figura.FOGLIA), new Angolo(), new Angolo()));	

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.CIOTOLA), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(false), new Angolo(Figura.PERGAMENA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(false), new Angolo(), new Angolo(Figura.LUPO), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(false), new Angolo(), new Angolo(Figura.LUPO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.BLU, 1, new Angolo(), new Angolo(Figura.LUPO), new Angolo(), new Angolo(false)));	

		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(Figura.LUPO), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.PERGAMENA), new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(Figura.FUNGO)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, new Angolo(Figura.FARFALLA), new Angolo(Figura.FOGLIA), new Angolo(Figura.CIOTOLA), new Angolo(false)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(Figura.FARFALLA), new Angolo(false), new Angolo(), new Angolo()));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(), new Angolo(), new Angolo(false), new Angolo(Figura.FARFALLA)));
		 mazzoCartaRisorsa.add(new CartaRisorsa(Colore.VIOLA, 1, new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo()));	
				 
		
	}
	
	public void creaMazzoOro() {
		
		//40 CARTE ORO
		//ATTENZIONE BISOGNA METTERE TUTTI I PUNTI DELLE RELATIVE CARTE
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.LUPO,1), new ReqFiguraSingola(Figura.PIUMA, 1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PIUMA), "Piazzamento:\t 2 figure fungo e 1 figura lupo\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta"));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FOGLIA,1), new ReqFiguraSingola(Figura.CIOTOLA, 1), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), "Piazzamento:\t 2 figure fungo e 1 figura foglia\nObiettivo:\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FARFALLA,1), new ReqFiguraSingola(Figura.PERGAMENA, 1), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 2 figure fungo e 1 figura farfalla\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.LUPO,1), new ReqAngoliCoperti(), new Angolo(), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure fungo e 1 figura lupo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure fungo e 1 figura foglia\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure fungo e 1 figura farfalla\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), "Piazzamento:\t 3 figure fungo\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure fungo\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure fungo\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,5), new Angolo(), new Angolo(false), new Angolo(), new Angolo(false), "Piazzamento:\t 5 figure fungo\nObiettivo:\t 5 punti immediati "));		

		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FARFALLA,1), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 2 figure foglia e 1 figura farfalla\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FUNGO,1), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(), "Piazzamento:\t 2 figure foglia e 1 fungo\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(), "Piazzamento:\t 2 figure foglia e 1 figura lupo\nObiettivo:\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FARFALLA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure foglia e 1 figura farfalla\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure foglia e 1 figura lupo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure foglia e 1 figura fungo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(false), "Piazzamento:\t 3 figure foglia\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure foglia\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure foglia\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 5 figure foglia\nObiettivo:\t 5 punti immediati "));	

		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FARFALLA,1), new Angolo(Figura.CIOTOLA), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 2 figure lupo e 1 figura farfalla\nObiettivo:\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PERGAMENA), "Piazzamento:\t 2 figure lupo e 1 figura foglia\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(), "Piazzamento:\t 2 figure lupo e 1 figura fungo\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure lupo e 1 figura farfalla\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure lupo e 1 figura fungo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure lupo e 1 figura foglia\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), "Piazzamento:\t 3 figure lupo\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure lupo\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), "Piazzamento:\t 3 figure lupo\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,5), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 5 figure lupo\nObiettivo:\t 5 punti immediati "));

		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.PIUMA), new Angolo(false), new Angolo(), "Piazzamento:\t 2 figure farfalla e 1 figura foglia\nObiettivo:\t 1 punto per ogni figura piuma nel campo nel momento in cui viene piazzata la carta "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(), "Piazzamento:\t 2 figure farfalla e 1 figura lupo\nObiettivo:\t 1 punto per ogni figura pergamena nel campo nel momento in cui viene piazzata la carta  "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FUNGO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.CIOTOLA), "Piazzamento:\t 2 figure farfalla e 1 figura fungo\nObiettivo:\\t 1 punto per ogni figura ciotola nel campo nel momento in cui viene piazzata la carta  "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo(), "Piazzamento:\t 3 figure farfalla e 1 figura lupo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure farfalla e 1 figura foglia\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo(), "Piazzamento:\t 3 figure farfalla e 1 figura fungo\nObiettivo:\t 2 punti per ogni angolo che la carta occupato nel momento in cui viene piazzata "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), new Angolo(false), "Piazzamento:\t 3 figure farfalla\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(false), "Piazzamento:\t 3 figure farfalla\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(false), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(), "Piazzamento:\t 3 figure farfalla\nObiettivo:\t 3 punti immediati "));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), "Piazzamento:\t 5 figure farfalla\nObiettivo:\t 5 punti immediati "));
		
	}
	
	public void creaMazzoObiettivo() {
		
		//16 CARTE OBIETTIVO 
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCarteObliqueCrescenti(Colore.ROSSO, true), "2 punti se nel campo ci sono 3 carte rosse in diagonale (da sinistra a destra e dal basso verso l'alto), la carta centrale deve avere l'angolo in basso a sinistra e in alto a destra occupati dalle altre 2 carte rosse" ));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VERDE, 3), "2 punti se nel campo ci sono 3 carte verdi in diagonale (da sinistra a destra e dall'alto verso il basso), la carta centrale deve avere l'angolo in alto a sinistra e in basso a destra occupati dalle altre 2 carte verdi"));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.BLU, 3), "2 punti se nel campo ci sono 3 carte blu in diagonale (da sinistra a destra e dal basso verso l'alto), la carta centrale deve avere l'angolo in basso a sinistra e in alto a destra occupati dalle altre 2 carte blu "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VIOLA, 3), "2 punti se nel campo ci sono 3 carte viola in diagonale (da sinistra a destra e dall'alto verso il basso), la carta centrale deve avere l'angolo in basso a destra e in alto a sinistra occupati dalle altre 2 carte viola "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 2, Colore.VERDE, 1), "3 punti se nel campo ci sono 2 rosse e 1 verde. Le 2 carte rosse devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta verde deve occupare l'angolo in basso a destra della carta rossa più in basso "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.VERDE, 2, Colore.VIOLA, 1), "3 punti se nel campo ci sono 2 due verdi e 1 viola. Le 2 carte verdi devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta viola deve occupare l'angolo in basso a sinistra della carta verde più in basso "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 1, Colore.BLU, 2), "3 punti se nel campo ci sono 2 blu e 1 rossa. Le 2 carte blu devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta rossa deve occupare l'angolo in alto a destra della carta blu più in alto "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.BLU, 1, Colore.VIOLA, 2), "3 punti se nel campo ci sono 2 viola e 1 blu. Le 2 carte viola devono essere 'parallele' sul campo (una sopra l'altra senza angoli in comune) e la carta blu deve occupare l'angolo in alto a sinistra della carta viola più in alto "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FUNGO,3), "2 punti se nel campo ci sono 3 figura fungo "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FOGLIA,3), "2 punti se nel campo ci sono 3 figura foglia "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.LUPO,3), "2 punti se nel campo ci sono 3 figura lupo "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FARFALLA,3), "2 punti se nel campo ci sono 3 figura farfalla "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqFiguraTripla(Figura.CIOTOLA,1, Figura.PERGAMENA,1, Figura.PIUMA,1), "3 punti se nel campo c'è 1 figura piuma, 1 figura ciotola e 1 figura pergamena "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PERGAMENA,2), "2 punti se nel campo ci sono 2 figura pergamena "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.CIOTOLA,2), "2 punti se nel campo ci sono 2 figura ciotola "));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PIUMA,2), "2 punti se nel campo ci sono 2 figura piuma "));
		
	}
	
	public void creaMazzoIniziale() {
		
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FARFALLA, null, null, new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FUNGO, null, null, new Angolo(Figura.LUPO), new Angolo(), new Angolo(), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FARFALLA)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FOGLIA, Figura.FUNGO, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.LUPO, Figura.FARFALLA, null, new Angolo(), new Angolo(), new Angolo(), new Angolo(), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA), new Angolo(Figura.LUPO), new Angolo(Figura.FUNGO)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.LUPO, Figura.FARFALLA, Figura.FOGLIA, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FARFALLA), new Angolo(Figura.FUNGO), new Angolo(Figura.FOGLIA), new Angolo(Figura.LUPO)));
		mazzoCartaIniziale.add(new CartaIniziale(Figura.FOGLIA, Figura.LUPO, Figura.FUNGO, new Angolo(), new Angolo(), new Angolo(false), new Angolo(false), new Angolo(Figura.FUNGO), new Angolo(Figura.LUPO), new Angolo(Figura.FOGLIA), new Angolo(Figura.FARFALLA)));
		
	}
	
}
