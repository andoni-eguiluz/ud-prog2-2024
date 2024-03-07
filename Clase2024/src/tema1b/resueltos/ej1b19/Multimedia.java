package tema1b.resueltos.ej1b19;

import javax.swing.JOptionPane;

public class Multimedia {
    private String nombre;

    public Multimedia(String nombre) {
        this.setNombre( nombre );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre==null) {
            nombre = "";
            return;
        }
        this.nombre = nombre;        
    }

    public void pedir() {
        setNombre( JOptionPane.showInputDialog( "Introduce nombre:", nombre ) );
    }

}
