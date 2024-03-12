package tema1c.ejemplos;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Imagen extends Figura implements Rotable, Automovible {
    private int anchura;
    private int altura;
    private double rotacion;

    // Automovible
    private int velX;
    private int velY;

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

    /** Cambia la velocidad del objeto
     * @param velX  Velocidad horizontal en píxels por segundo
     * @param velY  Velocidad vertical en píxeles por segundo
     */
    public void setVelocidad( int velX, int velY ) {
        this.velX = velX;
        this.velY = velY;
    }

    @Override
    public void mover(double tiempoMsgs) {
        xCentro += velX * tiempoMsgs/1000.0;
        yCentro += velY * tiempoMsgs/1000.0;
    }

}
