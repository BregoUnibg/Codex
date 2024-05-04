package campo;

public class Giocatore {
	
		//Attributi
		private String nome;
		private Mano mano;
		private CampoGioco campoGioco;
		private Pedina pedina;
		int punti;

		//Costrutto
		public Giocatore(String nome, Pedina pedina) {
			this.nome=nome;
			this.pedina = pedina;
			this.punti = 0;
			this.campoGioco = new CampoGioco();
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
		
		/**
		 * Dopo aver soddisfatto un obiettivo si aggiungono dati al "saldo punti" del giocatore
		 */
		
		public void addPunti(int punti) {
			this.punti += punti;
		}
		
		public int getPunti() {
			return punti;	
		}
}
