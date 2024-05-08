package campo;

import java.util.ArrayList;

import carte.*;

public class CampoGioco {
	
	/*
	 * Necessità di utilizzare una matrice di profondità 2 e larghezza e amieppza grande al fine di tracciare non solo gli obiettivi ma le possibili sovrapposizioni tra carte
	 * 
	 * La matrice conterrà le carte, partendo dalle centrale che occuperà esattamente il centro di essa, questo servirà a capire i vincoli di piazzamento nel caso bidogni piazzare più di una carta alla volta.
	 * Essa servità anche per calcolare gli obiettivi relativi alla disosizioni delle carte su campo da gioco volendo.
	 *
	 * Per quanto riguarda Glli obiettivi riguardanti le figure, risulta più comodo gestire tramite dei vettori che vengono incrementati e decrementate ogni volta che viene piazzata una nuova carta,
	 * in modo tale da non onerare la cpu con troppe scansioni evitabili.
	 * 
	 */
	
	private final int dimCampo = 81;
	
	private Carta campo [][];
	private ArrayList <Carta> carteSulCampo;
	
	//Contatori Figura piazate
	private int contaFarfalla;
	private int contaFungo;
	private int contaLupo;
	private int contaFoglia;
	private int contaPergamena;
	private int contaPiuma;
	private int contaCiotola;
	
	/*
	//Contatori colore delle carte
	private int contaRosse;
	private int contaBlu;
	private int contaVerdi;
	private int contaViola;


	//private int ContaBianco; Non ci sono obiettivi riguardo queste carte
	//private int ContaGrigio;
	*/
	
	public CampoGioco() {
		
		campo = new Carta[dimCampo][dimCampo];
		carteSulCampo = new ArrayList <Carta>();
		
		contaFarfalla = 0;
		contaFungo = 0;
		contaLupo = 0;
		contaFoglia = 0;
		contaPergamena = 0;
		contaPiuma = 0;
		contaCiotola = 0;
		
		/*
		contaRosse = 0;
		contaBlu = 0;
		contaVerdi = 0;
		contaViola = 0;
		*/
		
		
	}
	
	/**
	 * Posiziona la carta iniziale al centro del campo da gioco
	 * @param c
	 */
	
	public void piazzaCartaIniziale(CartaIniziale c){
		
		int centro = (dimCampo-1)/2+1;
		
		campo[centro][centro] = c;
		
		for(Figura f: c.getFigure()){
			incrementaFigura(f);
		}
		
		incrementaFigura(c.getTop_right_angle().getFigura());
		incrementaFigura(c.getTop_left_angle().getFigura());
		incrementaFigura(c.getBottom_right_angle().getFigura());
		incrementaFigura(c.getBottom_left_angle().getFigura());
		
		carteSulCampo.add(c);
		
	}
	
	
	/**
	 * 
	 * Piazza una carta nella matrice: se il piazzamento è valido restituisce i punti generati dalla carta
	 * Se non è possibile piazzare la carte restituisce -1
	 * 
	 * @param cartaSotto
	 * @param angoloSotto
	 * @param cartaSopra
	 * @param angoloSopra
	 * @return
	 */
	
	//Dato che le che danno punti prima di raggiungere i 20, li danno in maniera immediata quando vengono piazzate
	
	//OBSOLETO
	//Sarebbe idale se la funzione restituisse direttamente i punti generati dalle carte
	//-1 se la carta non è paizzabile, 0 se viene piazzata e non restituisce punti, altrimenti i punti che restituisce
	
	//ESISTENDO L'OBIETTIVO CHE DA PUNTI PER OGNI ANGOLO DA CALCOLARE POST CARTA PIAZZATA NON E' POSSIBILE CALCOLARI 
	//I PUNTI DELLE CARTE ORO CON QUESTO METODO, ANCHE PERCHE' LE FIGURE SULLA CARTA NON VERREBBERO CONTEGGIATE
	//RITORNA BOOLEAN
	
	public boolean piazzaCarta(Carta cartaSotto, String angoloSotto, Carta cartaSopra) {
		
		//Passo le carte da collegare con la posizione del relativo angolo da collegare
		
		//tr: TopRight, tl: TopLeft, br, BottomRight, bl, BottomLeft
		
		//Gli angolo possono essere attaccati solo ad angoli opposti di un'altra carta, esempii: topRight->bottomLeft, topLeft->bottomRight
		
		
		//Prima di tutto controllo se si tratta di una carta Oro e in tal caso controllo che il requisito di paizzamento sia soddisfatto
		if(cartaSopra instanceof CartaOro) {
			if(((CartaOro) cartaSopra).getPiazzamento(this)==false)	//Faccio un cast sulla Carta che deve essere della sottoclasse CartaOro
				return false;
		}
		
		//Controllo quindi che siano angoli opposti
		
		
		//Dato che l'angolo di piazzamento della carta superiore viene calcolato dal metodo non è necessario passarlo e fare controlli inutili
		
		//if((angoloSotto.substring(0, 1)!=angoloSopra.substring(0,1)) && (angoloSotto.substring(1, 2)!=angoloSopra.substring(1,2))){
			
			Angolo sotto = getAngoloPosizione(cartaSotto, angoloSotto);
			//Angolo sopra = getAngoloPosizione(cartaSopra, angoloSopra);
			
			if(sotto.piazzabile()){
				
				String coordSotto = getCoordinate(cartaSotto);
				
				int x = Integer.parseInt(coordSotto.split(",",2)[0]);
				int y = Integer.parseInt(coordSotto.split(",",2)[1]);
				
				switch(angoloSotto){
					
					case "tl":
						campo[--x][++y] = cartaSopra;
						break;
						
					case "tr":
						campo[++x][++y] = cartaSopra;
						break;
						
					case "bl":
						campo[--x][--y] = cartaSopra;
						break;
						
					case "br":
						campo[++x][--y] = cartaSopra;
						break;
					
					default:
						return false; //Nel caso venga inserito un input non valido
						
				}
				
				
				
				//Copro i possibili angoli coivolti nelle vicinanze
				//In teoria, per come funziona il meccanismo di disposizione non dovreebbero esserci anomalie
				//Il nome delle 4 variabili seguenti (Tr, Br, ecc..) si riferiscono all'angolo rispetto alla carta da piazzare, in contenuto è l'angolo della carta coinvolta
				
				
				//Per ogni ipotetica carta devo controllare la sua esistenza efettiva, 
				//Utilizzo otto variabili booleane 
				//le quattro iniziali indicano solamente l'eistenza della carta nella posizione calcolata
				//successivamente le altre quattro andranno ad indicara la piazzabilità della carta nella determinata posizione
				
				Boolean esisteCartaCoinvoltaTr = (campo[x+1][y+1] != null);
				Boolean esisteCartaCoinvoltaBr = (campo[x+1][y-1] != null);
				Boolean esisteCartaCoinvoltaBl = (campo[x-1][y-1] != null);
				Boolean esisteCartaCoinvoltaTl = (campo[x-1][y+1] != null);
				
				//Controllo che posso effetivamente sovrapporre su eventuali angoli
				Boolean piazzabileCartaCoinvoltaTr = true;
				Boolean piazzabileCartaCoinvoltaBr = true;
				Boolean piazzabileCartaCoinvoltaBl = true;
				Boolean piazzabileCartaCoinvoltaTl = true;
				
				Angolo angoloCoinvoltoTr = null;
				Angolo angoloCoinvoltoBr = null;
				Angolo angoloCoinvoltoBl = null;
				Angolo angoloCoinvoltoTl = null;
				
				if(esisteCartaCoinvoltaTr) {
					angoloCoinvoltoTr = campo[x+1][y+1].getBottom_left_angle();
					if(!angoloCoinvoltoTr.piazzabile())
						piazzabileCartaCoinvoltaTr = false;
				}
				
				if(esisteCartaCoinvoltaBr) {
					angoloCoinvoltoBr = campo[x+1][y-1].getTop_left_angle();
					if(!angoloCoinvoltoBr.piazzabile())
						piazzabileCartaCoinvoltaBr = false;
				}
				
				if(esisteCartaCoinvoltaBl) {
					angoloCoinvoltoBl = campo[x-1][y-1].getTop_right_angle();
					if(!angoloCoinvoltoBl.piazzabile())
						piazzabileCartaCoinvoltaBl = false;
				}
				
				if(esisteCartaCoinvoltaTl) {
					angoloCoinvoltoTl = campo[x-1][y+1].getBottom_right_angle();
					if(!angoloCoinvoltoTl.piazzabile())
						piazzabileCartaCoinvoltaTl = false;
				}
				//Mi serve principallmente per sapere se ci sono angoli "assenti" piuttosto che coperti
				
				if(
						piazzabileCartaCoinvoltaTr &&
						piazzabileCartaCoinvoltaBr &&
						piazzabileCartaCoinvoltaBl &&
						piazzabileCartaCoinvoltaTl
						
						){
					
							if(esisteCartaCoinvoltaTr){
								angoloCoinvoltoTr.piazzaAngolo(cartaSopra.getTop_right_angle());
								decrementaFigura(angoloCoinvoltoTr.getFigura());
							}
							
							if(esisteCartaCoinvoltaBr){
								angoloCoinvoltoBr.piazzaAngolo(cartaSopra.getBottom_right_angle());
								decrementaFigura(angoloCoinvoltoBr.getFigura());
							}
							if(esisteCartaCoinvoltaBl){
								angoloCoinvoltoBl.piazzaAngolo(cartaSopra.getBottom_left_angle());
								decrementaFigura(angoloCoinvoltoBl.getFigura());
							}
			
							if(esisteCartaCoinvoltaTl){
								angoloCoinvoltoTl.piazzaAngolo(cartaSopra.getTop_left_angle());
								decrementaFigura(angoloCoinvoltoTl.getFigura());
							}
							
							//incrementaColore(cartaSopra.getColore());
							incrementaFigura(cartaSopra.getFigura());
							incrementaFigura(cartaSopra.getTop_right_angle().getFigura());
							incrementaFigura(cartaSopra.getTop_left_angle().getFigura());
							incrementaFigura(cartaSopra.getBottom_right_angle().getFigura());
							incrementaFigura(cartaSopra.getBottom_left_angle().getFigura());
							
				}
				else {
					campo[x][y] = null;
					return false;
				}
				
				carteSulCampo.add(cartaSopra);
				return true;
				
			}
		//}
		
		return false;
		
	}
	
	
	private void incrementaFigura(Figura f) {
		
		if(f == null)
			return;
		
		switch(f) {
		case FARFALLA:
			contaFarfalla++;
			break;
			
		case FUNGO:
			contaFungo++;
			break;
		
		case LUPO:
			contaLupo++;
			break;
		
		case FOGLIA:
			contaFoglia++;
			break;
			
		case PERGAMENA:
			contaPergamena++;
			break;
		
		case PIUMA:
			contaPiuma++;
			break;
			
		case CIOTOLA:
			contaCiotola++;
			break;
		default:
			break;
		}
		
	}
	
	private void decrementaFigura(Figura f) {
		
		if(f == null)
			return;
		
		switch(f) {
		case FARFALLA:
			contaFarfalla--;
			break;
			
		case FUNGO:
			contaFungo--;
			break;
		
		case LUPO:
			contaLupo--;
			break;
		
		case FOGLIA:
			contaFoglia--;
			break;
			
		case PERGAMENA:
			contaPergamena--;
			break;
		
		case PIUMA:
			contaPiuma--;
			break;
			
		case CIOTOLA:
			contaCiotola--;
			break;
		default:
			break;
		}
		
	}
	
	/*
	//Incrementa il contatore del rispettivo colore
	private void incrementaColore(Colore c) {
		switch(c) {
		
		case ROSSO:
			this.contaRosse++;
			break;
		case BLU:
			this.contaBlu++;
			break;
		case VERDE:
			this.contaVerdi++;
			break;
		case VIOLA:
			this.contaViola++;
			break;
		default:
			break;
			
		}
	}
	*/
	/**
	 * 
	 * Restituisce la posizione nella matrice di una carta
	 * Se non è inserita nella matrice restiruisce null
	 * @param c
	 * @return
	 */
	
	/*
	
	public int getContaRosse() {
		return contaRosse;
	}

	public int getContaBlu() {
		return contaBlu;
	}

	public int getContaVerdi() {
		return contaVerdi;
	}

	public int getContaViola() {
		return contaViola;
	}
	
	*/

	/**
	 * Ritorna l'angolo in basee alla posizione: tl, tr, bl, br
	 * @param c
	 * @param pos
	 * @return
	 */
	
	private Angolo getAngoloPosizione(Carta c, String pos) {
		
		switch(pos){
			
			case "tl":
				return c.getTop_left_angle();
				
			case "tr":
				return c.getTop_right_angle();
				
			case "bl":
				return c.getBottom_left_angle();
				
			case "br":
				return c.getBottom_right_angle();
			
			default:
				return null;
			
		}
		
	}
	
	private  String getCoordinate(Carta c){
		
		int x,y;
		
		for(x=0;x<dimCampo;x++) {
			for(y=0;y<dimCampo;y++) {
				if(campo[x][y] == c) {
					return x+","+y;
				}
			}
		}
		
		return null;
		
	}
	
	public ArrayList <Carta> getCarteSulCampo(){
		return carteSulCampo;
	}
	
	public Carta getCartaPiazzataById(int id){
		for(Carta c: carteSulCampo) {
			if(c.getId()==id)
				return c;
		}
		return null;
	}
	
	/**
	 * Restituisce il reference della matrice che costituisce il campo da gioco
	 * @return
	 */
	
	public Carta[][] getMatriceCampo(){
		return campo;
	}
	
	
	public int getDimCampo() {
		return dimCampo;
	}
	
	public int getContaFarfalla() {
		return contaFarfalla;
	}

	public int getContaFungo() {
		return contaFungo;
	}

	public int getContaLupo() {
		return contaLupo;
	}

	public int getContaFoglia() {
		return contaFoglia;
	}

	public int getContaPergamena() {
		return contaPergamena;
	}

	public int getContaPiuma() {
		return contaPiuma;
	}

	public int getContaCiotola() {
		return contaCiotola;
	}
	
}
