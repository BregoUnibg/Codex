//Non capisco l'utilità di questo requisito
package requisiti;

import campo.CampoGioco;
import carte.*;

public class ReqCartaSingola implements Requisito{

	private int numero;
	private final Colore colore;

	public ReqCartaSingola(Colore colore, int numero) {
		this.colore=colore;
		this.numero=numero;
	}
	
	
	@Override
	public boolean soddisfatto(CampoGioco c) {
		return false;
	}

}
