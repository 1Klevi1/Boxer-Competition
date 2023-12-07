/**
 * The Manager class serves as the entry point for the boxing competition application.
 * @author Klevi
 * @version 07/12/2023
 */
package bcompetition;

import bcompetition.Controller.BoxingController;
import bcompetition.Model.CompetitorList;
import bcompetition.View.boxingGUI;

/**
 * The Manager class initializes the CompetitorList model, the boxingGUI view, and the BoxingController controller.
 * The main method is responsible for starting the application.
 */
public class Manager {

    /**
     * The main method initializes the necessary components for the boxing competition application
     * and starts the application by calling the start method of the controller.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Initialize the CompetitorList model with the path to the CSV file.
        CompetitorList model = new CompetitorList("src/bcompetition/RunCompetitor.csv");

        // Initialize the boxingGUI view.
        boxingGUI view = new boxingGUI();

        // Initialize the BoxingController with the model and view, and start the application.
        BoxingController controller = new BoxingController(model, view);
        controller.start();
    }
}
