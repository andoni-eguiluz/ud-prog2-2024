package tema1.resueltos;

public class Ejercicio1_0iConObjetos {
	//	Crea dos arrays, uno con los nombres de 4 o 5 usuarios de cualquier red social que uses,
	//	y otro con sus seguidores. Realiza un programa que muestre por consola esos usuarios 
	//  primero sin ordenar y luego ordenados por número de seguidores 
	//	(de mayor a menor).

	public static void main(String[] args) {
		// String[] usuarios = { "@sama", "@JeffBezos", "@BillGates", "@elonmusk" };
		// int[] seguidores = { 1300, 61000, 62000, 128900 };
		UsuarioRedSocial[] usuariosRS = new UsuarioRedSocial[4];
		// Primera versión: con constructor por defecto
		// usuariosRS[0] = new UsuarioRedSocial();
		// usuariosRS[0].nombre = "@sams";
		// usuariosRS[0].numSeguidores = 1300;
		// usuariosRS[1] = new UsuarioRedSocial();
		// usuariosRS[1].nombre = "@JeffBezos";
		// usuariosRS[1].numSeguidores = 61000;
		// usuariosRS[2] = new UsuarioRedSocial();
		// usuariosRS[2].nombre = "@BillGates";
		// usuariosRS[2].numSeguidores = 62000;
		// usuariosRS[3] = new UsuarioRedSocial();
		// usuariosRS[3].nombre = "@elonmusk";
		// usuariosRS[3].numSeguidores = 128900;
		// Segunda versión: con constructor con parámetros (mucho más cómodo):
		usuariosRS[0] = new UsuarioRedSocial( "@sams", 1300 );
		usuariosRS[1] = new UsuarioRedSocial( "@JeffBezos", 61000 );
		usuariosRS[2] = new UsuarioRedSocial( "@BillGates", 62000 );
		usuariosRS[3] = new UsuarioRedSocial( "@elonmusk", 128900 );
		visualizarUsuariosYSeguidores( usuariosRS );
		ordenaUsuariosPorSeguidores( usuariosRS );
		visualizarUsuariosYSeguidores( usuariosRS );

		// Prueba
		UsuarioRedSocial u = new UsuarioRedSocial("Andoni");
		// Baja de usuarios
		bajaSeguidores( -2500, usuariosRS );
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
