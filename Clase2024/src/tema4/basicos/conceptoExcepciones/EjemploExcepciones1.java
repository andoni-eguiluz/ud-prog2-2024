package tema4.basicos.conceptoExcepciones;

import java.io.File;
import java.util.Scanner;

/** Clase de ejemplo para entender excepciones sencillas
 */
public class EjemploExcepciones1 {
	public static void main(String[] args) {
		excepcionNoGestionada();
		excepcionGestionada();
	}
	
	private static void excepcionNoGestionada() {
		int i = 5;
		int j = 0;
		System.out.println( i + "/" + j + "=" + (i/j) );
	}

	private static void excepcionGestionada() {
		// TODO Descomentar estas líneas
//		Scanner leer = new Scanner( new File( "prueba.txt" ) );
//		System.out.println( "Contenidos del fichero prueba.txt" );
//		while (leer.hasNextLine()) {
//			System.out.println( leer.nextLine() );
//		}
//		leer.close();
	}
	
}
