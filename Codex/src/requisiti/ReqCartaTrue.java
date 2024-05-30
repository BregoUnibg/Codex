package requisiti;

import campo.CampoGioco;
import carte.Carta;

public class ReqCartaTrue implements Requisito{

	/**
	 * Requisito logico tecnico che risulterà sempre soddisfatto
	 * <p>
	 * 
	 * Doc metodo ereditato:<p>
	 * {@inheritDoc}
	 * @param c
	 * @param carta
	 * @return
	 */
	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		return 1;

	}

}
