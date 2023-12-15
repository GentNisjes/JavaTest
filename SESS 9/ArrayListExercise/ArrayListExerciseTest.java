import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArrayListExerciseTest
{
    /**
     * Default constructor for test class CopyOfArrayListExerciseTest
     */
    public ArrayListExerciseTest()
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

    @Test
    public void testConstructor()
    {
        ArrayListExercise arrayListExercise = new ArrayListExercise();
        assertNotNull(arrayListExercise.getMyFriends());
        assertEquals(0, arrayListExercise.getMyFriends().size());
    }

    @Test
    public void testAddFriends()
    {
        ArrayListExercise arrayListExercise = new ArrayListExercise();
        arrayListExercise.addFriends("Jan","Pier","Tjores");
        assertEquals(3, arrayListExercise.getNrOfFriends());
        arrayListExercise.addFriends("Corneel","Hendrika","Johanna");
        assertEquals(6, arrayListExercise.getNrOfFriends());
    }

    
    @Test
    public void testAddUniqueFriends()
    {
        ArrayListExercise arrayListExercise = new ArrayListExercise();
        arrayListExercise.addFriends("Jan","Pier","Tjores");  
        arrayListExercise.addUniqueFriend("Corneel");
        assertEquals(4, arrayListExercise.getNrOfFriends());
        arrayListExercise.addUniqueFriend("Corneel");
        assertEquals(4, arrayListExercise.getNrOfFriends());
    }
    
}

