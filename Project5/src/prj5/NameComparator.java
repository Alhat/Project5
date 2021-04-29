/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * Creates the Name Comparator Class
 * 
 * @author Jan Michalak janmichalak
 * @version 2021.04.22
 *
 */
public class NameComparator implements Comparator<Race>
{

    // ~ Constructor ...........................................................
    /**
     * Default constructor left empty
     */
    public NameComparator() 
    {
        // left intentionally empty
    }
    
    /**
     * Returns 1 if race1 is before race2 in alphabetical order
     * returns 0 if they are the same
     * -1 in all other cases
     * @param race1 is the first race
     * @param race2 is the second race
     * @return -1, 0, 1 in all cases
     */
    @Override
    public int compare(Race race1, Race race2) 
    {
        String raceName1 = race1.getName();
        String raceName2 = race2.getName();
        if (raceName1.compareTo(raceName2) < 0)
        {
            return 1;
        }
        if (raceName1.compareTo(raceName2) == 0)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }

}
