//Non capisco l'utilità di questo requisito
package requisiti;

import campo.CampoGioco;
import carte.*;

public class ReqCartaSingola implements Requisito{

	//Attributi
	private int numero;
	private final Colore colore;

	//Costruttore
	public ReqCartaSingola(Colore colore, int numero) {
		this.colore=colore;
		this.numero=numero;
	}
	
	/**
	 * 
	 * @param c
	 * @param carta
	 * @return
	 */
	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		return 0;
	}

}
