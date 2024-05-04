//Non capisco l'utilità di questo requisito
package requisiti;

import campo.CampoGioco;
import carte.*;

public class ReqCartaDoppia implements Requisito{
	
	private Colore colore1;
	private int num1;
	private Colore colore2;
	private int num2;
	
	public ReqCartaDoppia(Colore colore1, int num1, Colore colore2, int num2) {
		this.colore1=colore1;
		this.num1=num1;
		this.colore2=colore2;
		this.num2=num2;
	}
	
	
	@Override
	public int soddisfatto(CampoGioco c) {
		return 0;
	}

}
