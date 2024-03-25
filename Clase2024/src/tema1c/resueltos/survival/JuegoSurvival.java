package tema1c.resueltos.survival;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class JuegoSurvival {
    private static final int ANCHO_VENTANA = 800;
    private static final int ALTO_VENTANA = 600;

    private static Random random = new Random();

    private VentanaGrafica ventana;
    private ArrayList<ObjetoJuego> listaObjetos;

    public JuegoSurvival() {
        ventana = new VentanaGrafica( ANCHO_VENTANA, ALTO_VENTANA, "Juego survival" );
        listaObjetos = new ArrayList<>();
    }

    public void init() {
        listaObjetos.add( new Disparo(random.nextInt(ANCHO_VENTANA), random.nextInt(ALTO_VENTANA),
            Color.BLACK, Color.CYAN, 7 ) );
        listaObjetos.add( new Disparo(random.nextInt(ANCHO_VENTANA), random.nextInt(ALTO_VENTANA),
            Color.BLACK, Color.CYAN, 7 ) );
    }

    public void jugar() {
        int cont = 0;
        while (!ventana.estaCerrada()) {
            for (ObjetoJuego oj : listaObjetos) {
                oj.dibujar( ventana );
            }
            cont++;
            System.out.println( cont );
        }
    }

}
