package tema1.resueltos;

public class Bombilla {
    private boolean estado = false; // si está apagada o encendida (boolean). Por defecto: false
    private int potencia; // en vatios (int)
    private String color; // color de la bombilla (String)
    private float horas = 10; // horas que puede estar encendida (float). Por defecto: 10
    
    /** Crea una bombilla de color "blanco" de 100W, apagada, con 10 horas estimadas de vida
    */
    public Bombilla() {
        color = "blanco";
    }
    
    /** Crea una nueva bombilla
     * @param estado    true para encendida, false para apagada
     * @param potencia  Potencia en watios (debe ser positivo)
     * @param color Color (por ejemplo "blanco"). NO DEBE SER null
     * @param horas Nº de horas de vida estimada (debe ser positivo)
     */
    public Bombilla(boolean estado, int potencia, String color, float horas) {
        this.estado = estado;
        this.potencia = potencia;
        this.setColor( color );
        this.horas = horas;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getPotencia() {
        return potencia;
    }

    /** Visualiza en consola la potencia de la bombilla
     * @return  Devuelve el valor de potencia de la bombilla
     */
    public int verPotencia() {
        System.out.println( potencia + "W" );
        return getPotencia();
    }

    public String getColor() {
        return color;
    }

    /** Visualiza en consola el color de la bombilla
     */
    public void verColor() {
        System.out.println( color );
    }

    public float getHoras() {
        return horas;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /** Modifica el estado de la bombilla, pasa a estar encendida
     */
    public void encender() {
        estado = true;
    }

    /** Modifica el estado de la bombilla, pasa a estar apagada
     */
    public void apagar() {
        estado = false;
    }

    /** Modifica la potencia de la bombilla
     * @param potencia  Número de watios (debe ser mayor que cero)
     */
    public void cambiaPotencia(int potencia) {
        if (potencia<=0) {
            System.out.println( "Error: las potencia en watios debe ser >= 0");
            return;
        }
        this.potencia = potencia;
    }

    /** Modifica el color de la bombilla
     * @param color Nuevo color. No debe ser null. Si es null, se inicializa a ""
     */
    public void setColor(String color) {
        if (color==null) {
            this.color = "";
            System.out.println( "Error: se ha intentado inicializar color a null" );
        } else {
            this.color = color;
        }
    }

    /** Cambia el color. Si la bombilla está encendida la apaga.
     * @param color Nuevo color de la bombilla
     */
    public void cambiaColor(String color) {
        setColor(color);
        if (estado) {
            estado = false;
        }
    }

    /** Modifica las horas de vida estimada de la bombilla
     * @param horas  Número de horas (debe ser mayor que cero)
     */
    public void setHoras(float horas) {
        if (horas<=0) {
            System.out.println( "Error: las horas estimadas deben ser >= 0");
            return;
        }
        this.horas = horas;
    }

    @Override
    public String toString() {
        return potencia + "W - " + color + (estado ? " apagada " : " encendida ") 
            + horas + " horas estimadas de vida";
    }

}
