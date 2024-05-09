package requisiti;

import java.util.ArrayList;

import campo.CampoGioco;
import carte.Carta;
import carte.Colore;

public class ReqLViolaBlu implements Requisito{
	
	private ArrayList <Carta> carteContate; //Carte che sono già state contate per una singola L
	
	public ReqLViolaBlu(){
		
		this.carteContate = new ArrayList <Carta>();
		
	}
	
	@Override
	/**
	 * Conta il numero di L sul campo uniche, formate da due carte viola parallele una sotto l'altra e 
	 * Una carta blu collegata con l'angolo in basso a destra alla carta viola superiore
	 */
	public int soddisfatto(CampoGioco c) {
		
		int conta = 0;
		
		Carta[][] campo = c.getMatriceCampo();
		
		int x,y;
		int dim = c.getDimCampo();
		
		//Stesso ragionamento delle eccezioni usato per ReqCarteObliqueCrescenti
		
		for(x=1;x<dim;x++) {
			for(y=1;y<dim-1;y++){
				
				try {
					
					if(
							(campo[x-1][y+1].getColore() == Colore.BLU)&&
							(campo[x][y].getColore() == Colore.VIOLA)&&
							(campo[x][y-1].getColore() == Colore.VIOLA)
							
							) {
						
						if(
								(!Requisito.presente(campo[x-1][y+1], carteContate))&&
								(!Requisito.presente(campo[x][y], carteContate))&&
								(!Requisito.presente(campo[x][y-1], carteContate))
								
								){
							
							carteContate.add(campo[x-1][y+1]);
							carteContate.add(campo[x][y]);
							carteContate.add(campo[x][y-1]);
									
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
