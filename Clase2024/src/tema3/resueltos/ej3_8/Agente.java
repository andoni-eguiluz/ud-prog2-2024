package tema3.resueltos.ej3_8;

public class Agente implements Comparable<Agente> {
    private String nombre;
    private String dni;

    public Agente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + "-" + dni;
    }

    @Override
    public int compareTo(Agente o) {
        int comp = nombre.compareTo( o.nombre );
        if (comp==0) {
            comp = dni.compareTo( o.dni );
        }
        return comp;
    }
}
