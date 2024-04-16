package tema3.ejemplos;

public class Jugador implements Comparable<Jugador> {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Jugador) {
            Jugador j = (Jugador) obj;
            return nombre.equals( j.nombre );
        }
        return false;
    }

    @Override
    public int compareTo(Jugador o) {
        return -o.nombre.compareTo( this.nombre );
    }
}
