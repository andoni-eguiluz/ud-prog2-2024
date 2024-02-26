package tema1.resueltos.ej1_0iV2;

public class Ejercicio1_0iConObjetos {

	public static void main(String[] args) {
		UsuarioRedSocial[] usuariosRS = new UsuarioRedSocial[4];
		usuariosRS[0] = new UsuarioRedSocial( "@sams", 1300 );
		usuariosRS[1] = new UsuarioRedSocial( "@JeffBezos", 61000 );
		usuariosRS[2] = new UsuarioRedSocial( "@BillGates", 62000 );
		usuariosRS[3] = new UsuarioRedSocial( "@elonmusk", 128900 );
		visualizarUsuariosYSeguidores( usuariosRS );
		ordenaUsuariosPorSeguidores( usuariosRS );
		visualizarUsuariosYSeguidores( usuariosRS );
	}

	private static void bajaSeguidores( int numBaja, UsuarioRedSocial[] usuarios ) {
		for (int i=0; i<usuarios.length; i++) {
			usuarios[i].setNumMilesSeguidores( usuarios[i].getNumMilesSeguidores() + numBaja );
		}
	}
	
	// Visualiza línea a línea usuario tabulador nº seguidores
	private static void visualizarUsuariosYSeguidores(UsuarioRedSocial[] usuarios ) {
		for (int i=0; i<usuarios.length; i++) {
			if (usuarios[i] != null) {
				System.out.println( usuarios[i].toString() );	
			}
		}
	}
	
	private static void ordenaUsuariosPorSeguidores( UsuarioRedSocial[] usuarios ) {
		for (int pasada=0; pasada<usuarios.length-1; pasada++) {
			for (int comp=0; comp<usuarios.length-1; comp++) {  // TODO mejorar que solo se hagan las comparaciones necesarias
				// boolean hayQueIntercambiar = usuarios[comp].numSeguidores < usuarios[comp+1].numSeguidores;
				boolean hayQueIntercambiar = usuarios[comp].tieneMenosSeguidoresQue( usuarios[comp+1] );
				if (hayQueIntercambiar) {
					UsuarioRedSocial auxNombre = usuarios[comp];
					usuarios[comp] = usuarios[comp+1];
					usuarios[comp+1] = auxNombre;
				}
			}
		}
	}
	
}
