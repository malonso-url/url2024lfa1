import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EjemplosERTest {
    @Test
    public void testIsAComment() {
        assertTrue(EjemplosER.isAComment("^<< Esto es un comentario >>"));
    }

    @Test
    public void testIsNotAComment() {
        assertFalse(EjemplosER.isAComment("No es comentario"));
    }

    @Test
    public void testIsNotACommentStartSign() {
        assertFalse(EjemplosER.isAComment("<< No es comentario"));
    }

    @Test
    public void testIsASequenceOfAsBs() {
        assertTrue(EjemplosER.isASequenceOfAsBs("aaabbb"));
    }

    @Test
    public void testIsAIntegerNotStartingZero() {
        assertTrue(EjemplosER.isAIntegerNotStartingZero("9"));
    }

    @Test
    public void testIsASetq() {
        assertTrue(EjemplosER.isSetqValid("setq Prueba 10"));
        //assertTrue(EjemplosER.isSetqValid("setq prueba dfljdl"));
    }

    @Test
    public void testIsASetqForStrings() {
        assertTrue(EjemplosER.isSetqValidForStrings("setq mensaje \"Hola Alumnos\""));
     
    }
}
