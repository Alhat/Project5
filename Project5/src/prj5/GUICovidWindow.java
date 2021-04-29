package prj5;

import cs2.Button;
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

    private static final int BAR_WIDTH = 0;

    // ~ Constructor ...........................................................
    /**
     * 
     * @param stateList
     *            The list of state objects to display.
     */
    public GUICovidWindow(State[] stateList) {
        states = stateList;

        window = new Window();
        window.setTitle("Sahil Alhat, Charles Revere, and Jan Michalak");

        quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        sortAlpha = new Button("Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");
        window.addButton(sortAlpha, WindowSide.NORTH);

        sortCFR = new Button("CFR");
        sortCFR.onClick(this, "clickedSortCFR");
        window.addButton(sortCFR, WindowSide.NORTH);

    }
    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * 
     * @param button
     */
    public void clickedState(Button button) {
        if (button.equals(stateDC)) {
            for (int i = 0; i < states.length; i++) {
                if (states[i].getName() == "DC") {
                    states[i].setFlag(true);
                    // DO GUI STUFF in here ........... (break after)
                    break;
                }
            }
        }
        
        
        
    }


    /**
     * 
     * @param button
     */
    public void clickedSortAlpha(Button button) {
        for (int i = 0; i < states.length; i++) {
            if (states[i].isFlag()) {
                states[i].getRaces().sort(new NameComparator());
                // Do GUI stuff in here ........................
            }
        }
    }


    /**
     * 
     * @param button
     */
    public void clickedSortCFR(Button button) {
        for (int i = 0; i < states.length; i++) {
            if (states[i].isFlag()) {
                states[i].getRaces().sort(new CFRComparator());
                // Do GUI stuff in here ........................
            }
        }
    }


    /**
     * 
     * @param button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }

}
