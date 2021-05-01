package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Front end class which displays the data
 * 
 * @author charlesrevere
 * @author sahilalhat
 * @author janmichalak
 * @version 2021.04.30
 */
public class GUICovidWindow {
    // ~ Fields ................................................................

    private Window window;
    private State[] states;
    private Button quitButton;
    private Button sortAlpha;
    private Button sortCFR;
    private Button stateDC;
    private Button stateMD;
    private Button stateGA;
    private Button stateNC;
    private Button stateTN;
    private Button stateVA;
    private State currentState;
    private String title;
    private static final double DISPLAY_FACTOR = 25;
    /**
     * Sets the bar width
     */
    private static final int BAR_WIDTH = 20;

    // ~ Constructor ...........................................................
    /**
     * 
     * @param stateList
     *            The list of state objects to display.
     */
    public GUICovidWindow(State[] stateList) {
        states = stateList;
        currentState = states[0];

        window = new Window();
        window.setTitle("salhat, charlesrevere, and janmichalak");

        sortAlpha = new Button("Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");
        window.addButton(sortAlpha, WindowSide.NORTH);

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        sortCFR = new Button("CFR");
        sortCFR.onClick(this, "clickedSortCFR");
        window.addButton(sortCFR, WindowSide.NORTH);

        stateDC = new Button("Represent DC");
        stateDC.onClick(this, "clickedState");
        window.addButton(stateDC, WindowSide.SOUTH);

        stateMD = new Button("Represent MD");
        stateMD.onClick(this, "clickedState");
        window.addButton(stateMD, WindowSide.SOUTH);

        stateGA = new Button("Represent GA");
        stateGA.onClick(this, "clickedState");
        window.addButton(stateGA, WindowSide.SOUTH);

        stateNC = new Button("Represent NC");
        stateNC.onClick(this, "clickedState");
        window.addButton(stateNC, WindowSide.SOUTH);

        stateTN = new Button("Represent TN");
        stateTN.onClick(this, "clickedState");
        window.addButton(stateTN, WindowSide.SOUTH);

        stateVA = new Button("Represent VA");
        stateVA.onClick(this, "clickedState");
        window.addButton(stateVA, WindowSide.SOUTH);

    }
    // ~ Methods ...............................................................


    /**
     * Determines which state you clicked on, then sets the current state
     * and prints out the states accordingly
     * 
     * @param button
     */
    public void clickedState(Button button) {
        clean(); // cleans the screen
        title = button.getTitle().substring(10) + " Case Fatality Ratios by Race";
        if (button.toString().substring(10).equalsIgnoreCase(stateDC.toString()
            .substring(10))) {

            setCurrentState(stateDC);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(10).equalsIgnoreCase(stateMD
            .toString().substring(10))) {

            setCurrentState(stateMD);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(10).equalsIgnoreCase(stateGA
            .toString().substring(10))) {

            setCurrentState(stateGA);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(10).equalsIgnoreCase(stateNC
            .toString().substring(10))) {

            setCurrentState(stateNC);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(10).equalsIgnoreCase(stateTN
            .toString().substring(10))) {

            setCurrentState(stateTN);
            draw(currentState.getRaces());

        }
        else if (button.toString().substring(10).equalsIgnoreCase(stateVA
            .toString().substring(10))) {

            setCurrentState(stateVA);
            draw(currentState.getRaces());
        }

    }


    /**
     * Takes all the bars off the screen
     */
    private void clean() {
        window.removeAllShapes();
    }


    /**
     * Sets the current state depending on what
     * button is pressed
     * 
     * @param button
     */
    private void setCurrentState(Button button) {

        for (int i = 0; i < states.length; i++) {
            if (states[i].getName().equalsIgnoreCase(button.getTitle()
                .substring(10))) {
                currentState = states[i];
                break;
            }
        }
    }


    /**
     * Displays the current state stats sorted by alphabetical
     * order
     * 
     * @param button
     *            is the state button
     */
    public void clickedSortAlpha(Button button) {
        clean();
        currentState.getRaces().sort(new NameComparator());
        draw(currentState.getRaces());
    }


    /**
     * Displays all the bars on the screen
     * 
     * @param x
     */
    private void draw(SinglyLinkedList<Race> x) {
        
        window.addShape(new TextShape(300, 20, title));
        
        for (int i = 0; i < x.size(); i++) {
            /*
             * window.addShape(new TextShape(105 + (i * 105), 250, x.get(i)
             * .getName() + "\n" + x.get(i).getFormatCFR() + "%"));
             */

            if (x.get(i).getFormatCFR().equals("-1")) {
                window.addShape(new TextShape(125 + (i * 125), 250, x.get(i)
                    .getName()));

                window.addShape(new TextShape(125 + (i * 125), 225, "NA"));

            }
            else {
                window.addShape(new TextShape(125 + (i * 125), 250, x.get(i)
                    .getName()));
                window.addShape(new TextShape(125 + (i * 125), 275, "" + x.get(
                    i).getFormatCFR() + "%"));

                window.addShape(new Shape(130 + (i * 125), 225
                    - (int)(DISPLAY_FACTOR * x.get(i).getCFR()), BAR_WIDTH,
                    (int)(DISPLAY_FACTOR * x.get(i).getCFR())));
            }

        }

    }


    /**
     * Displays the current state stats according to CFR
     * 
     * @param button
     */
    public void clickedSortCFR(Button button) {
        clean();
        currentState.getRaces().sort(new CFRComparator());
        draw(currentState.getRaces());
    }


    /**
     * Closes system
     * 
     * @param button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

}
