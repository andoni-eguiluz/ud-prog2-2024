package tema3.resueltos.ej3_1_2;

import java.util.*;

public class Scores {

    // Static
    public static void main(String[] args) {
        Scores scores = new Scores();
        scores.addScore( "Luis", 7 );
        scores.addScore( "Luis", 13 );
        scores.addScore( "ainhoa", 5 );
        scores.addScore( "Marta", 3 );
        scores.addScore( "Oihane", 29 );
        scores.addUsuario( "luiS" );
        scores.addUsuario( "Mark" );
        System.out.println( scores.getUsuarios() );
        System.out.println( scores.mapaPunts );
        System.out.println( scores.getScores( "luis" ));
        System.out.println( scores.getScores( "mark" ));
        System.out.println( scores.getScores( "amaia" ));
        System.out.println( scores.getUsuariosFieles() );
    }

    // De objeto
    private Map<String,List<Integer>> mapaPunts;

    public Scores() {
        mapaPunts = new TreeMap<>();
    }

    /** Devuelve el conjunto de usuarios registrados con puntuaciones, en orden alfabético
     * @return  Conjunto de usuarios
     */
    public Set<String> getUsuarios() {
        return mapaPunts.keySet();
    }

    /** Añade un usuario con una nueva puntuación. Si el usuario ya existía se añade la puntuación 
     * a las que ya tuviera. Se considera el mismo usuario independientemente de la capitalización
     * de las letras.
     * @param nick  Usuario que puntúa. Se convierte a minúsculas siempre para almacenar su nombre 
     * en minúsculas
     * @param score Nueva puntuación de ese usuario
     */
    public void addScore( String nick, int score ) {
        nick = nick.toLowerCase();
        // if (mapaPunts.get(nick)!=null)
        if (mapaPunts.containsKey( nick )) {
            mapaPunts.get(nick).add( score );
        } else {
            ArrayList<Integer> lista = new ArrayList<>();
            mapaPunts.put( nick, lista );
            lista.add( score );
        }
    }

    /** Añade un usuario sin puntuaciones. Si ya existía, lo deja como estaba.
     * El nombre se convierte a minúsculas para su gestión.
     * @param nick  Nombre único del usuario
     */
    public void addUsuario( String nick ) {
        nick = nick.toLowerCase();
        if (!mapaPunts.containsKey(nick)) {
            mapaPunts.put( nick, new ArrayList<>() );
        }
    }

    /** Devuelve las puntuaciones de un usuario. Se considera convirtiendo el nombre a minúsculas.
     * @param nick  Nombre único del usuario
     * @return  Lista de puntuaciones en el orden en el que se han ido almacenando si el usuario existe, null en caso contrario
     */
    public List<Integer> getScores( String nick ) {
        return mapaPunts.get( nick.toLowerCase() );
        // if (mapaPunts.containsKey(nick.toLowerCase())) {
        //     return mapaPunts.get(nick.toLowerCase());
        // } else {
        //     return null;  // o return mapaPunts.get(nick.toLowerCase());
        // }
    }


    /** devuelve los usuarios ordenados por el número de partidas jugadas, de menor a mayor
     * @return  Usuarios ordenados por fidelidad creciente
     */
    public List<String> getUsuariosFieles() {
        ArrayList<String> listaU = new ArrayList<>();
        for (String usuario : mapaPunts.keySet()) {
            listaU.add( usuario );
        }
        // Método 1: clase externa. Pega: el acceso a datos es externo y hay que facilitarlo
        // Comparator<String> comp = new ComparadorFidelidad( this );
        // Método 2: clase interna - tiene acceso a nuestros atributos y métodos
        // Comparator<String> comp = new ComparadorFidelidad();
        // Método 3: clase interna anónima - lo mismo pero sin nombre
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int fidelidad1 = getScores(o1).size();
                int fidelidad2 = getScores(o2).size();
                return fidelidad1-fidelidad2;  // negativo si o1 menor fidelidad que o2, positivo si mayor, 0 si la misma
            }
        };
        listaU.sort( comp );
        return listaU;
    }


    // Clase interna
    private class ComparadorFidelidad implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int fidelidad1 = getScores(o1).size();
            int fidelidad2 = getScores(o2).size();
            return fidelidad1-fidelidad2;  // negativo si o1 menor fidelidad que o2, positivo si mayor, 0 si la misma
        }
    }
    

}
