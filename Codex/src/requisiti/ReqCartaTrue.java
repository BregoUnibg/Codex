package requisiti;

import campo.CampoGioco;
import carte.Carta;

public class ReqCartaTrue implements Requisito{

	@Override
	public int soddisfatto(CampoGioco c, Carta carta) {
		
		return 1;

	}

}
