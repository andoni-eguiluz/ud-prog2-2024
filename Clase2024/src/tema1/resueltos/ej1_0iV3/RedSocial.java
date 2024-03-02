package tema1.resueltos.ej1_0iV3;

import java.util.ArrayList;

public class RedSocial {
    private ArrayList<UsuarioRedSocial> usuariosRS;
    private String nombre;
    private String urlPrincipal;

    /** Crea una nueva red social, sin usuarios
     * @param nombre    Nombre de la RS
     * @param urlPrincipal  Dirección web
     */
    public RedSocial(String nombre, String urlPrincipal) {
        this.nombre = nombre;
        this.urlPrincipal = urlPrincipal;
        this.usuariosRS = new ArrayList<>();
    }

    /** Añade un nuevo usuario al final de los ya existentes
     * @param usuario   Usuario nuevo de la red social
     */
    public void anyadir( UsuarioRedSocial usuario ) {
        usuariosRS.add( usuario );
    }
    
    /** Visualiza línea a línea usuario tabulador nº seguidores
     */
    public void visualizarUsuariosYSeguidores() {
		for (int i=0; i<this.usuariosRS.size(); i++) {
			if (usuariosRS.get(i) != null) {
				System.out.println( usuariosRS.get(i).toString() );	
			}
		}
	}

    /** Ordena a los usuarios en la red social <br/>
     * en orden decreciente de seguidores
     */
	public void ordenaUsuariosPorSeguidores() {
		for (int pasada=0; pasada<usuariosRS.size()-1; pasada++) {
			for (int comp=0; comp<usuariosRS.size()-1; comp++) {  // TODO mejorar que solo se hagan las comparaciones necesarias
				// boolean hayQueIntercambiar = usuarios[comp].numSeguidores < usuarios[comp+1].numSeguidores;
				boolean hayQueIntercambiar = usuariosRS.get(comp).tieneMenosSeguidoresQue( usuariosRS.get(comp+1) );
				if (hayQueIntercambiar) {
					UsuarioRedSocial auxNombre = usuariosRS.get(comp);
					usuariosRS.set( comp, usuariosRS.get(comp+1) );
					usuariosRS.set( comp+1, auxNombre );
				}
			}
		}
	}

    /** Busca usuario en la red social
     * @param usuario   Usuario a buscar
     * @return  la primera posición del usuario en la red social (de 0 a n-1) o -1 si no está
     */
    public int buscar( UsuarioRedSocial usuario ) {
        return usuariosRS.indexOf( usuario );
    }

	/** Devuelve el tamaño de la red social
	 * @return	Número de usuarios actuales
	 */
    public int getNumUsuarios() {
        return usuariosRS.size();
    }

	/** Borra un usuario
	 * @param usuario	Usuario a borrar. Si no existe (comparando con equals), no se hace nada
	 */
	public void borrar( UsuarioRedSocial usuario ) {
		usuariosRS.remove( usuario );
	}	

	/** Devuelve un usuario
	 * @param indice	Posición del usuario a recuperar (de 0 a n-1)
	 * @return	Usuario situado en esa posición
	 */
	public UsuarioRedSocial get( int indice ) {
		return usuariosRS.get( indice );
	}
	
	@Override
	public String toString() {
		return usuariosRS.toString();
	}
	

}
