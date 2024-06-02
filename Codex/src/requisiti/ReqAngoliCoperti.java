package requisiti;

import campo.CampoGioco;
import carte.Carta;

/**
 * Classe che controlla se un angolo di una carta risulta coperto, quindi, in alternativa capire se è possibile piazzarci sopra un'altra carta
 * @author Gabriele Bregolin
 * @author Matteo Megna 
 */

public class ReqAngoliCoperti implements Requisito{

	//Costruttore
	
	/**
	 * Controlla quanti angoli coopre la carta
	 */
	
	public ReqAngoliCoperti(){
		
	}
	
	/**
	 * Restituisce il numeri di angoli coperti dalla carta
	 * 
	 * <p>
	 * 
	 * Doc metodo ereditato:<p>
	 * {@inheritDoc}
	 * 
	 * @param c
	 * @param carta
	 * @return
	 */
	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		int conta = 0;
		
		
		if(carta.getTop_left_angle().getAngolo_associato()!=null)
			conta++;
		if(carta.getTop_right_angle().getAngolo_associato()!=null)
			conta++;
		if(carta.getBottom_left_angle().getAngolo_associato()!=null)
			conta++;
		if(carta.getBottom_right_angle().getAngolo_associato()!=null)
			conta++;
		
		return conta;
	
	}

}
