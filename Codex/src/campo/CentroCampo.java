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
import requisiti.ReqCartaDoppia;
import requisiti.ReqCartaSingola;
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
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.LUPO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PIUMA)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,2,Figura.FARFALLA,1), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraDoppia(Figura.FUNGO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,3), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.ROSSO, 1, new ReqFiguraSingola(Figura.FUNGO,5), new Angolo(), new Angolo(false), new Angolo(), new Angolo(false)));		

		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FARFALLA,1), new Angolo(Figura.PIUMA), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.FUNGO,1), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FARFALLA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraDoppia(Figura.FOGLIA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(Figura.PERGAMENA), new Angolo(), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,3), new Angolo(false), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VERDE, 1, new ReqFiguraSingola(Figura.FOGLIA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false)));	

		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FARFALLA,1), new Angolo(Figura.CIOTOLA), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.PERGAMENA)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,2,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FARFALLA,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraDoppia(Figura.LUPO,3,Figura.FOGLIA,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,3), new Angolo(false), new Angolo(), new Angolo(false), new Angolo(Figura.PIUMA)));
		mazzoCartaOro.add(new CartaOro(Colore.BLU, 1, new ReqFiguraSingola(Figura.LUPO,5), new Angolo(false), new Angolo(), new Angolo(false), new Angolo()));

		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FOGLIA,1), new Angolo(), new Angolo(Figura.PIUMA), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.LUPO,1), new Angolo(), new Angolo(false), new Angolo(Figura.PERGAMENA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,2,Figura.FUNGO,1), new Angolo(false), new Angolo(), new Angolo(), new Angolo(Figura.CIOTOLA)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.LUPO,1), new Angolo(), new Angolo(), new Angolo(false), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FOGLIA,1), new Angolo(), new Angolo(), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraDoppia(Figura.FARFALLA,3,Figura.FUNGO,1), new Angolo(), new Angolo(false), new Angolo(), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(Figura.CIOTOLA), new Angolo(false), new Angolo(), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(), new Angolo(Figura.PERGAMENA), new Angolo(false), new Angolo(false)));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,3), new Angolo(false), new Angolo(false), new Angolo(Figura.PIUMA), new Angolo()));
		mazzoCartaOro.add(new CartaOro(Colore.VIOLA, 1, new ReqFiguraSingola(Figura.FARFALLA,5), new Angolo(), new Angolo(), new Angolo(false), new Angolo(false)));
		
	}
	
	public void creaMazzoObiettivo() {
		
		//16 CARTE OBIETTIVO 
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.ROSSO, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VERDE, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.BLU, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqCartaSingola(Colore.VIOLA, 3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 2, Colore.VERDE, 1)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.VERDE, 2, Colore.VIOLA, 1)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.ROSSO, 1, Colore.BLU, 2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqCartaDoppia(Colore.BLU, 1, Colore.VIOLA, 2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FUNGO,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FOGLIA,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.LUPO,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.FARFALLA,3)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 3, new ReqFiguraTripla(Figura.CIOTOLA,1, Figura.PERGAMENA,1, Figura.PIUMA,1)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PERGAMENA,2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.CIOTOLA,2)));
		mazzoCartaObiettivo.add(new CartaObiettivo(Colore.GRIGIO, 2, new ReqFiguraSingola(Figura.PIUMA,2)));
		
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
