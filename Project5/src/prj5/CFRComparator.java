package prj5;
import java.util.Comparator;

/**
 * Creates the CFR comparable class
 * 
 * @author Jan Michalak janmichalak
 * @version 2021.04.22
 *
 */
public class CFRComparator implements Comparator<Race>
{
    
    // ~ Constructor ...........................................................
    /**
     * Default Constructor left empty
     */
    public CFRComparator() 
    {
        //Constructor left intentionally empty.
    }
    
    /**
     * Returns 1 if first race is greater than second
     * returns 0 if they're equal
     * returns -1 in all other cases
     * @param <T>
     * @param race1 is the first race
     * @param race2 is the second race
     * @return 1, 0, or -1
     */
    @Override
    public int compare(Race race1, Race race2) 
    {
        //checks if race1 is greater than race 2
        if (race1.getCFR() > race2.getCFR())
        {
            return 1;
        }
        if (race1.getCFR() == race2.getCFR())
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

}
