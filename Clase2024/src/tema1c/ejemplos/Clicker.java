package tema1c.ejemplos;

import java.awt.Color;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Clicker {
    public static void main(String[] args) {
        ArrayList<Circulo> listaCircs = new ArrayList<>();
        Circulo circ1 = new Circulo(80,90,35,2,Color.GREEN);
        listaCircs.add( circ1 );
        listaCircs.add( new Circulo( 200, 220, 45, 3, Color.BLUE ) );
        listaCircs.add( new Circulo( 420, 350, 90, 5, Color.RED ) );

        ArrayList<Cuadrado> listaCuadrados = new ArrayList<>();
        listaCuadrados.add( new Cuadrado( 150, 120, 2, Color.CYAN, 25 ) );
        listaCuadrados.add( new Cuadrado( 450, 180, 1, Color.BLACK, 25 ) );
        listaCuadrados.add( new Cuadrado( 350, 240, 3, new Color(123, 255, 0), 45 ) );

        ArrayList<Figura> listaFiguras = new ArrayList<>();
        listaFiguras.addAll( listaCircs );
        listaFiguras.addAll( listaCuadrados );
        listaFiguras.add( new Imagen( 300, 280, 30, 30 ) );
        listaFiguras.add( new Imagen( 120, 340, 30, 30 ) );

        VentanaGrafica vent = new VentanaGrafica( 600, 400, "Prueba" );
        //    vent.getJFrame().setLocation( 2000, 50 );  // No hacer esto más que si tienes segunda pantalla

        for (int i=0; i<200; i++) {
            vent.borra();
            for (Figura f : listaFiguras) {
                f.dibujar( vent );
                f.mover( 1, 0 );
                // Podríamos hacer if por cada clase...
                // if (f instanceof Imagen) {
                //     Imagen imagen = (Imagen) f;
                //     imagen.rotar(0.1);
                // }
                // if (f instanceof Cuadrado ) {
                //     Cuadrado cuadrado = (Cuadrado) f;
                //     cuadrado.rotar(0.1);
                // }
                // Pero con interfaces nos vale con un if:
                if (f instanceof Rotable) {
                    Rotable rot = (Rotable) f;
                    rot.rotar(0.1);
                }
            }
            vent.espera( 40 );
        }
    }

}
