

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RabbitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RabbitTest
{
    /**
     * Default constructor for test class RabbitTest
     */
    public RabbitTest()
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
    public void rabbitBirthAge()
    {
        Field f1 = new Field(10, 10);
        Location l1 = new Location(1, 1);
        Rabbit r1 = new Rabbit(false, f1, l1);
        assertEquals(true, r1.getAge() == 0) ;
    }
    
    @Test
    public void rabbitAfterMaxAge(){
        Field f1 = new Field(10, 10);
        Location l1 = new Location(1, 1);
        Rabbit r1 = new Rabbit(false, f1, l1);
        assertEquals(true, r1.getAge() == 40);
    }
    
    @Test
    public void rabbitBeforeZero(){
        Field f1 = new Field(10, 10);
        Location l1 = new Location(1, 1);
        Rabbit r1 = new Rabbit(false, f1, l1);
        assertEquals(true, r1.getAge() == -4);
    }
}
