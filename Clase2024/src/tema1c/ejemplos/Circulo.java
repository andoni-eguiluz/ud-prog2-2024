package tema1c.ejemplos;

import java.awt.Color;
import java.util.Random;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Circulo extends Figura implements Colorizable, Automovible {

    private static Random random = new Random();
    // Automovible


    // private int xCentro;
    // private int yCentro;
    private int radio;
    // private int grosor;
    // private Color color;

    private VentanaGrafica ventana; // Automovible

    private int incRojo = +5; // Colorizable

    public Circulo(int xCentro, int yCentro, int radio, int grosor, Color color) {
        super( xCentro, yCentro, grosor, color );
        // this.xCentro = xCentro;
        // this.yCentro = yCentro;
        this.setRadio( radio );
        // this.grosor = grosor;
        // this.color = color;
    }

    public Circulo(int xCentro, int yCentro, int radio, int grosor, Color color, VentanaGrafica vent ) {
        // super( xCentro, yCentro, grosor, color );
        // this.setRadio( radio );
        // this.ventana = vent;
        this( xCentro, yCentro, radio, grosor, color );
        this.ventana = vent;
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

    @Override
    public void animaColor() {
        int nuevoRojo = this.color.getRed() + incRojo;
        if (nuevoRojo < 0 || nuevoRojo > 255) {
            incRojo = -incRojo;
            nuevoRojo += incRojo;
        }
        color = new Color( nuevoRojo, color.getGreen(), color.getBlue() );
    }

    // Automovible    

    @Override
    public void mover( double tiempo ) {
        xCentro += random.nextInt(11) - 5;
        yCentro += random.nextInt(11) - 5;
        if (ventana!=null) {
            if (xCentro-radio<0) {
                xCentro = radio;
            }
            if (yCentro-radio<0) {
                yCentro = radio;
            }
            if (xCentro+radio>ventana.getAnchura()) {
                xCentro = ventana.getAnchura()-radio;
            }
            if (yCentro+radio>ventana.getAltura()) {
                yCentro = ventana.getAltura()-radio;
            }
        }
    }   

}
