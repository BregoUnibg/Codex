package requisiti;

import campo.Campo_gioco;
import carte.*;

public class ReqCartaSingola implements Requisito{

	private int numero;
	private final Colore colore;

	public ReqCartaSingola(Colore colore, int numero) {
		this.colore=colore;
		this.numero=numero;
	}
	
	
	@Override
	public boolean soddisfatto(Campo_gioco c) {
		return false;
	}

}
