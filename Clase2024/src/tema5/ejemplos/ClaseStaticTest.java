package tema5.ejemplos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClaseStaticTest {
    @Test
    public void testMcd() {
        // System.out.println( ClaseStatic.mcd( 25, 5) );   Partíamos de esto... pero ahora hacemos:
        assertEquals( 5, ClaseStatic.mcd( 25, 5 ) );
        assertEquals( 5, ClaseStatic.mcd( 5, 25 ) );
        assertEquals( 25, ClaseStatic.mcd( 25, 0 ) );
        assertEquals( 25, ClaseStatic.mcd( 0, 25 ) );
        assertEquals( 1, ClaseStatic.mcd( 0, 0 ) );
        assertEquals( 7, ClaseStatic.mcd( 14, -21 ) );
        assertEquals( 7, ClaseStatic.mcd( -14, 21 ) );
        assertEquals( 100000000, ClaseStatic.mcd( 100000000, 200000000 ) );
        assertEquals( 1, ClaseStatic.mcd( 17, 23 ) );
        assertEquals( 7, ClaseStatic.mcd( -14, -21 ) );
        assertEquals( 15, ClaseStatic.mcd( -15, 0 ) );
        assertEquals( 21, ClaseStatic.mcd( 0, -21 ) );
    }

    // Cómo se haría el test de otro método? Con otro método de test (uno al menos por cada método)
    @Test
    public void testLoQueSea() {
        System.out.println( ClaseStatic.mcd( 25, 6 ) );
        // Ojo que esto parece que prueba algo... pero no prueba nada. El test funciona cuando la ejecución acaba
        // por eso hay que ponerla a prueba con ASSERTS!!!
    }

}
