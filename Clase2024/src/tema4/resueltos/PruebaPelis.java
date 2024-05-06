package tema4.resueltos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Prueba con ficheros de pelis
public class PruebaPelis {
    public static void main(String[] args) {
        ArrayList<Peli> l = new ArrayList<>();
        l.add( new Peli( "Oppenheimer", 2023 ) );
        l.add( new Peli( "Barbie", 2023 ) );
        l.add( new Peli( "Todo a la vez en todas partes", 2022 ) );
        l.add( new Peli( "CODA", 2021 ) );
        System.out.println( l );
        guardarFicheroObjetos( l, "pelis.dat" );
        System.out.println( l );
        ArrayList<Peli> l2 = leerFicheroObjetos( "pelis.dat" );
        System.out.println( l2 );

        // Intentarlo con ficheros de texto
        guardarFicheroTexto( l, "pelis.txt" );
        ArrayList<Peli> l3 = leerFicheroTexto( "pelis.txt" );
        System.out.println( l3 );
    }

    // escribir a disco
    private static void guardarFicheroObjetos( ArrayList<Peli> l, String nombre ) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( nombre ) );
            oos.writeObject( l );
            oos.close();
        } catch (IOException e) {
            System.out.println( "Error en escritura de fichero: " + e.getMessage() );
            e.printStackTrace();
        }
    }

    // cargar desde disco a memoria
    /** Lee una lista de pelis desde fichero binario
     * @param nombre    Nombre del fichero o ruta completa
     * @return  Lista de pelis leídas, null si hay error de lectura
     */
    private static ArrayList<Peli> leerFicheroObjetos( String nombre ) {
        try {
            ObjectInputStream ois = new ObjectInputStream( new FileInputStream( nombre ) );
            ArrayList<Peli> l = (ArrayList<Peli>) ois.readObject();
            ois.close();
            return l;
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            return null;
        }
    }

    // Guardar la lista a fichero, si hay cualquier error saca un mensaje a consola
    private static void guardarFicheroTexto( ArrayList<Peli> l, String nombre ) {
        // TODO PrintStream
        try {
            PrintStream ps = new PrintStream( nombre );  // new FileOutputStream( nombre )
            // ps.println( l );
            for (Peli peli : l) {
                ps.println( peli.aLineaCSV() );
            }
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println( "Error al escribir fichero" );
            e.printStackTrace();
        }

    }

    // Lee fichero y lo devuelve, si hay error completo de lectura se devuelve null y se saca mensaje consola
    private static ArrayList<Peli> leerFicheroTexto( String nombre ) {
        // TODO Scanner
        try {
            ArrayList<Peli> ret = new ArrayList<>();
            Scanner scanner = new Scanner( new FileInputStream( nombre ) );
            int numLinea = 1;
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                try {
                    Peli peliLeida = Peli.creaPeliDesdeLineaCSV( linea );
                    ret.add( peliLeida );
                } catch (NumberFormatException | NullPointerException | NoSuchElementException e) {
                    System.out.println( "Línea de fichero errónea: " + numLinea + ":" + linea );
                }
                numLinea++;
            }
            scanner.close();
            return ret;
        } catch (FileNotFoundException e) {
            System.out.println( "Error en lectura" );
            return null;
        }
    }

}
