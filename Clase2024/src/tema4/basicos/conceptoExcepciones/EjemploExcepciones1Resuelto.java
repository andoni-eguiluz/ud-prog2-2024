package tema4.basicos.conceptoExcepciones;

import java.io.File;
import java.util.Scanner;

/** Clase de ejemplo para entender excepciones sencillas
 */
public class EjemploExcepciones1Resuelto {
	public static void main(String[] args) {
		System.out.println( "Inicio del programa" );
		try {
			excepcionNoGestionada(5,0);
		} catch (ArithmeticException e) {
			// System.out.println( "Error en cálculo" );
			// e.printStackTrace();
		}
		System.out.println( "Punto entre llamadas" );
		excepcionGestionada();
		System.out.println( "Fin del programa" );
	}
	
	/** Saca a consola la operación de división de i entre j
	 * @throws ArithmeticException	Cuando j es cero
	 */
	private static void excepcionNoGestionada(int i, int j) throws ArithmeticException {
		// try {
			System.out.println( i + "/" + j + "=" + (i/j) );
		// } catch (ArithmeticException e) {
		// 	// Tratamiento / gestión del error
		//	System.out.println( "Error de cálculo" );			
		// }
	}

	private static void excepcionGestionada() {
		// TODO Descomentar estas líneas
		// Scanner leer = new Scanner( new File( "prueba.txt" ) );
		// System.out.println( "Contenidos del fichero prueba.txt" );
		// while (leer.hasNextLine()) {
		// 	System.out.println( leer.nextLine() );
		// }
		// leer.close();
	}
	
}
