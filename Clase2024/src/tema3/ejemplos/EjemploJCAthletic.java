package tema3.ejemplos;

import java.util.*;

public class EjemploJCAthletic {

	private static final Object[][] GOLES_COPA = {
		{ "1ªronda", "1/11/23",	"Rubí-Athletic", "1-2", "Adu Ares", 50 },
		{ "1ªronda", "1/11/23",	"Rubí-Athletic", "1-2", "Adu Ares", 56 },
		{ "2ªronda", "7/12/23",	"Cayón-Athletic", "0-3", "Villalibre", 21 },
		{ "2ªronda", "7/12/23",	"Cayón-Athletic", "0-3", "Villalibre", 25 },
		{ "2ªronda", "7/12/23",	"Cayón-Athletic", "0-3", "Nico Williams", 84 },
		{ "dieciseisavos", "7/1/24", "Eibar-Athletic", "0-3", "Villalibre", 16 },
		{ "dieciseisavos", "7/1/24", "Eibar-Athletic", "0-3", "Muniain", 32 },
		{ "dieciseisavos", "7/1/24", "Eibar-Athletic", "0-3", "Villalibre", 39 },
		{ "octavos", "16/1/24",	"Athletic-Alavés", "2-0", "Villalibre", 28 },
		{ "octavos", "16/1/24",	"Athletic-Alavés", "2-0", "Villalibre", 60 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Guruzeta", 0 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Sancet", 48 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Iñaki Williams", 106 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Nico Williams", 120 },
		{ "semifinal", "7/2/24",	"Atlético-Athletic", "0-1", "Berenguer", 24 },
		{ "semifinal", "29/2/24",	"Athletic-Atlético", "3-0", "Iñaki Williams", 12 },
		{ "semifinal", "29/2/24",	"Athletic-Atlético", "3-0", "Nico Williams", 41 },
		{ "semifinal", "29/2/24",	"Athletic-Atlético", "3-0", "Guruzeta", 60 },
		{ "final", "6/4/24",	"Athletic-Mallorca", "1-1 (4-2)", "Sancet", 49 }
	};

	private static ArrayList<String> cargaGoleadores() {
		ArrayList<String> ret = new ArrayList<>();
		for (int i=0; i<GOLES_COPA.length; i++) {
			ret.add( (String) GOLES_COPA[i][4] );
		}
		return ret;
	}

	private static ArrayList<String> cargaPartidos() {
		ArrayList<String> ret = new ArrayList<>();
		for (int i=0; i<GOLES_COPA.length; i++) {
			ret.add( (String) GOLES_COPA[i][2] );
		}
		return ret;
	}


	private static ArrayList<String> goleadores;
	
	public static void main(String[] args) {
		// pruebaJCStrings();
		pruebaClasesComoClave();
	}

	private static void pruebaClasesComoClave() {
		// Jugadores solo una vez cada uno - nuestra propia clase Jugador
		ArrayList<String> jugadores = cargaGoleadores();
		HashSet<Jugador> setJugs = new HashSet<>();
		for (String jug : jugadores) {
			setJugs.add( new Jugador(jug) );
		}
		System.out.println( setJugs );
	}

	
	private static void pruebaJCStrings() {
		goleadores = cargaGoleadores();
		System.out.println( goleadores );
		if (goleadores.contains("Sancet")) {
			System.out.println( "Sancet ha metido gol" );
		}
		// Linkedlist -> otra lista
		LinkedList<String> listaEnl = new LinkedList<String>();
		for (String jugador : goleadores) {
			listaEnl.add( jugador );
		}
		System.out.println( listaEnl );
		if (listaEnl.contains("Sancet")) {
			System.out.println( "Sancet está en la linked list" );
		}

		// Sets: sin repetición, sín índice
		HashSet<String> conjuntoHash = new HashSet<>();
		for (String jugador : goleadores) {
			conjuntoHash.add( jugador );
		}
		System.out.println( conjuntoHash );
		if (conjuntoHash.contains( "Sancet" )) {
			System.out.println( "Sancet está en el conjunto" );
		}
		// Se puede recorrer
		System.out.println( "Recorrido de conjunto hash: ");
		for (String j : conjuntoHash) {
			System.out.println( "  " + j );
		}

		// Treeset - igual pero con orden
		TreeSet<String> conjuntoTree = new TreeSet<>();
		for (String jugador : goleadores) {
			conjuntoTree.add( jugador );
		}
		System.out.println( conjuntoTree );

		// Mapa: para qué? Por ejemplo cálculo de goleadores
		HashMap<String,Integer> mapaHash = new HashMap<>();
		// Carga:
		for (String jugador : goleadores) {
			if (mapaHash.containsKey(jugador)) {
				int numGoles = mapaHash.get(jugador);
				numGoles++;
				mapaHash.replace( jugador, numGoles );
			} else {
				mapaHash.put( jugador, 1 );
			}
		}
		System.out.println( mapaHash );
		// for (Integer val : mapaHash.values()) {
		// 	System.out.println( "Goles: " + val );
		// }
		for (String jug : mapaHash.keySet()) {
			System.out.println( "Jugador " + jug + " - goles " + mapaHash.get(jug) );
		}

		// Con treemap
		TreeMap<String,Integer> mapaTree = new TreeMap<>();
		for (String jugador : goleadores) {
			if (!mapaTree.containsKey(jugador)) {
				mapaTree.put( jugador, new Integer(1) );
			} else {
				// mapaTree.get( jugador )++;   No se puede porque Integer es inmutable
				int golesAnt = mapaTree.get( jugador );
				golesAnt++;
				mapaTree.replace( jugador, golesAnt );
			}
		}
		System.out.println( mapaTree );

		// Rehecho con contador mutable
		TreeMap<String,EnteroMutable> mapaTree2 = new TreeMap<>();
		for (String jugador : goleadores) {
			if (!mapaTree2.containsKey(jugador)) {
				mapaTree2.put( jugador, new EnteroMutable(1) );
			} else {
				mapaTree2.get(jugador).inc();
			}
		}
		System.out.println( mapaTree2 );

		// ¿Cómo sacar la lista de partidos de gol de cada goleador?
		ArrayList<String> partidos = cargaPartidos();
		HashMap<String,ArrayList<String>> mapaPartidos = new HashMap<>();
		for (int i=0; i<goleadores.size(); i++) {
			String jugador = goleadores.get(i);
			String partido = partidos.get(i);
			// if (!mapaPartidos.containsKey(jugador)) {
			// 	ArrayList<String> lista = new ArrayList<>();
			// 	mapaPartidos.put( jugador, lista );
			// 	lista.add( partido );
			// } else {
			// 	ArrayList<String> lista = mapaPartidos.get( jugador );
			// 	lista.add( partido );
			// }
			mapaPartidos.putIfAbsent( jugador, new ArrayList<>() );
			// if (!mapaPartidos.containsKey(jugador)) {
			// 	mapaPartidos.put( jugador, new ArrayList<>() );
			// }
			mapaPartidos.get( jugador ).add( partido );
		}
		System.out.println( mapaPartidos );
		for (String jugador : mapaPartidos.keySet()) {
			System.out.println( "  " + jugador + " - goles en " + mapaPartidos.get(jugador) );
		}

	}
	
}
