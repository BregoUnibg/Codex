package requisiti;

import campo.CampoGioco;
import carte.Carta;

public class ReqCartaFalse implements Requisito{

	/**
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
