package tema1b.ejemplos;

import java.awt.Color;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class EjemploFiguras {
    public static void main(String[] args) {
        ArrayList<Circulo> listaCircs = new ArrayList<>();
        Circulo circ1 = new Circulo(80,90,35,2,Color.GREEN);
        listaCircs.add( circ1 );
        listaCircs.add( new Circulo( 200, 220, 45, 3, Color.BLUE ) );
        VentanaGrafica vent = new VentanaGrafica( 600, 400, "Prueba" );
//        vent.dibujaCirculo( 100, 100, 50, 1 );
//        vent.dibujaCirculo( circ1.getxCentro(), circ1.getyCentro(), circ1.getRadio(), circ1.getGrosor(), circ1.getColor() );
        // circ1.dibujar( vent );
        for (int i=0; i<20; i++) {
            for (Circulo c : listaCircs) {
                c.dibujar( vent );
                c.mover( 3, 0 );
            }
            vent.espera( 100 );
        }
        System.out.println( circ1 );
    }
}
