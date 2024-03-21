package tema2.ejemplos;

import java.util.Comparator;

public class ComparadorDNI2 implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        int valor1 = 0;
        String letra1 = o1.getDni().substring( o1.getDni().length()-1 );
        if (Character.isLetter( letra1.charAt(0) )) {
            String resto1 = o1.getDni().substring( 0, o1.getDni().length()-1 );
            valor1 = Integer.parseInt( resto1 );
        } else {
            valor1 = Integer.parseInt( o1.getDni() );
        }
        int valor2 = 0;
        String letra2 = o2.getDni().substring( o2.getDni().length()-1 );
        if (Character.isLetter( letra2.charAt(0) )) {
            String resto2 = o2.getDni().substring( 0, o2.getDni().length()-1 );
            valor2 = Integer.parseInt( resto2 );
        } else {
            valor2 = Integer.parseInt( o2.getDni() );
        }
        System.out.println( "Comparando " + o1.getDni() + " con " + o2.getDni() + " dev " + (valor1-valor2) );
        return valor1-valor2;
    }
}
