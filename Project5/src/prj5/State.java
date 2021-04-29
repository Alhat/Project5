/**
 * 
 */
package prj5;

/**
 * Creates the State Class
 * 
 * @author <jan michalak> <janmichalak>
 * @version <02/26/2021>
 */
public class State {
    // ~ Fields ................................................................

    private SinglyLinkedList<Race> races;
    private String name;
    private boolean flag;

    // ~ Constructor ...........................................................
    /**
     * Creates the state object
     * 
     * @param n
     *            is the name of string
     * @param raceList
     *            list of races in the state
     */
    public State(String n, SinglyLinkedList<Race> raceList) {
        name = n;
        races = raceList;
        setFlag(false);
    }
    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Gets the name of the state
     * 
     * @return name of state
     */
    public String getName() {
        return name;
    }


    /**
     * Returns list of races
     * 
     * @return list of races
     */
    public SinglyLinkedList<Race> getRaces() {
        return races;
    }


    /**
     * Displays the output of the state and each race in it
     * 
     * @return string representation
     */
    public String toString() {
        String result = "";
        // result += this.getName() + "\n";
        for (int i = 0; i < races.size(); i++) {
            result += races.get(i).toString() + "\n";
        }
        result += "=====";
        return result;
    }


    /**
     * @return the flag
     */
    public boolean isFlag() {
        return flag;
    }


    /**
     * @param flag
     *            the flag to set
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
