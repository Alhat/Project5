/**
 * 
 */
package prj5;

import java.util.Arrays;
// import linkedlist.SinglyLinkedList;
import student.TestCase;

/**
 * Tests the SinglyLinkedList class
 * 
 * @author <jan michalak> <janmichalak>
 * @version <04/22/2021>
 */
public class SinglyLinkedListTest extends TestCase {

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    // private SinglyLinkedList<String> testList;
    private String nullObject;

    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        // testList = new SinglyLinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        // System.out.println(smallListA);
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);
    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {
        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));
    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));
    }


    /**
     * Tests the rest of the methods
     */
    public void testRest() {
        // add methods
        String test = null;
        Exception e = null;
        try {
            smallListA.add(0, test);
        }
        catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalArgumentException);
        try {
            smallListA.add(-1, "test");
        }
        catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        try {
            smallListA.add(4, "test");
        }
        catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        try {
            smallListA.add(test);
        }
        catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalArgumentException);

        assertTrue(emptyListA.isEmpty());
        emptyListA.add(0, "test");
        assertFalse(emptyListA.isEmpty());
        assertEquals(emptyListA.size(), 1);
        emptyListA.add(0, "test1");
        assertEquals(emptyListA.size(), 2);
        assertEquals(emptyListA.lastIndexOf("test"), 1);
        assertEquals(emptyListA.lastIndexOf("test1"), 0);
        assertEquals(emptyListA.lastIndexOf("test2"), -1);
        assertTrue(emptyListA.contains("test"));
        assertTrue(emptyListA.contains("test1"));
        assertFalse(emptyListA.contains("test12"));
        assertFalse(emptyListB.contains("test"));
        assertEquals(emptyListA.get(0), "test1");
        assertEquals(emptyListA.get(1), "test");
        try {
            emptyListA.get(3);
        }
        catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        // tests remove
        try {
            emptyListA.remove(3);
        }
        catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        try {
            emptyListB.remove(3);
        }
        catch (Exception ex) {
            e = ex;
        }
        assertNotNull(e);
        assertTrue(e instanceof IndexOutOfBoundsException);
        System.out.println(emptyListA);
        assertEquals(emptyListA.toString(), "{test1, test}");
        assertTrue(emptyListA.remove("test"));
        // System.out.println(emptyListA);
        assertEquals(emptyListA.toString(), "{test1}");
        assertTrue(emptyListA.remove("test1"));
        // assertFalse(emptyListA.remove(null));

        emptyListB.add(0, "test");
        emptyListB.add(1, "test1");
        assertFalse(emptyListB.isEmpty());
        assertEquals(emptyListB.size(), 2);
        assertTrue(emptyListB.remove(0));
        emptyListB.add(0, "test");
        emptyListB.add(1, "test1");
        emptyListB.add(0, "test");
        emptyListB.add(1, "test1");
        // System.out.println(emptyListB.size());
        assertTrue(emptyListB.remove(4));

    }

}
