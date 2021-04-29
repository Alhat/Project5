package prj5;
import java.util.Comparator;

/**
 * This is a basic implementation of a linked list
 *
 * @author Mark Wiggans (mmw125)
 * @version 4/14/2015
 * @author Christina Olk (colk)
 * @version 9.4.15
 * @author Grace Fields
 * @version 10.26.15
 * @author Jamal Ahmad (jamal93)
 * @version 10/15/2016
 * @author Margaret Ellis (maellis1)
 * @version 03/16/2017
 * @author JW Lee (jiayiw6)
 * @version 10/14/2019
 * 
 * @param <E>
 *            This is the type of object that this class will store
 */

public class SinglyLinkedList<E> implements LList<E> {

    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <D>
     *            This is the type of object that this class will store
     * @author Mark Wiggans (mmw125)
     * @author Christina Olk (colk)
     * @author maellis1
     * @author Jamal Ahmad (jamal93)
     * @author Margaret Ellis (maellis1)
     * @author JW Lee (jiayiw6)
     * 
     * @version 4/14/2015
     * @version 9.4.15
     * @version 10.29.15
     * @version 10/15/2016
     * @version 03/17/2017
     * @version 10/14/2019
     */
    public static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }
    // ~ Fields ................................................................
    
    private Node<E> head;

    // the size of the linked list
    private int size;

    // ~ Constructor ...........................................................
    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;

    }
    // ~ Methods ...............................................................
    
    // ----------------------------------------------------------
//<<<<<<< HEAD

//=======
    
//>>>>>>> branch 'master' of https://github.com/Alhat/Project5.git
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(int index, E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        else {
            Node<E> newNode = new Node<E>(obj);
            if (index == 0) {
                newNode.setNext(head);
                head = newNode;
            }
            else {
                Node<E> lastNode = head;
                while (lastNode.next != null) {
                    lastNode = lastNode.next;
                }
                lastNode.next = newNode;
            }
            size++;
        }
    }

    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(E obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<E> current = new Node<E>(obj);

        // empty stack case
        if (isEmpty()) {
            head = current;
        }

        // other cases
        else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.setNext(current);
        }
        size++;
    }

    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    @Override
    public boolean remove(E obj) {
        Node<E> current = head;

        // account for matching head
        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }

    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    @Override
    public boolean remove(int index) {
        // if the index is invalid
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {

            if (index == 0) {
                head = head.next;
                return true;
            }
            else {
                Node<E> temp = head;
                // int currentIndex = 0;
                for (int i = 0; temp != null && i < index - 1; i++) {
                    temp = temp.next;
                }
                if (temp == null || temp.next == null) {
                    // if the element was never found, this also handles empty
                    // case
                    throw new IndexOutOfBoundsException("Index is "
                        + "out of bounds");
                }
                Node<E> remove = temp.next.next;
                temp.next = remove;
                return true;
            }

        }
    }

    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null) {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear() {
        // make sure we don't call clear on an empty list
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }

    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    @Override
    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }
    
    /**
     * This sort method uses an insertion sort algorithm to sort
     * the contents of the LinkedList. 
     * 
     * @param c
     *          The Comparator to use when sorting
     */
    public void sort(Comparator<Race> c) {
        
        Node<E> curr = head;
        Node<E> sortedHead = null;
        
        while (curr != null) 
        {
            Node<E> currNext = curr.next;
            sortedHead = sortedInsert(sortedHead, curr, c);
            curr = currNext;
        }
        head = sortedHead;
    }
    
    /**
     * Private helper method used by the insertion sort. Takes the head
     * of a sorted list, the next node to sort into that list, and the 
     * comparator to use.
     * 
     * @param sortedHead
     *              The Node acting as the head of the sorted list.
     * @param newNode
     *              The next Node to be sorted.
     * @param c
     *              The Comparator to use when sorting.
     * @return The head of the sorted list portion.
     */
    private Node<E> sortedInsert(Node<E> sortedHead, Node<E> newNode,
        Comparator<Race> c) {
        
        if (sortedHead == null || c.compare((Race)sortedHead.getData(), 
            (Race)newNode.getData()) < 0) {
            
            newNode.next = sortedHead;
            return newNode;
        }
        else {
            Node<E> curr = sortedHead;
            while (curr.next != null && c.compare((Race)curr.next.getData(), 
                (Race)newNode.getData()) >= 0) {
                
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return sortedHead;
    }
    
    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<E> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }

    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<E> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }

    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<E> other = ((SinglyLinkedList<E>)obj);
            if (other.size() == this.size()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }

}
