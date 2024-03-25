package tema1c.resueltos.survival;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public abstract class ObjetoJuego {  // extends Object
    protected double x;
    protected double y;

    public ObjetoJuego(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public abstract void dibujar( VentanaGrafica vent );

    /** Cambia la posición del objeto
     * @param x Nueva x
     * @param y Nueva y
     */
    public void moverA( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    /** Calcula la distancia a otro objeto
     * @param o2    Segundo objeto
     * @return  Devuelve los píxeles de distancia lineal entre los centros de this y o2
     */
    public double distanciaA( ObjetoJuego o2 ) {
        double difX = x - o2.x;
        double difY = y - o2.y;
        return Math.sqrt( difX*difX + difY*difY );
    }

    /** Comprueba si el objeto está o no dentro de la ventana
     * @param vent  Ventana a comprobar
     * @return  true si el CENTRO del objeto está dentro de la ventana, false en caso contrario
     */
    public boolean estaDentroDeVentana( VentanaGrafica vent ) {
        return x >= 0 && x < vent.getAnchura() && y >= 0 && y < vent.getAltura();
    }
    
}
