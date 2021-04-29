/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Runs the Program
 * 
 * @author <jan michalak> <janmichalak>
 * @author sahilalhat
 * @version <04/23/2021>
 */
public class Input {

    public static void main(String[] args) throws FileNotFoundException {

        try {
            if (args.length == 1) {

                CovidReader file = new CovidReader(args[0]);
                State[] states = file.getStates();

                for (int i = 0; i < states.length; i++) {
                    System.out.println(states[i].getName());

                    states[i].getRaces().sort(new NameComparator());
                    System.out.println(states[i].toString());

                    states[i].getRaces().sort(new CFRComparator());
                    System.out.println(states[i].toString());

                }
            }
            else {

                CovidReader file = new CovidReader(
                    "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
                State[] states = file.getStates();
                
                
                GUICovidWindow window = new GUICovidWindow(states);
                

                for (int i = 0; i < states.length; i++) {
                    System.out.println(states[i].getName());

                    states[i].getRaces().sort(new NameComparator());
                    System.out.println(states[i].toString());

                    states[i].getRaces().sort(new CFRComparator());
                    System.out.println(states[i].toString());

                }
                

            }
        }
        catch (ParseException e) {
            throw new FileNotFoundException();
        }
    }

}
