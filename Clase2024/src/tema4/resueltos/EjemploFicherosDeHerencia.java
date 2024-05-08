package tema4.resueltos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/** Ejemplo para aprender a hacer ficheros binarios y de texto
 * con una pequeña jerarquía Usuario / UsuarioDePago / UsuarioGratis
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class EjemploFicherosDeHerencia {
	private static ArrayList<Usuario> lUsuarios = new ArrayList<>();
	public static void main(String[] args) {
		lUsuarios.add( new UsuarioDePago( "a", new Password("aa"), 25.0 ) );
		lUsuarios.add( new UsuarioGratis( "b", new Password("bb"), 5 ) );
		lUsuarios.add( new UsuarioDePago( "c", new Password("cc"), 18.0 ) );
		System.out.println( "Antes de fichero: " + lUsuarios );
		// TODO
		// Implementar y llamar guardarUsuariosEnFicheroBinario()
		guardarUsuariosEnFicheroBinario();
		// Implementar y llamar cargarUsuariosEnFicheroBinario()
		lUsuarios = cargarUsuariosEnFicheroBinario();
		System.out.println( "Después de fichero binario: " + lUsuarios );
		// Implementar y llamar guardarUsuariosEnFicheroDeTexto()
		guardarUsuariosEnFicheroDeTexto();
		// Implementar y llamar cargarUsuariosEnFicheroDeTexto()
		lUsuarios = cargarUsuariosEnFicheroDeTexto();
		System.out.println( "Después de fichero de texto: " + lUsuarios );
	}

	private static void guardarUsuariosEnFicheroBinario() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( "usuarios.dat") );
			oos.writeObject( lUsuarios );
			// for (Usuario u : lUsuarios) {
			// 	oos.writeObject( u );
			// }
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( "Error en escritura de fichero usuarios.dat" );
		}
	}
	private static ArrayList<Usuario> cargarUsuariosEnFicheroBinario() {
		try {
			ObjectInputStream ois = new ObjectInputStream( new FileInputStream( "usuarios.dat" ) );
			ArrayList<Usuario> l = (ArrayList<Usuario>) ois.readObject();
			ois.close();
			return l;
		} catch (Exception e) {
			System.out.println( "Error en lectura de fichero usuarios.dat" );
			e.printStackTrace();
			return null;
		}
	}
	private static void guardarUsuariosEnFicheroDeTexto() {
		try {
			PrintStream ps = new PrintStream( "usuarios.txt" );
			for (Usuario u : lUsuarios) {
				ps.println( u.aLineaTexto() );
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( "Error en guardado de usuarios.txt" );
		}
	}
	private static ArrayList<Usuario> cargarUsuariosEnFicheroDeTexto() {
		try {
			Scanner scanner = new Scanner( new FileInputStream( "usuarios.txt" ) );
			ArrayList<Usuario> l = new ArrayList<>();
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				String[] trozos = linea.split( "\t" );
				Usuario u = null;
				if (trozos[0].equals( "PAGO")) {
					u = UsuarioDePago.crearNuevo( trozos );
				} else if (trozos[0].equals( "GRATIS")) {
					u = UsuarioGratis.crearNuevo( trozos );
				} else {
					// u null - incorrecto
				}
			}
			scanner.close();
			return l;
		} catch (Exception e) {
			System.out.println( "Error lectura fichero de texto" );
			return null;
		}
	}
	
}



abstract class Usuario implements Serializable {
	protected String nick;
	protected Password password;
	protected String passwordAsteriscos;
	public Usuario(String nick, Password password) {
		this.nick = nick; this.password = password;
		passwordAsteriscos = password.toString();
	}
	public String getNick() { return nick; }
	public Password getPassword() { return password; }
	@Override public String toString() { return nick + " " + passwordAsteriscos; }
	public abstract String aLineaTexto();
}

class UsuarioDePago extends Usuario implements Serializable {
	private double cuota;
	public UsuarioDePago(String nick, Password password, double cuota) {
		super(nick, password);
		this.cuota = cuota;
	}
	public double getCuota() { return cuota; }
	@Override public String toString() { return super.toString() + " " + cuota; }
	public String aLineaTexto() {
		return "PAGO\t" + nick + "\t" + password.getPassword() + "\t" + passwordAsteriscos + "\t" + cuota;
	}
	public static UsuarioDePago crearNuevo( String[] trozos ) {
		try {
			UsuarioDePago u = new UsuarioDePago( trozos[1], new Password( trozos[2] ),
			  	Double.parseDouble( trozos[4] ) );
			return u;
		} catch (Exception e) {
			System.out.println( "Error en línea " + Arrays.toString( trozos ) );
			return null;
		}
	}
}

class UsuarioGratis extends Usuario implements Serializable {
	private int numAnuncios;
	public UsuarioGratis(String nick, Password password, int numAnuncios) {
		super(nick, password);
		this.numAnuncios = numAnuncios;
	}
	public int getNumAnuncios() { return numAnuncios; }
	@Override public String toString() { return super.toString() + " " + numAnuncios; }
	public String aLineaTexto() {
		return "GRATIS\t" + nick + "\t" + password.getPassword() + "\t" + passwordAsteriscos + "\t" + numAnuncios;
	}
	public static UsuarioGratis crearNuevo( String[] trozos ) {
		try {
			UsuarioGratis u = new UsuarioGratis( trozos[1], new Password( trozos[2] ),
			  	Integer.parseInt( trozos[4] ) );
			return u;
		} catch (Exception e) {
			System.out.println( "Error en línea " + Arrays.toString( trozos ) );
			return null;
		}
	}
}

class Password implements Serializable {
	private String password;
	public Password(String password) {
		super();
		this.password = password;
	}
	public String getPassword() { return password; }
	@Override
	public String toString() { return password.replaceAll( ".", "*" ); }
}
