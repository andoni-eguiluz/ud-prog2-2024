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
//            vent.getJFrame().setLocation( 2000, 50 );  // No hacer esto más que si tienes segunda pantalla
//        vent.dibujaCirculo( 100, 100, 50, 1 );
//        vent.dibujaCirculo( circ1.getxCentro(), circ1.getyCentro(), circ1.getRadio(), circ1.getGrosor(), circ1.getColor() );
        // circ1.dibujar( vent );


        for (int i=0; i<200; i++) {
            vent.borra();
            // for (Circulo c : listaCircs) {
            //     c.dibujar( vent );
            //     c.mover( 1, 0 );
            // }
            // for (Cuadrado cua : listaCuadrados) {
            //     cua.dibujar( vent );
            //     cua.mover( 1, 0 );
            // }
            for (Figura f : listaFiguras) {
                f.dibujar( vent );
                f.mover( 1, 0 );
                // TODO ¿Cómo rotar la imagen?
            }
            vent.espera( 40 );
        }
        // Y cómo funciona el polimorfismo de datos? Veamos
        Figura f = new Figura( 100, 100, 1, Color.WHITE );
        System.out.println( f );
        System.out.println( circ1 );
        Figura f2 = circ1;  // Sí se puede (de arriba abajo en la herencia)
        Figura f3 = new Cuadrado( 50, 50, 1, null, 17 );  // También
        // NO Cuadrado c3 = f2;   No de abajo arriba
        // NO Cuadrado c3 = circ1;  No en lateral
    }

}
