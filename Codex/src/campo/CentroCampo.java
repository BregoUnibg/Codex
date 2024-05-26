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
import requisiti.Requisito;

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
	private String carteRisorsa="ParametriCarte/CarteRisorsa.txt";
	private String carta="";
	
	private String carteOro="ParametriCarte/CarteOro.txt";
	private String cartaO="";
	
	private String carteObiettivo="ParametriCarte/CarteObiettivo.txt";
	private String cartaOb="";
	
	private String carteIniziali="ParametriCarte/CarteIniziali.txt";
	private String cartaI="";
	
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
	
	/**
	 * Crea un angolo in base alla stringa inserita nel costruttore
	 * Interpreta che costruttore usare in base al contenuto della stringa
	 * @param s
	 * @return
	 */
	private Angolo leggiAngolo(String s) {
		 
		 if(s.equals("true") || s.equals("false"))
			 return new Angolo(Boolean.valueOf(s));
		 if(s.equals(" "))
			 return new Angolo();
		 
		 return new Angolo(Figura.valueOf(s));
	 }
	
	private ReqFiguraSingola leggiRequisitoSingolo(String s1, Integer n1) {
		return new ReqFiguraSingola(Figura.valueOf(s1), n1);
	}
	
	private ReqFiguraDoppia leggiRequisitoDoppio(String s2, Integer n2, String s3, Integer n3) {
		return new ReqFiguraDoppia(Figura.valueOf(s2), n2, Figura.valueOf(s3), n3);
	}
	
	private ReqAngoliCoperti angoloCoperto() {

		 return new ReqAngoliCoperti(); 
	 }
	
	private ReqCarteObliqueCrescenti reqCarteOblique(String s4, Boolean s5) {
		return new ReqCarteObliqueCrescenti(Colore.valueOf(s4), Boolean.valueOf(s5)); 
	 }
	
	private ReqFiguraTripla leggiRequisitoTripla(String s8, Integer n8, String s9, Integer n9, String s10, Integer n10) {
		return new ReqFiguraTripla(Figura.valueOf(s8), n8, Figura.valueOf(s9), n9, Figura.valueOf(s10), n10);
	}
	
	
	private Requisito leggiRequisito(String s6) {

		switch(Integer.valueOf(s6)){
			
			case 1:
				 return new ReqLRossaVerde(); 
				
			case 2:
				 return new ReqLVerdeViola(); 
				
			case 3:
				 return new ReqLBluRossa(); 
				
			case 4:
				 return new ReqLViolaBlu(); 
				
			default: 
	   			System.out.println("Errore durante la lettura del file: ");
	   			break;
		}
		return null;
		
	 }
	
	private Figura controlloFigura(String s7) {
		return Figura.valueOf(s7);
	}
	 

	public void creaMazzoRisorsa() {
		
		//40 CARTE RISORSA 
		 try {
		       // Apre il file
		       BufferedReader reader = new BufferedReader(new FileReader(carteRisorsa));
		        
		       // Leggo ogni riga del file fino alla fine
		       while ((carta = reader.readLine()) != null) {
		           
		    	   String parametroCarta[] = carta.split(",");
		    	   
		    	   // Aggiunge ogni riga nell'ArrayList
		    	   mazzoCartaRisorsa.add(new CartaRisorsa(Colore.valueOf(parametroCarta[0]), Integer.valueOf(parametroCarta[1]), leggiAngolo(parametroCarta[2]), leggiAngolo(parametroCarta[3]), leggiAngolo(parametroCarta[4]), leggiAngolo(parametroCarta[5]), parametroCarta[6]));
		       }
		        
		       // Chiude il BufferedReader dopo aver finito di leggere i dati da file
		       reader.close();

		   } catch (IOException e) {
		       // Gestisce eventuali eccezioni di IO, ad esempio se il file non esiste o non può essere letto
		       System.err.println("Errore durante la lettura del file: ");
		   } 
		  
	}
	
	
	public void creaMazzoOro() {
		
		//40 CARTE ORO
		try {
		       // Apre il file
		       BufferedReader reader = new BufferedReader(new FileReader(carteOro));
		        
		       // Leggo ogni riga del file fino alla fine
		       while ((cartaO = reader.readLine()) != null) {
		           
		    	   String parametroCartaO[] = cartaO.split(",");
		    	   
		    	   switch(Integer.valueOf(parametroCartaO[0])) {
		    	   
		    	   		case 1:
		    	   			mazzoCartaOro.add(new CartaOro(Colore.valueOf(parametroCartaO[1]), Integer.valueOf(parametroCartaO[2]), leggiRequisitoDoppio(parametroCartaO[3], Integer.valueOf(parametroCartaO[4]), parametroCartaO[5], Integer.valueOf(parametroCartaO[6])), leggiRequisitoSingolo(parametroCartaO[7], Integer.valueOf(parametroCartaO[8])), leggiAngolo(parametroCartaO[9]), leggiAngolo(parametroCartaO[10]), leggiAngolo(parametroCartaO[11]), leggiAngolo(parametroCartaO[12]), parametroCartaO[13], parametroCartaO[14]));
		    	   			break;
		    	   			
		    	   		case 2:
		    	   			mazzoCartaOro.add(new CartaOro(Colore.valueOf(parametroCartaO[1]), Integer.valueOf(parametroCartaO[2]), leggiRequisitoDoppio(parametroCartaO[3], Integer.valueOf(parametroCartaO[4]), parametroCartaO[5], Integer.valueOf(parametroCartaO[6])), angoloCoperto(), leggiAngolo(parametroCartaO[7]), leggiAngolo(parametroCartaO[8]), leggiAngolo(parametroCartaO[9]), leggiAngolo(parametroCartaO[10]), parametroCartaO[11], parametroCartaO[12]));
		    	   			break;
		    	   			
		    	   		case 3:
		    	   			mazzoCartaOro.add(new CartaOro(Colore.valueOf(parametroCartaO[1]), Integer.valueOf(parametroCartaO[2]), leggiRequisitoSingolo(parametroCartaO[3], Integer.valueOf(parametroCartaO[4])), leggiAngolo(parametroCartaO[5]), leggiAngolo(parametroCartaO[6]), leggiAngolo(parametroCartaO[7]), leggiAngolo(parametroCartaO[8]), parametroCartaO[9], parametroCartaO[10]));
		    	   			break;
		    		
		    	   		default: 
		    	   			System.out.println("Errore durante la lettura del file: ");
		    	   			break;
		    	   }
		       }
		        
		       // Chiude il BufferedReader dopo aver finito di leggere i dati da file
		       reader.close();

		   } catch (IOException e) {
		       // Gestisce eventuali eccezioni di IO, ad esempio se il file non esiste o non può essere letto
		       System.err.println("Errore durante la lettura del file: ");
		   } 
		 
	}
	
	public void creaMazzoObiettivo() {
	
		try {
		       // Apre il file
		       BufferedReader reader = new BufferedReader(new FileReader(carteObiettivo));
		        
		       // Leggo ogni riga del file fino alla fine
		       while ((cartaOb = reader.readLine()) != null) {
		           
		    	   String parametroCartaOb[] = cartaOb.split(",");
		    	   
		    	   switch(Integer.valueOf(parametroCartaOb[0])) {
		    	   
	    	   		case 1:
	    	   			mazzoCartaObiettivo.add(new CartaObiettivo(Colore.valueOf(parametroCartaOb[1]), Integer.valueOf(parametroCartaOb[2]), reqCarteOblique(parametroCartaOb[3], Boolean.valueOf( parametroCartaOb[4])), parametroCartaOb[5], parametroCartaOb[6]));
	    	   			break;
	    	   			
	    	   		case 2:
	    	   			mazzoCartaObiettivo.add(new CartaObiettivo(Colore.valueOf(parametroCartaOb[1]), Integer.valueOf(parametroCartaOb[2]), leggiRequisito(parametroCartaOb[3]), parametroCartaOb[4], parametroCartaOb[5]));
	    	   			break;
	    	   			
	    	   		case 3:
	    	   			mazzoCartaObiettivo.add(new CartaObiettivo(Colore.valueOf(parametroCartaOb[1]), Integer.valueOf(parametroCartaOb[2]), leggiRequisitoSingolo(parametroCartaOb[3], Integer.valueOf(parametroCartaOb[4])), parametroCartaOb[5], parametroCartaOb[6]));
	    	   			break;
	    		
	    	   		case 4:
	    	   			mazzoCartaObiettivo.add(new CartaObiettivo(Colore.valueOf(parametroCartaOb[1]), Integer.valueOf(parametroCartaOb[2]), leggiRequisitoTripla(parametroCartaOb[3], Integer.valueOf(parametroCartaOb[4]), parametroCartaOb[5], Integer.valueOf(parametroCartaOb[6]), parametroCartaOb[7], Integer.valueOf(parametroCartaOb[8])), parametroCartaOb[9], parametroCartaOb[10]));
	    	   			break;
	    	   			
	    	   		default: 
	    	   			System.out.println("Errore durante la lettura del file: ");
	    	   			break;
	    	   }
		    	   }
		        
		       // Chiude il BufferedReader dopo aver finito di leggere i dati da file
		       reader.close();

		   } catch (IOException e) {
		       // Gestisce eventuali eccezioni di IO, ad esempio se il file non esiste o non può essere letto
		       System.err.println("Errore durante la lettura del file: ");
		   } 
	}
	
	public void creaMazzoIniziale() {
	
		try {
		       // Apre il file
		       BufferedReader reader = new BufferedReader(new FileReader(carteIniziali));
		        
		       // Leggo ogni riga del file fino alla fine
		       while ((cartaI = reader.readLine()) != null) {
		           
		    	   String parametroCartaI[] = cartaI.split(",");
		    	   
		    	   switch(Integer.valueOf(parametroCartaI[0])) {
		    	   
		    	   		case 1:
		    	   			mazzoCartaIniziale.add(new CartaIniziale(controlloFigura(parametroCartaI[1]), null, null, leggiAngolo(parametroCartaI[2]),  leggiAngolo(parametroCartaI[3]), leggiAngolo(parametroCartaI[4]), leggiAngolo(parametroCartaI[5]), leggiAngolo(parametroCartaI[6]), leggiAngolo(parametroCartaI[7]), leggiAngolo(parametroCartaI[8]), leggiAngolo(parametroCartaI[9]), parametroCartaI[10], parametroCartaI[11]));
		    	   			break;
		    	   			
		    	   		case 2:
		    	   			mazzoCartaIniziale.add(new CartaIniziale(controlloFigura(parametroCartaI[1]), controlloFigura(parametroCartaI[2]), null, leggiAngolo(parametroCartaI[3]),  leggiAngolo(parametroCartaI[4]), leggiAngolo(parametroCartaI[5]), leggiAngolo(parametroCartaI[6]), leggiAngolo(parametroCartaI[7]), leggiAngolo(parametroCartaI[8]), leggiAngolo(parametroCartaI[9]), leggiAngolo(parametroCartaI[10]), parametroCartaI[11], parametroCartaI[12]));
		    	   			break;
		    	   			
		    	   		case 3:
		    	   			mazzoCartaIniziale.add(new CartaIniziale(controlloFigura(parametroCartaI[1]), controlloFigura(parametroCartaI[2]), controlloFigura(parametroCartaI[3]), leggiAngolo(parametroCartaI[4]),  leggiAngolo(parametroCartaI[5]), leggiAngolo(parametroCartaI[6]), leggiAngolo(parametroCartaI[7]), leggiAngolo(parametroCartaI[8]), leggiAngolo(parametroCartaI[9]), leggiAngolo(parametroCartaI[10]), leggiAngolo(parametroCartaI[11]), parametroCartaI[12], parametroCartaI[13]));
		    	   			break;
		    		
		    	   		default: 
		    	   			System.out.println("Errore durante la lettura del file: ");
		    	   			break;
		    	   }
		    	   
		       }
		        
		       // Chiude il BufferedReader dopo aver finito di leggere i dati da file
		       reader.close();

		   } catch (IOException e) {
		       // Gestisce eventuali eccezioni di IO, ad esempio se il file non esiste o non può essere letto
		       System.err.println("Errore durante la lettura del file: ");
		   } 
		   
	}
	
}
