package campo;

import carte.CartaObiettivo;

public class Giocatore {
	
		//Attributi
		private String nome;
		private Mano mano;
		private CampoGioco campoGioco;
		private Pedina pedina;
		private CartaObiettivo cartaObiettivoNascosta;
		private int punti;

		//Costrutto
		public Giocatore(String nome, Pedina pedina) {
			this.nome=nome;
			this.pedina = pedina;
			this.punti = 0;
			this.campoGioco = new CampoGioco();
			this.mano = new Mano();
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


		public CartaObiettivo getCartaObiettivoNascosta() {
			return cartaObiettivoNascosta;
		}


		public void setCartaObiettivoNascosta(CartaObiettivo cartaObiettivoNascosta) {
			this.cartaObiettivoNascosta = cartaObiettivoNascosta;
		}
		
		
		
		
}
