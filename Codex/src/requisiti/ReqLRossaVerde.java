package requisiti;

import java.util.ArrayList;

import campo.CampoGioco;
import carte.Carta;
import carte.Colore;

/**
 * contiene il requisito di un obiettivo che si verifica quando nel campo di un giocatore sono visibili due carte rosse parallele una sotto l'altra e 
 * una carta verde collegata con l'angolo in alto a sinistra alla carta rossa inferiore
 * @author Gabriele Bregolin
 * @author Matteo Megna 
 */

public class ReqLRossaVerde implements Requisito{
	
	private ArrayList <Carta> carteContate; //Carte che sono già state contate per una singola L
	
	/**
	 * Conta il numero di L sul campo uniche, formate da due carte rosse parallele una sotto l'altra e 
	 * Una carta verde collegata con l'angolo in alto a sinistra alla carta rossa inferiore
	 */
	
	public ReqLRossaVerde(){
		
		this.carteContate = new ArrayList <Carta>();
		
	}
	
	/**
	 * Conta il numero di L sul campo uniche, formate da due carte rosse parallele una sotto l'altra e 
	 * Una carta verde collegata con l'angolo in alto a sinistra alla carta rossa inferiore
	 * 
	 * <p>Doc metodo ereditato:<p>
	 * {@inheritDoc}
	 */
	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		int conta = 0;
		
		Carta[][] campo = c.getMatriceCampo();
		
		int x,y;
		int dim = c.getDimCampo();
		
		//Stesso ragionamento delle eccezioni usato per ReqCarteObliqueCrescenti
		
		for(x=0;x<dim-1;x++) {
			for(y=2;y<dim-1;y++){
				
				try {
					
					if(
							(campo[x][y+2].getColore() == Colore.ROSSO)&&
							(campo[x][y].getColore() == Colore.ROSSO)&&
							(campo[x+1][y-1].getColore() == Colore.VERDE)
							
							) {
						
						if(
								(!Requisito.presente(campo[x][y+2], carteContate))&&
								(!Requisito.presente(campo[x][y], carteContate))&&
								(!Requisito.presente(campo[x+1][y-1], carteContate))
								
								){
									
							carteContate.add(campo[x][y+2]);
							carteContate.add(campo[x][y]);
							carteContate.add(campo[x+1][y-1]);

							conta++;
							
						}
					}
					
				}catch(NullPointerException e){
					
				}catch(IndexOutOfBoundsException e) {
					
				}
			}
		}		
		
		return conta;
	}
	
}
