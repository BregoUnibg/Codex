package requisiti;

import java.util.ArrayList;

import campo.CampoGioco;
import carte.Carta;
import carte.Colore;

public class ReqCarteObliqueCrescenti implements Requisito{
	
	
	private ArrayList <Carta> carteContate;
	private Colore colore;
	private int crescente;
	
	
	/**
	 * Controlla se nel campo di gioco ci sono tre carte oblique in ordine crescente dello stesso colore
	 * @param colore: Colore del trio di carte
	 * @param crescente:	True se il trio è crescente (dal basso verso l'alto)
	 * 						False se il trio è decrescente (dall'alto verso il basso)
	 */
	
	public ReqCarteObliqueCrescenti(Colore colore, boolean crescente) {
		
		carteContate = new ArrayList<Carta>();		
		this.colore = colore;
		
		//Viene invertito nel caso sia decrescente, inverte quindi il calcolo della posizione nei controlli
		
		if(crescente)
			this.crescente = 1;
		else
			this.crescente = -1;
	}
	
	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		
		Carta campo[][] = c.getMatriceCampo();
		int x,y;
		
		int dim = c.getDimCampo();
		
		int conta = 0;
		
		//Parte da 1 e va fino a -1 per evitare controlli inutili con IndexOutOfBound
		
		for(x=1;x<dim-1;x++){
			for(y=1;y<dim-1;y++) {
				
				try {
				
					if(
							(campo[x+crescente][y+1].getColore() == colore)&&
							(campo[x][y].getColore() == colore)&&
							(campo[x-crescente][y-1].getColore() == colore)
					){
						if(
								(!Requisito.presente(campo[x+crescente][y+1], carteContate))&&
								(!Requisito.presente(campo[x][y], carteContate))&&
								(!Requisito.presente(campo[x-crescente][y-1], carteContate))
						){
							conta++;
							carteContate.add(campo[x+crescente][y+1]);
							carteContate.add(campo[x][y]);
							carteContate.add(campo[x-crescente][y-1]);
							
							//QUESTO CODICE NON MI PIACE E SAREBBE DA OTTIMIZZARE IN QUALCHE MODO
							
						}
					}
					
				}catch(IndexOutOfBoundsException e){
					//NON SONO SICURO CHE FUNZIONI
					//Teoricamente se ho un eccezzione di indexoutofbound o Nullpointer dovrebbe provvedere a non fare niente e continuare semplicemente il ciclo
				}catch(NullPointerException e) {
					//Tutti e due i tipi di eccezioni che mi aspetto possano manifestarsi
				}
				
			}
		}
		
		return conta;
	}
	
	/**
	 * Controlla se la carta sia presente in carte contate
	 */
}
