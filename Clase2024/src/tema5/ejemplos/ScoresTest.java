package tema5.ejemplos;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tema1c.interfacesAvanzados.A;

public class ScoresTest {
    @Test
    public void testGetUsuariosFieles() {
        Scores scores = new Scores();
        scores.addScore( "Luis", 7 );
        scores.addScore( "Luis", 13 );
        scores.addScore( "ainhoa", 5 );
        scores.addScore( "Marta", 3 );
        scores.addScore( "Oihane", 29 );
        scores.addUsuario( "luiS" );
        scores.addUsuario( "Mark" );
        // System.out.println( scores.getUsuariosFieles() );    
        List<String> l = scores.getUsuariosFieles();
        assertEquals( 5, l.size() );
        assertEquals( "mark", l.get(0) );
        assertEquals( "ainhoa", l.get(1) );
        assertEquals( "marta", l.get(2) );
        assertEquals( "oihane", l.get(3) );
        assertEquals( "luis", l.get(4) );
        scores.addScore( "luis", 15 );
        l = scores.getUsuariosFieles();
        assertEquals( 5, l.size() );
        assertEquals( "luis", l.get(4) );
        scores.addUsuario( "nuevo" );
        l = scores.getUsuariosFieles();
        assertEquals( 6, l.size() );
        assertEquals( "luis", l.get(5) );
        scores.addScore( "ainhoa", 10 );
        l = scores.getUsuariosFieles();
        assertEquals( 6, l.size() );
        assertEquals( "ainhoa", l.get(4) );
        assertEquals( new ArrayList<String>( Arrays.asList( "mark", "nuevo", "marta", "oihane", "ainhoa", "luis" )),
            l );

        // Otros asserts
        // assertNull( o )    assertNotNull( o )
        // assertTrue( exp )  assertFalse( exp )
        // assertNotEquals 
        // ...
    }
}
