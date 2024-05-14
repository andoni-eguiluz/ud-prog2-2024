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

    }

    @Test
    public void testEquals() {

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
        assertEquals( new Fraccion(6,2) ,f3 );
        assertEquals( 3.0 ,f3.calcular(), 0.000000001 );
    }

    @Test
    public void testToString() {

    }

    @Test
    public void testToStringConValor() {

    }
}
