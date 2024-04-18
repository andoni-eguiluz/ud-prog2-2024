package tema3.resueltos.ej3_1_2;

import java.util.HashMap;
import java.util.Set;

public class HighScore {

    /** Main de prueba de la clase
     * @param args  No utilizado
     */
    public static void main(String[] args) {
        HighScore hs = new HighScore();
        hs.addUsuario( "a" );
        hs.addHighScore( "a", 7 );
        hs.addHighScore( "b", 18 );
        hs.addHighScore( "x", 23 );
        hs.addHighScore( "a", 5 );
        hs.addHighScore( "b", 35 );
        hs.addUsuario( "f" );
        hs.addUsuario( "a" );
        System.out.println( hs.getHighScore( "a" ) );
        System.out.println( hs.getHighScore( "b" ) );
        System.out.println( hs.mapaHighScores );
        System.out.println( hs.getUsuarios() );
    }

    private HashMap<String,Integer> mapaHighScores; // = new HM...

    public HighScore() {
        mapaHighScores = new HashMap<>();
    }

    /** Añade una nueva puntuación al registro de puntuaciones altas. Si la actual es mayor que
     * la existente, se actualiza y si no se deja como estaba
     * @param nick  Identificador único del usuario
     * @param score Nueva puntuación de ese usuario
     */
    public void addHighScore( String nick, int score ) {
        if (!mapaHighScores.containsKey(nick)) {
            mapaHighScores.put(nick,score);
        } else {
            int puntuacionActual = mapaHighScores.get(nick);
            // if (puntuacionActual >= score) {  // No actualizar
            //     // Nada
            // } else {  // Actualizar
            //     mapaHighScores.replace( nick, score );
            // }
            if (puntuacionActual < score) {
                mapaHighScores.replace( nick, score );
            }
        }
    }

    /** Añadir un jugador con puntuación -1
     * Si el jugador ya existía, se mantiene la puntuación que tuviera
     * @param nick  Nick único del jugador
     */
    public void addUsuario( String nick ) {
        if (!mapaHighScores.containsKey(nick)) {
            mapaHighScores.put( nick, -1 );
        }
    }


    /** Devuelve la puntuación del usuario
     * @param nick  Nick del jugador
     * @return  Puntuación que tiene, -1 si no existe
     */
    public int getHighScore( String nick )  {
        if (mapaHighScores.containsKey(nick)) {
            return mapaHighScores.get( nick );
        } else {
            return -1;
        }
    }

    /** Devuelve el conjunto de usuarios registrados en el sistema de puntuación
     * @return  conjunto de todos los usuarios
     */
    Set<String> getUsuarios() {
        return mapaHighScores.keySet();
    } 

}
