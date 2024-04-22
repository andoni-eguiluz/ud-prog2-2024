package tema3.resueltos.ej3_1_2;

import java.util.Comparator;

public class ComparadorFidelidad implements Comparator<String> {

    private Scores scores;
    public ComparadorFidelidad( Scores scores ) {
        this.scores = scores;
    }

    @Override
    public int compare(String o1, String o2) {
        int fidelidad1 = scores.getScores(o1).size();
        int fidelidad2 = scores.getScores(o2).size();
        return fidelidad1-fidelidad2;  // negativo si o1 menor fidelidad que o2, positivo si mayor, 0 si la misma
    }
}
