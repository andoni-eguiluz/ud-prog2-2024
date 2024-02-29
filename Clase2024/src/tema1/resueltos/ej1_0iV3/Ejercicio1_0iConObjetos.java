package tema1.resueltos.ej1_0iV3;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio1_0iConObjetos {

	private static RedSocial x;
	private static RedSocial instagram;

	public static void main(String[] args) {
		System.out.println( UsuarioRedSocial.getNumUsuarioRS() );
		x = new RedSocial( "x", "x.com" );
		x.anyadir( new UsuarioRedSocial( "@sams", 1300 ) );
		x.anyadir( new UsuarioRedSocial( "@JeffBezos", 61000 ) );
		x.anyadir( new UsuarioRedSocial( "@BillGates", 62000 ) );
		x.anyadir( new UsuarioRedSocial( "@elonmusk", 128900 ) );
		x.visualizarUsuariosYSeguidores();
		x.ordenaUsuariosPorSeguidores();
		x.visualizarUsuariosYSeguidores();
		System.out.println( UsuarioRedSocial.getNumUsuarioRS() );

		// Añadir usuarios
		x.anyadir( new UsuarioRedSocial( "Andoni" ) );
		x.ordenaUsuariosPorSeguidores();
		x.visualizarUsuariosYSeguidores();
		// Buscar usuario
		UsuarioRedSocial usuarioABuscar = new UsuarioRedSocial( "@BillGates", 62000 );
		System.out.println( "En qué posición? " + x.buscarUsuario( usuarioABuscar ) );

		instagram = new RedSocial( "instagram", "instagram.com" );
		instagram.anyadir( new UsuarioRedSocial( "sama", 6 ) );
		instagram.anyadir( new UsuarioRedSocial( "thisisbillgates", 9000 ) );
		System.out.println( instagram.getNumUsuarios() );

		interaccion();
	}

	private static void interaccion() {
		Object resp = JOptionPane.showInputDialog( null, "Elige red social", "Menú", JOptionPane.QUESTION_MESSAGE, null, 
			new Object[] { "X", "Instagram" }, "X" );
		System.out.println( resp );
		if ("X".equals(resp)) {
			// Gestiono X
		} else if ("Instagram".equals(resp)) {
			// Gestiono instagram
		} else {
			// Información de final
		}
	}


	private static void bajaSeguidores( int numBaja, UsuarioRedSocial[] usuarios ) {
		for (int i=0; i<usuarios.length; i++) {
			usuarios[i].setNumMilesSeguidores( usuarios[i].getNumMilesSeguidores() + numBaja );
		}
	}
	
	
}
