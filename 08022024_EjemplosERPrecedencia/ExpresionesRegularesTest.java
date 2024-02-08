import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExpresionesRegularesTest {

    @Test
    public void testIsEmail() {
        assertTrue(ExpresionesRegulares.isValidEmail("moises.alonso.23@gmail.com"));
    }

    @Test
    public void testIsValidURL() {
        assertTrue(ExpresionesRegulares.isValidURL("https://principal.url.edu.gt"));
        assertTrue(ExpresionesRegulares.isValidURL("https://www.url.edu.gt"));
        assertTrue(ExpresionesRegulares.isValidURL("http://www.url.edu.gt"));
        assertTrue(ExpresionesRegulares.isValidURL("www.office.com"));
        assertTrue(ExpresionesRegulares.isValidURL("office.com"));
    }

}
