/**
 * 
 */
package prj5;

import java.text.DecimalFormat;

/**
 * Creates the Race class
 * 
 * @author <jan michalak> <janmichalak>
 * @version <02/26/2021>
 */
public class Race {
    // ~ Fields ................................................................
    
    private String name;
    private int cases;
    private int deaths;
    private double cfrRatio;
    private DecimalFormat df2;
    
    // ~ Constructor ...........................................................
    /**
     * Creates the race object
     * 
     * @param race
     *            is the name of the race
     * @param caseNum
     *            number of the cases this race has
     * @param deathNum
     *            how many people of this race died
     */
    public Race(String race, int caseNum, int deathNum) {
        name = race;
        cases = caseNum;
        deaths = deathNum;
        if (caseNum == -1 || deathNum == -1) {
            cfrRatio = -1.0;
        }
        else {
            cfrRatio = ((double)deaths / (double)cases) * 100.0;
        }

        df2 = new DecimalFormat("#.#");
    }
    // ~ Methods ...............................................................
    
    // ----------------------------------------------------------
    /**
     * returns number of cases
     * 
     * @return case number
     */
    public int getCases() {
        return cases;
    }


    /**
     * returns number of deaths
     * 
     * @return return number of deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * returns the name of the race
     * 
     * @return name of race
     */
    public String getName() {
        return name;
    }


    /**
     * Gets cfr ratio
     * 
     * @return cfr
     */
    public double getCFR() {
        return cfrRatio;
    }


    /**
     * Checks if the races are the same
     * @param obj is the other object
     * @return true if name is the same
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            Race other = (Race)obj;
            if (this.getName().equals(other.getName())) {
                return true;
            }
        }
        return false;
    }


    /**
     * Returns String representation of object
     * 
     * @return String representation of the race
     */
    public String toString() {
        String result = "";
        result += name + ": ";
        result += cases + " cases, ";
        result += df2.format(cfrRatio) + "% CFR";
        return result;
    }
}
