package requisiti;

import campo.CampoGioco;
import carte.Carta;

public class ReqCartaFalse implements Requisito{

	@Override
	public int soddisfatto(CampoGioco campo, Carta carta) {
		
		return 0;
	}

}
