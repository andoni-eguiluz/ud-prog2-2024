package tema5.ejemplos;

import static org.junit.Assert.*;
import org.junit.Test;

public class FraccionTest {
    @Test
    public void testFraccion() {
        Fraccion f1 = new Fraccion( 2, 4 );
        assertEquals( 2, f1.num );
        assertEquals( 4, f1.den );
        assertEquals( 2, f1.getNum() );
        assertEquals( 4, f1.getDen() );
        Fraccion f2 = new Fraccion( 0, 5 );
        assertEquals( 0, f2.getNum() );
        assertEquals( 5, f2.getDen() );
        // TODO denominador 0 ?
    }
   
    @Test
    public void testFraccionExc() {
        int num = 5;
        int den = 0;
        // assertNotEquals( 0, den );  Ningún sentido
        try {
            new Fraccion( num, den );
            // aquí incorrecto
            fail( "ArithmeticException no lanzada por denominador 0" );
        } catch (ArithmeticException e) {
            // allí correcto
        }
    }

    @Test
    public void testCalcular() {
        Fraccion f = new Fraccion( 3, 1 );
        assertEquals( 3.0, f.calcular(), 0.00000000001 );
        assertEquals( "Fallo en prueba de 3/2", 1.5, (new Fraccion( 3, 2 )).calcular(), 0.0000000001 );
        assertEquals( 0.0, (new Fraccion( 0, 5 )).calcular(), 0.0000000001 );
        assertEquals( -1.333333333333333333333333, (new Fraccion( -4, 3 )).calcular(), 0.0000000001 );
        assertEquals( -4.0/3.0, (new Fraccion( -4, 3 )).calcular(), 0.0000000001 );
        assertEquals( 1.2, (new Fraccion( -6, -5 )).calcular(), 0.0000000001 );
    }

    @Test
    public void testCompareTo() {

    }

    @Test
    public void testDivide() {
        Fraccion f1 = new Fraccion( 1, 2 );
        Fraccion f2 = new Fraccion( 0, 5 );
        try {
            Fraccion.divide( f1, f2 );
            fail( "División por cero" );
        } catch (ArithmeticException e) {
        }
        try {
            Fraccion res = Fraccion.divide( f2, f1 );
            assertEquals( 0, res.getNum() );
            assertEquals( new Fraccion(0,1), res );
        } catch (ArithmeticException e) {
            fail( "No debería haber división por cero" );
        }
    }

    @Test
    public void testEquals() {
        Fraccion f1 = new Fraccion( -1, 5 );
        Fraccion f2 = new Fraccion( 2, -10 );
        assertEquals( f1, f2 );
    }

    @Test
    public void testHashCode() {

    }

    @Test
    public void testMultiplica() {

    }

    @Test
    public void testResta() {

    }

    @Test
    public void testSimplifica() {

    }

    @Test
    public void testSuma() {
        Fraccion f1 = new Fraccion( 1, 2 );
        Fraccion f2 = new Fraccion( 5, 2 );
        Fraccion f3 = Fraccion.suma( f1, f2 );
        // assertEquals( new Fraccion(6,2) ,f3 );
        Fraccion f3s = f3.simplifica();
        Fraccion res = (new Fraccion(6,2)).simplifica();
        assertEquals( res, f3s );
        assertEquals( 3.0 ,f3.calcular(), 0.000000001 );

        // TODO
        // Qué más sumas habría que probar?
        // 1/5 + 0/2
        // 0/2 + 1/5
        // 5/2 + 1/2
        // -1/5 + 3/8
        // 3/8 + -1/5

    }

    @Test
    public void testSumaExcepciones() {
        Fraccion f1 = new Fraccion( 1, 3 );
        try {
            Fraccion res = Fraccion.suma( f1, null );
            fail();
        } catch (NullPointerException e) {
            // ok
        }
        try {
            Fraccion res = Fraccion.suma( null, f1 );
            fail();
        } catch (NullPointerException e) {
            // ok
        }
        try {
            Fraccion res = Fraccion.suma( null, null );
            fail();
        } catch (NullPointerException e) {
            // ok
        }
    }

    @Test
    public void testToString() {

    }

    @Test
    public void testToStringConValor() {

    }
}
