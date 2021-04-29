/**
 * 
 */
package prj5;
import student.TestCase;
/**
* Tests the State class
* @author <jan michalak> <janmichalak>
* @version <04/22/2021>
*/
public class StateTest extends TestCase
{

    private State state;
    
    /**
     * Runs once before every test
     */
    public void setUp()
    {
        Race race1 = new Race("test", 10, 3);
        Race race2 = new Race("test", 10, 3);
        Race race3 = new Race("test", 10, 3);
        SinglyLinkedList<Race> list = new SinglyLinkedList<Race>();
        list.add(race1);
        list.add(race2);
        list.add(race3);
        state = new State("TX", list);
    }
    /**
     * Tests getter method
     */
    public void testGetterMethods()
    {
        assertEquals(state.getName(), "TX");
        Race race1 = new Race("test", 10, 3);
        Race race2 = new Race("test", 10, 3);
        Race race3 = new Race("test", 10, 3);
        SinglyLinkedList<Race> list = new SinglyLinkedList<Race>();
        list.add(race1);
        list.add(race2);
        list.add(race3);
        assertEquals(state.getRaces(), list);
    }
    /**
     * Tests State to String method
     */
    public void testToString()
    {
        System.out.println(state);
        assertEquals(state.toString(), "test: 10 cases, 30% CFR\r\n"
            + "test: 10 cases, 30% CFR\r\n"
            + "test: 10 cases, 30% CFR\r\n"
            + "=====");
    }
    
}
