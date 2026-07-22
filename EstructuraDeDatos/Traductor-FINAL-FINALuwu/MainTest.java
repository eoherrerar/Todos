

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class MainTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MainTest
{
    private Traduccion traducci1;
    private Traduccion traducci2;
    private Traduccion traducci3;
    private Traduccion traducci4;
    private Traduccion traducci5;
    private Traductor traducto1;

    /**
     * Default constructor for test class MainTest
     */
    public MainTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        traducci1 = new Traduccion("palabra", "word");
        traducci2 = new Traduccion("perro", "dog");
        traducci3 = new Traduccion("casa", "house");
        traducci4 = new Traduccion("pato", "duck");
        traducci5 = new Traduccion("pelo", "hair");
        traducto1 = new Traductor(10, TipoDiccionario.ESPAÑOL_INGLES);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
}