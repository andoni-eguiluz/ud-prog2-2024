package tema1b.resueltos.ej1b19;

import javax.swing.JOptionPane;

public class Cancion extends Multimedia {
    private String cantante;

    public Cancion(String nombre, String cantante) {
        super(nombre);
        this.cantante = cantante;
    }

    public String getCantante() {
        return cantante;
    }

    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    @Override
    public void pedir() {
        // setNombre( JOptionPane.showInputDialog( "Introduce nombre:", getNombre() ) );
        super.pedir();
        cantante = JOptionPane.showInputDialog( "Introduce cantante:", cantante )
    }

}
