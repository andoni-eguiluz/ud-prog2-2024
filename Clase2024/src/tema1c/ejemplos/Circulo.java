package tema1c.ejemplos;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Circulo extends Figura {
    // private int xCentro;
    // private int yCentro;
    private int radio;
    // private int grosor;
    // private Color color;

    public Circulo(int xCentro, int yCentro, int radio, int grosor, Color color) {
        super( xCentro, yCentro, grosor, color );
        // this.xCentro = xCentro;
        // this.yCentro = yCentro;
        this.setRadio( radio );
        // this.grosor = grosor;
        // this.color = color;
    }

    // public int getxCentro() {
    //     return xCentro;
    // }

    // public void setxCentro(int xCentro) {
    //     this.xCentro = xCentro;
    // }

    // public int getyCentro() {
    //     return yCentro;
    // }

    // public void setyCentro(int yCentro) {
    //     this.yCentro = yCentro;
    // }

    public int getRadio() {
        return radio;
    }

    /** Modifica el radio
     * @param radio Nuevo radio. Si fuera 0 o negativo, se asigna radio 10
     */
    public void setRadio(int radio) {
        if (radio<1) {
            radio = 10;
            return;
        }
        this.radio = radio;
    }

    // public int getGrosor() {
    //     return grosor;
    // }

    // public void setGrosor(int grosor) {
    //     this.grosor = grosor;
    // }

    // public Color getColor() {
    //     return color;
    // }

    // public void setColor(Color color) {
    //     this.color = color;
    // }

    @Override
    public String toString() {
        return "Circulo [xCentro=" + xCentro + ", yCentro=" + yCentro + ", radio=" + radio + ", grosor=" + grosor
                + ", color=" + color + "]";
    }

    /** Dibuja el círculo en ventana
     * @param v Ventana en la que dibujarlo
     */
    public void dibujar( VentanaGrafica v ) {
        v.dibujaCirculo( getxCentro(), getyCentro(), getRadio(), getGrosor(), getColor() );
    }    

}
