package tema1c.resueltos.survival;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Disparo extends ObjetoJuegoConColor{
    private double radio = 5;

    public Disparo(double x, double y, Color colorBorde, Color colorFondo, double radio) {
        super(x, y, colorBorde, colorFondo);
        this.setRadio( radio );
    }

    public double getRadio() {
        return radio;
    }

    /** Modifica el radio
     * @param radio Nuevo valor de radio que debe ser positivo. No se cambia si es negativo o cero.
     */
    public void setRadio(double radio) {
        if (radio <= 0) {
            return;
        } else {
            this.radio = radio;
        }
    }

    @Override
    public void dibujar(VentanaGrafica vent) {
        vent.dibujaCirculo( x, y, radio, 1, colorBorde, colorFondo );
    }

}
