package tema1c.ejemplos;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Imagen extends Figura implements Rotable {
    private int anchura;
    private int altura;
    private double rotacion;

    public Imagen(int xCentro, int yCentro, int anchura, int altura) {
        super(xCentro, yCentro, 0, null);
        this.anchura = anchura;
        this.altura = altura;
    }
    
    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public void dibujar( VentanaGrafica vent ) {
        vent.dibujaImagen( "logo-chatgpt.png", xCentro, yCentro, anchura, altura, 1, rotacion, 1 );
    }

    /** Cambia la rotación 
     * @param incRotacion   Incremento/decremento de rotación (en radianes)
     */
    public void rotar( double incRotacion ) {
        rotacion += incRotacion;
    }

}
