package campo;

import java.util.ArrayList;

import carte.*;

public class Campo_gioco {
	
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
	
	private int contaFarfalla;
	private int contaFungo;
	private int contaLupo;
	private int contaFoglia;
	private int contaPergamena;
	private int contaPiuma;
	private int contaCiotola;
	
	
	
	public Campo_gioco() {
		
		campo = new Carta[dimCampo][dimCampo];
		contaFarfalla = 0;
		contaFungo = 0;
		contaLupo = 0;
		contaFoglia = 0;
		contaPergamena = 0;
		contaPiuma = 0;
		contaCiotola = 0;
		
		
		
	}
	
	/**
	 * Posiziona la carta iniziale al centro del campo da gioco
	 * @param c
	 */
	
	public void piazzaCartaIniziale(C_iniziale c){
		
		int centro = (dimCampo-1)/2+1;
		
		campo[centro][centro] = c;
		
		for(Figura f: c.getFigure()){
			incrementaFigura(f);
		}
		
		incrementaFigura(c.getTop_right_angle().getFigura());
		incrementaFigura(c.getTop_left_angle().getFigura());
		incrementaFigura(c.getBottom_right_angle().getFigura());
		incrementaFigura(c.getBottom_left_angle().getFigura());
		
	}
	
	
	/**
	 * 
	 * piazza una carta nella matrice se il piazzamento è valido
	 * 
	 * @param cartaSotto
	 * @param angoloSotto
	 * @param cartaSopra
	 * @param angoloSopra
	 * @return
	 */
	
	
	public boolean piazzaCarta(Carta cartaSotto, String angoloSotto, Carta cartaSopra, String angoloSopra) {
		
		//Passo le carte da collegare con la posizione del relativo angolo da collegare
		
		//tr: TopRight, tl: TopLeft, br, BottomRight, bl, BottomLeft
		
		//Gli angolo possono essere attaccati solo ad angoli opposti di un'altra carta, esempii: topRight->bottomLeft, topLeft->bottomRight
		
		
		//Controllo quindi che siano angoli opposti
		
		if((angoloSotto.substring(0, 1)!=angoloSopra.substring(0,1)) && (angoloSotto.substring(1, 2)!=angoloSopra.substring(1,2))){
			
			Angolo sotto = getAngoloPosizione(cartaSotto, angoloSotto);
			Angolo sopra = getAngoloPosizione(cartaSopra, angoloSopra);
			
			if(sotto.piazzaAngolo(sopra)){
				
				String coordSotto = getCoordinate(cartaSotto);
				
				int x = Integer.parseInt(coordSotto.split(",",2)[0]);
				int y = Integer.parseInt(coordSotto.split(",",2)[1]);
				
				switch(angoloSotto){
					
					case "tl":
						campo[x-1][y+1] = cartaSopra;
						break;
						
					case "tr":
						campo[x+1][y+1] = cartaSopra;
						break;
						
					case "bl":
						campo[x-1][y-1] = cartaSopra;
						break;
						
					case "br":
						campo[x+1][y-1] = cartaSopra;
						break;	
						
				}
				
				decrementaFigura(sotto.getFigura());
				
				incrementaFigura(cartaSopra.getFigura());
				incrementaFigura(cartaSopra.getTop_right_angle().getFigura());
				incrementaFigura(cartaSopra.getTop_left_angle().getFigura());
				incrementaFigura(cartaSopra.getBottom_right_angle().getFigura());
				incrementaFigura(cartaSopra.getBottom_left_angle().getFigura());
				
				return true;
				
			}
		}
		
		return false;
		
	}
	
	public void incrementaFigura(Figura f) {
		
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
	
public void decrementaFigura(Figura f) {
		
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
		
	
	/**
	 * 
	 * Restituisce la posizione nella matrice di una carta
	 * Se non è inserita nella matrice restiruisce null
	 * @param c
	 * @return
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
		
		for(int x=0;x<dimCampo;x++) {
			for(int y=0;y<dimCampo;y++) {
				if(campo[x][y] == c)
					return x+","+y;
			}
		}
		
		return null;
		
	}
	
	
	
	
	
	
}
