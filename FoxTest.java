

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class FoxTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FoxTest
{
    /**
     * Default constructor for test class FoxTest
     */
    public FoxTest()
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
    
    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void foxBirthAge()
    {
        Field f1 = new Field(10, 10);
        Location l1 = new Location(1, 1);
        Fox fx1 = new Fox(false, f1, l1);
        assertEquals(true, fx1.getAge() == 0) ;
    }
    
    @Test
    public void foxAfterMaxAge(){
        Field f1 = new Field(10, 10);
        Location l1 = new Location(1, 1);
        Fox fx1 = new Fox(false, f1, l1);
        assertEquals(true, fx1.getAge() == 150);
    }
    
    @Test
    public void foxBeforeZero(){
        Field f1 = new Field(10, 10);
        Location l1 = new Location(1, 1);
        Fox fx1 = new Fox(false, f1, l1);
        assertEquals(true, fx1.getAge() == -4);
    }
}
