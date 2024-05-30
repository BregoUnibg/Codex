package requisiti;

import campo.CampoGioco;
import carte.Carta;

public class ReqCartaFalse implements Requisito{

	/**
	 * 	 
	 * Requisito logico tecnico che risulterà sempre insoddisfatto
	 * <p>
	 * 
	 * Doc metodo ereditato:<p>
	 * {@inheritDoc}
	 * 
	 * @param campo
	 * @param carta
	 * @return
	 */
	@Override
	public int soddisfatto(CampoGioco campo, Carta carta) {
		
		return 0;
	}

}
