package tema4.resueltos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    private static void guardarFicheroTexto( ArrayList<Peli> l, String nombre ) {
        // TODO PrintStream
    }

    private static ArrayList<Peli> leerFicheroTexto( String nombre ) {
        // TODO Scanner
        return null;
    }

}
