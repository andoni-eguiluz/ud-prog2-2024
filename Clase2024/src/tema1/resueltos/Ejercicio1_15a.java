package tema1.resueltos;

import javax.swing.JOptionPane;

public class Ejercicio1_15a {
    public static void main(String[] args) {
        Bombilla b1 = new Bombilla();
        System.out.println( b1 );
        Bombilla b2 = new Bombilla( true, 100, "verde", 1000 );
        System.out.println( b2 );
        Bombilla b3 = new Bombilla( false, 50, null, 1000 );
        System.out.println( b3 );
        System.out.println( b3.getColor().toUpperCase() );
    }
}
