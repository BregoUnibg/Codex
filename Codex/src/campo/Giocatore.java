package campo;

public class Giocatore {
	
		//Attributi
		private String nome;
		private Mano mano;
		private CampoGioco campoGioco;
		
		int punti;				//da togliere

		//Costrutto
		public Giocatore(String nome) {
			this.nome=nome;
		}
		
		
		public Mano getMano() {
			return mano;
		}
		
		public CampoGioco getCampoGioco() {
			return campoGioco;
		}
		
		public String getNome() {
			return nome;
		}
		
		public int calolaPunti() {
			return punti;		//La scriveremeo in modo tale che li clacoli sul momento	
		}
}
