package tema2.ejemplos;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparacionYOrdenacion {
    public static void main(String[] args) {
        comoFuncionaElSort();
        comoImplementarComparable();
    }

    private static void comoImplementarComparable() {
        ArrayList<Persona> listaPersonas = new ArrayList<>( 
            Arrays.asList( 
                new Persona( "a", "a", "1A", "a@a" ),
                new Persona( "z", "z", "51B", "z@z" ),
                new Persona( "x", "z", "503Z", "z@z" ),
                new Persona( "m", "m", "4X", "m@m" ),
                new Persona( "e", "e", "2S", "e@e" )
            )
        );
        System.out.println( listaPersonas );
        listaPersonas.sort( null );  // Da igual hacerlo así
        Collections.sort( listaPersonas ); // que así
        System.out.println( listaPersonas );

        // ¿Y si quisiéramos ordenarlo de otra manera?
        Comparator<Persona> comparadorDNI = new ComparadorDNI();
        listaPersonas.sort( comparadorDNI );
        System.out.println( listaPersonas );
        Comparator<Persona> comparadorDNI2 = new ComparadorDNI2();
        listaPersonas.sort( comparadorDNI2 );
        System.out.println( listaPersonas );
    }

    private static void comoFuncionaElSort() {
        ArrayList<String> listaNombres = new ArrayList<>();
        listaNombres.add( "Andoni" );
        listaNombres.add( "Emilio" );
        listaNombres.add( "Ana" );
        listaNombres.add( "alas" );
        // Para meter varios a la vez
        listaNombres.addAll( Arrays.asList( new String[] {
            "Alazne", "Mertxe", "Luis"
        }));
        listaNombres.addAll( Arrays.asList( 
            "Manuel", "Imanol", "Clara"
        ));
        System.out.println( listaNombres );
        Collections.sort( listaNombres ); // Manera 1
        System.out.println( listaNombres );
        listaNombres.sort( null ); // Manera 2
        System.out.println( listaNombres );

        // Ordenemos puntos
        ArrayList<Point> listaPuntos = new ArrayList<>(
            Arrays.asList( new Point(1,2), new Point(-3,4), new Point(2,7) )
        );
        // Collections.sort( listaPuntos );  // No deja compilar ¿por qué?
        // listaPuntos.sort( null );  // Error de ejecución! ¿por qué?

    }
}
