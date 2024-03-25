package tema1c.resueltos.survival;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public abstract class ObjetoJuegoConColor extends ObjetoJuego {
    protected Color colorBorde;
    protected Color colorFondo;

    public ObjetoJuegoConColor(double x, double y, Color colorBorde, Color colorFondo) {
        super(x, y);
        this.colorBorde = colorBorde;
        this.colorFondo = colorFondo;
    }

    public Color getColorBorde() {
        return colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }
    

}
