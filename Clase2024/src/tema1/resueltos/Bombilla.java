package tema1.resueltos;

public class Bombilla {
    private boolean estado = false; // si está apagada o encendida (boolean). Por defecto: false
    private int potencia; // en vatios (int)
    private String color; // color de la bombilla (String)
    private float horas = 10; // horas que puede estar encendida (float). Por defecto: 10
    
    public Bombilla() {

    }


    
    public Bombilla(boolean estado, int potencia, String color, float horas) {
        this.estado = estado;
        this.potencia = potencia;
        this.color = color;
        this.horas = horas;
    }



    public boolean isEstado() {
        return estado;
    }



    public int getPotencia() {
        return potencia;
    }



    public String getColor() {
        return color;
    }



    public float getHoras() {
        return horas;
    }

    


    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return estado ? "apagada" : "encendida";
    }
}
