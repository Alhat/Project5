/**
 * 
 */
package prj5;

import student.TestCase;

/**
* Tests the Race class
* @author <jan michalak> <janmichalak>
* @version <04/22/2021>
*/
public class RaceTest extends TestCase
{
    private Race test;
    /**
     * Runs once before every test
     */
    public void setUp()
    {
        test = new Race("test", 10, 3);
    }
    /**
     * Tests all getter method
     */
    public void testGetterMethods()
    {
        assertEquals(test.getCases(), 10);
        assertEquals(test.getDeaths(), 3);
        assertEquals(test.getName(), "test");
        //System.out.println(test.getCFR());
        assertEquals(test.getCFR(), ((3.0 / 10.0) * 100.0), .01);
    }
    /**
     * Tests equal method
     */
    public void testEquals()
    {
        Race empty = null;
        assertFalse(test.equals(empty));
        empty = test;
        assertTrue(test.equals(empty));
        String s = "test";
        assertFalse(test.equals(s));
        Race test1 = new Race("test", 10, 3);
        Race test2 = new Race("test1", 10, 1);
        assertTrue(test.equals(test1));
        assertFalse(test1.equals(test2));
    }
    /**
     * Tests toString
     */
    public void testToString()
    {
        //System.out.println(test);
        assertEquals(test.toString(), "test: 10 cases, 30% CFR");
    }
    /**
     * Tests constructor
     */
    public void testConstructor()
    {
        Race negative = new Race("test", 0, -1);
        assertEquals(negative.getCFR(), -1.0, 0.1);
        negative = new Race("test", -1, 0);
        assertEquals(negative.getCFR(), -1.0, 0.1);
    }
    
}
