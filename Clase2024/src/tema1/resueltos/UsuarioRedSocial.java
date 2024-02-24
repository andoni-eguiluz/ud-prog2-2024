package tema1.resueltos;

public class UsuarioRedSocial {
    public String nombre = "";
    public int numSeguidores = 0; // da igual = 0 que nada

    public UsuarioRedSocial( String nombre, int numSeguidores ) {
        this.nombre = nombre;
        this.numSeguidores = numSeguidores;
    }

    public UsuarioRedSocial( String nombre ) {
        this.nombre = nombre;
        this.numSeguidores = 0;
    }

// No se podría - la sobrecarga debe diferenciar la signatura
//    public UsuarioRedSocial( String url ) {
//    }

    public boolean tieneMenosSeguidoresQue( UsuarioRedSocial u2 ) {
        return this.numSeguidores < u2.numSeguidores;
    }

}
