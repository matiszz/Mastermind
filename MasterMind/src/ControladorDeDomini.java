
public class ControladorDeDomini {
		GeneradorJocs generador;
		Ranking ranking;
		
		//Creadora 
		public ControladorDeDomini(GeneradorJocs generador, Ranking ranking) {
			this.generador = generador;
			this.ranking = ranking;
		}
		
		//Setters
		public void setgenerador(GeneradorJocs generador) {
			this.generador = generador;
		}
		
		public void setranking(Ranking ranking) {
			this.ranking = ranking;
		}
		
		//Getters
		public Ranking getranking() {
			return this.ranking;
		}
		
		public GeneradorJocs getgenerador() {
			return this.generador;
		}
		
		//Casos d'ús
		public void registrar() {}
		
		public void generar_joc() {}
		
		public void jugar_partida() {}
		
		public void guardar_partida() {}
		
		public void finalitzar_partida() {}
		
		public void continuar_partida() {}
		
		public void fer_jugada() {}
		public void consultar_ranking() {}
		
		
}
