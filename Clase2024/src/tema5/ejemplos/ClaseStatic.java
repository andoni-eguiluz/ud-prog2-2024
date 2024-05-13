package tema5.ejemplos;

public class ClaseStatic {

    /** Devuelve el máximo común divisor de dos números positivos.
     * Si alguno es cero, el otro es el MCD
     * Si ambos son cero, el MCD es 1
     * @param num1  Primer número
     * @param num2  Segundo
     * @return  Devuelve número mayor que divida con resto cero a ambos
     */
    public static int mcd( int num1, int num2 ) {
        if (num1==0) {
            if (num2==0) {
                return 1;
            }
            return Math.abs(num2);
        }
        if (num2==0) {
            return Math.abs(num1);
        }
        int mayor = Math.abs( Math.max( num1, num2 ) );
        int menor = Math.abs( Math.min( num1, num2 ) );
        do {
            int resto = mayor % menor;
            if (resto == 0) {
                return menor;
            }
            mayor = menor;
            menor = resto;
        } while (true);
    }

    /** Método de prueba
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( ClaseStatic.mcd( 25, 5) );
        System.out.println( ClaseStatic.mcd( 25, 15 ) );
    }

}
