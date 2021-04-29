/**
 * 
 */
package prj5;

import student.TestCase;

/**
* Tests the CFRComparator class
* @author <jan michalak> <janmichalak>
* @version <04/22/2021>
*/
public class NameComparatorTest extends TestCase
{
    private NameComparator comp;
    /**
     * Runs once before every setup
     */
    public void setUp()
    {
        comp = new NameComparator();
    }
    /**
     * Tests compare
     */
    public void testCompare()
    {
        Race race1 = new Race("a", 1, 1);
        Race race2 = new Race("b", 2, 1);
        Race race3 = new Race("a", 1, 1);
        assertEquals(comp.compare(race1, race2), 1);
        assertEquals(comp.compare(race2, race1), -1);
        assertEquals(comp.compare(race1, race3), 0);
        //test
    }
}
