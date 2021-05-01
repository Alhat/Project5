/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Reads the Covid-19 case data, which represents a number of races for any
 * given states. Parses the data file and sends a collection of State
 * objects to the project GUI class.
 * 
 * @author sahilalhat
 * @version <04.23.21>
 */
public class CovidReader {
    // ~ Fields ................................................................

    private State[] states;
    // private SinglyLinkedList<Race> races;

    // ~ Constructor ...........................................................
    public CovidReader(String covidDatabase)
        throws FileNotFoundException,
        ParseException {

        states = readStates(covidDatabase);
    }
    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Helper method used to read the data file.
     * 
     * @param covidDatabase
     *            The name of the file to parse.
     * @return An array of State objects.
     * @throws FileNotFoundException
     * @throws ParseException
     */
    private State[] readStates(String covidDatabase)
        throws FileNotFoundException,
        ParseException {

        State[] localStates = new State[6];
        Scanner scan = new Scanner(new File(covidDatabase));
        String[] line = new String[11];
        int stateCount = 0;

        if (scan.hasNext()) {
            scan.nextLine();
        }

        while (scan.hasNextLine()) {
            line = getRecordFromLine(scan.nextLine());
            localStates[stateCount] = new State(line[0], readRaces(line));
            stateCount++;
        }

        return localStates;
    }


    /**
     * Private helper method used by the readStates method to create a
     * SinglyLinkedList containing Race objects.
     * 
     * @param line
     *            The line of the file to parse.
     * @return A linked list of Race objects.
     */
    private SinglyLinkedList<Race> readRaces(String[] line) {

        String[] lineConvert = convertNA(line);

        SinglyLinkedList<Race> localRaces = new SinglyLinkedList<Race>();

        localRaces.add(new Race("White", Integer.parseInt(lineConvert[1]),
            Integer.parseInt(lineConvert[6])));

        localRaces.add(new Race("Black", Integer.parseInt(lineConvert[2]),
            Integer.parseInt(lineConvert[7])));

        localRaces.add(new Race("LatinX", Integer.parseInt(lineConvert[3]),
            Integer.parseInt(lineConvert[8])));

        localRaces.add(new Race("Asian", Integer.parseInt(lineConvert[4]),
            Integer.parseInt(lineConvert[9])));

        localRaces.add(new Race("Other", Integer.parseInt(lineConvert[5]),
            Integer.parseInt(lineConvert[10])));

        return localRaces;
    }


    /**
     * This method is used in the special cases when the cases or deaths for a
     * race are "NA".
     * 
     * @param line
     *            The line of the file to check for NA
     * @return The line of the file, with NA replaced by -1.
     */
    private String[] convertNA(String[] line) {
        for (int i = 0; i < line.length; i++) {
            if (line[i].equalsIgnoreCase("NA")) {
                line[i] = "-1";
            }
        }

        return line;

    }


    /**
     * Gets a line of data in the file
     * 
     * @param nextLine
     * @return the values in a line
     */
    @SuppressWarnings("resource")
    private String[] getRecordFromLine(String nextLine) {
        String[] values = new String[11];
        Scanner rowScanner = new Scanner(nextLine);
        rowScanner.useDelimiter(",");
        int count = 0;
        while (rowScanner.hasNext()) {
            values[count] = rowScanner.next();
            count++;
        }

        return values;
    }


    /**
     * Gets the states
     * 
     * @return the states
     */
    public State[] getStates() {
        return states;
    }
}
