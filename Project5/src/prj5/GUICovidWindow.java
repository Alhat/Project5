package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

/**
 * 
 * 
 * @author Charles Revere (charlesrevere)
 * @version 2021.04.26
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
    private static final double DISPLAYFACTOR = 69;
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
        window.setTitle("Sahil Alhat, Charles Revere, and Jan Michalak");

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
     * and prints out the stats accordingly
     * @param button
     */
    public void clickedState(Button button) 
    {
        clean(); //cleans the screen
        if (button.toString().substring(11).equalsIgnoreCase(stateDC.toString()
            .substring(11))) {
            setCurrentState(button);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(11).equalsIgnoreCase(stateMD
            .toString().substring(11))) {
            setCurrentState(button);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(11).equalsIgnoreCase(stateGA
            .toString().substring(11))) {
            setCurrentState(button);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(11).equalsIgnoreCase(stateNC
            .toString().substring(11))) {
            setCurrentState(button);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(11).equalsIgnoreCase(stateTN
            .toString().substring(11))) {
            setCurrentState(button);
            draw(currentState.getRaces());
        }
        else if (button.toString().substring(11).equalsIgnoreCase(stateVA
            .toString().substring(11))) {
            setCurrentState(button);
            draw(currentState.getRaces());
        }

    }
    /**
     * Takes all the bars off the screen
     */
    private void clean() 
    {
        
        
    }
    /**
     * Sets the current state depending on what 
     * button is pressed
     * @param button
     */    private void setCurrentState(Button button) 
    {
        String name = button.toString();
        for (int i = 0; i < states.length; i++)
        {
            if (name.substring(11).equals(states[i].getName()))
            {
                currentState = states[i];
            }
        }
    }




    /**
     * Displays the current state stats sorted by alphabetical
     * order
     * @param button is the state button
     */
    public void clickedSortAlpha(Button button) 
    {
        clean();
        currentState.getRaces().sort(new NameComparator());
        draw(currentState.getRaces());
    }

    /**
     * Displays all the bars on the screen
     * @param x 
     */
    private void draw(SinglyLinkedList<Race> x) 
    {
        window.addShape(new Shape(100, 75, BAR_WIDTH, (int)(DISPLAYFACTOR * x.get(0).getCFR())));
    }


    /**
     * Displays the current state stats according to CFR
     * @param button
     */
    public void clickedSortCFR(Button button) 
    {
        clean();
        currentState.getRaces().sort(new CFRComparator());
        draw(currentState.getRaces());
    }


    /**
     * Closes system
     * @param button
     */
    public void clickedQuit(Button button) 
    {
        System.exit(0);
    }

}
