package com.prop.domini;

import java.util.ArrayList;

import com.prop.persistencia.*;
import com.prop.presentacio.*;

public class ControladorDeDomini {
		GeneradorJocs generador;
		Ranking ranking;
		Partida partida;
		Jugador jugador;
		Registre reg = null;
		GeneradorJocs gen =  null;
		Joc joc = null;
		ControladorDePersistencia persistencia = null;
		ControladorDePresentacio presentacio = null;
		//Creadora 
		
		public ControladorDeDomini(GeneradorJocs generador, Ranking ranking) {
			this.generador = generador;
			this.ranking = ranking;
			persistencia = new ControladorDePersistencia();
			presentacio = new ControladorDePresentacio();
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
		public void registrar(String id) { //OK
			/*
			Primer comproba si hi ha algun registre, si no hi ha el crea.
			Després registra el jugador i l'emmagatzema a la bd.
			 */
			if(reg == null) 
				reg = new Registre();
			jugador = reg.registrar(id); 
			/*Ha de llançar una excepció si ja existeix un jugador amb mateix id, altrament retorna el jugador creat 
			per poder emmagatemar-lo a la BD.*/
			if(jugador != null) {
				String j = jugador.converteixaString();
				persistencia.emmagatzema(j,true);
			}
		}
		
		public void generar_joc(boolean codeMaker) {
			/*
			 Comproba que existeixi un generador de jocs, si no existeix el crea.
			 Un cop sabe que existeix un generador de jocs, crea el joc segons el parametre,
			 Que indica si es un joc amb els valor per defecte o bé personalitzats.
			 */
			if(gen == null) {
				gen = new GeneradorJocs(20,4,4,codeMaker,1); //Per defecte dificultat facil
			}
			joc = gen.generaJocDefault();
			partida = joc.crearPartida(); //Aquí falta tractar el mode
		}
		
		
		public void jugar_partida() {
			/*
			 Comrpoba que existeix un joc i un generador de partides.
			 Crea la partida i l'assigna a joc.
			 Inicia la partida segons si es codemaker o codebreaker.
			 Inicia el clock
			 */
			String s = partida.converteixaString(); //Falta implementar
			presentacio.mostra_tauler(s);//Fem que el controlador de presentacio mostri la partida actual
		}
		
		public void guardar_partida() {
			/*
			 Escriu en un fitxer totes les dades de la partida actual.
			 Atura el clock
			 */
			String p = partida.converteixaString();
			persistencia.emmagatzema(p,false);
		}
		
		public void finalitzar_partida() {
			/*
			 Un cop s'ha encertat el codi o bé s'han acabat el numero d'intents finalitza la partida,
			 és a dir, calcula la puntuació, comproba si s'ha dactualitzar el ranking, actualitza (si cal),
			 les dades del jugador i:
			 a)torna a iniciar una altra partida amb el mateix joc
			 b)torna a generar un nou joc
			 Atura el clock
			 */
			partida.guardarPartida();
			int res = partida.finalitzarPartida();
			jugador.actualitzar_partides(res,partida.getdificultat());
			int dificultat = generador.getDificultat();
			FilaRanking f = new FilaRanking(res,jugador.getIdJugador());
			ranking.afegeix_fila(f, dificultat);
			presentacio.mostra_menuprincipal();
		}
		
		public ArrayList<Partida> converteixpartides(String[] info){ //ULL hi ha parametres que no es tenen en compte
			ArrayList<Partida> p = new ArrayList<Partida>();
			for(int i = 0; i < info.length;i=i+13) {
				Partida newp = new Partida(Integer.parseInt(info[i]), info[i+1],Boolean.parseBoolean(info[i+2]),Integer.parseInt(info[i+3]),Integer.parseInt(info[i+4]));
				p.add(newp);
			}
			return p;
		}
		
		public void continuar_partida() {
			/*
			 Recupera del fitxer les partides guardades del jugador actual,
			 */
			String[] partides = persistencia.obtepartidesjugador(jugador.getIdJugador());
			ArrayList<Partida> pendents = converteixpartides(partides);
			int seleccionada = presentacio.mostra_partides_disponibles(partides);
			partida = pendents.get(seleccionada);
			this.jugar_partida();
			//S'ha de cridar al controlador de domini per que obtingui les partides no finalitzades del jugador que te com atribut
		}
		
		private ArrayList<Integer> converteixcodi(int[] codi) { 
			ArrayList<Integer> res = new ArrayList<Integer>();

			for(int i = 0; i < codi.length;++i) {
				res.add(codi[i]);
			}
			return res;
		}
		
		private String[] converteixcodi(ArrayList<Integer> codi) {
			String[] res = new String[codi.size()];
			for(int i = 0; i < codi.size();++i)
				res[i]=codi.get(i).toString();
			return res;
		}
		
		public void fer_jugada(int[] codip) { //El controlador de presentacio ens pasa un vector d'enters que es el codi
			/*
			 Evalua el codi proposat comparant-lo amb la solució i retorna el resultat segons les regles
			 del joc. (Blanc color i la posició correcte, Negre si color correcte, posició incorrecte, 0 si
			 no hi ha res bé).
			 Anotación: 0 o cualquier otro valor, la idea es señalizar un espacio en blanco
			 */
			ArrayList<Integer> codiproposat = converteixcodi(codip);
			if(jugador != null && partida != null) {
					int num = partida.getNumJugades(); //Devuelve el numero de la jugada
					ArrayList<Integer> solucio = partida.getCodiamagat();
					Jugada j = new Jugada(num,partida,jugador);
					j.setcodiProposat(codiproposat);
					partida.ferJugada(j);
					Algorisme a = new Algorisme();
					ArrayList<Integer> codiresp = a.aplica_logica(solucio, codiproposat);
					j.setcodiRespost(codiresp);
					String[] cod = converteixcodi(codiresp);
					presentacio.afegeix_codi_respost(cod);
			}
		}
		
		private Ranking converteix_info(String[] info) { //Cal saber com pasarem la info
			Ranking r = new Ranking();
			for(int j = 1; j < 4; ++j) {//Per cada dificultat
				for(int i = 0; i < info.length;i+=3) {
					FilaRanking fil = new FilaRanking();
					int n = Integer.parseInt(info[i+1]); //Cal convertir a enter
					fil.setintents(n);
					fil.setjugador(info[i+2]);		
					if(j == 1)
						r.r_facil.add(fil);
					else if (j == 2)
						r.r_medio.add(fil);
					else if (j == 3)
						r.r_dificil.add(fil);
				}
			}
			return r;
		}
		
		public void consultar_ranking() { 
			/* Crida a la funcion de ranking que retorna el ranking actual. */
			if(ranking == null) { //S'ha de cridar al controlador de persistencia per que agafi del arxiu el ranking
				String[] info = persistencia.obteranking();
				ranking = converteix_info(info);
			}
			for(int i = 1; i <=3;++i)
					ranking.mostra_ranking(i);
		}	
		
		
}
