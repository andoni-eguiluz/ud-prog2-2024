package tema4.resueltos;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/** Clase para objetos de película, ejemplo para practicar gestión de ficheros con ella
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class Peli implements Comparable<Peli>, Serializable {
	static final long serialVersionUID = 1L;
	private String nombre;
	private int anyo;

	public Peli(String nombre) {
		super();
		this.nombre = nombre;
		this.anyo = 0;
	}
	
	public Peli(String nombre, int anyo) {
		this.nombre = nombre;
		this.anyo = anyo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	@Override
	public int hashCode() {
		return nombre.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Peli)) return false;
		return nombre.equals( ((Peli)obj).nombre ); 
	}

	@Override
	public String toString() {
		return nombre + " (" + anyo + ")";
	}

	@Override
	public int compareTo(Peli o) {
		return nombre.compareTo( o.nombre );
	}

	// Métodos de conversión a texto para gestión de ficheros
	public String aLineaCSV() {
		return nombre + "," + anyo;
	}

	// Podríamos inventarnos public Peli( String lineaCsv, boolean algo )
	// Además un constructor no puede devolver nada distinto a una peli
	// throws IOException (o cualquier otra excepción)

	// Constructor indirecto
	/** Crea un nuevo objeto de tipo Peli y lo devuelve, partiendo de una línea de texto en formato CSV
	 * @param linea	Línea de texto (formato nombre peli,año)
	 * @return	Nuevo objeto con esos datos
	 * @throws NullPointerException	Generada cuando linea es null
	 * @throws NoSuchElementException	Generada cuando falta algún dato de la peli en la línea
	 * @throws NumberFormatException	Generada cuando el año es incorrecto (no es numérico)
	 */
	public static Peli creaPeliDesdeLineaCSV( String linea ) throws NullPointerException, NoSuchElementException, NumberFormatException {
		StringTokenizer st = new StringTokenizer( linea, "," );
		// String trozo[] = linea.split( "," );   equivalente
		String nombre = st.nextToken();
		int anyo = Integer.parseInt( st.nextToken() );
		Peli peliNueva = new Peli( nombre, anyo );
		return peliNueva;
	}


}