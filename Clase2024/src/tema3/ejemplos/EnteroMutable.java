package tema3.ejemplos;

public class EnteroMutable {
    private int dato;

    public EnteroMutable(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    /** Incrementa el valor entero en una unidad
     */
    public void inc() {
        dato++;
    }

    @Override
    public String toString() {
        return "" + dato;
    }
    
}
