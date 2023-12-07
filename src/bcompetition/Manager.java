package bcompetition;

import bcompetition.Controller.BoxingController;
import bcompetition.Model.CompetitorList;
import bcompetition.View.boxingGUI;

public class Manager {
    public static void main(String[] args) {
        CompetitorList model = new CompetitorList("src/bcompetition/RunCompetitor.csv");
        boxingGUI view = new boxingGUI();
        BoxingController controller = new BoxingController(model, view);
        controller.start();
    }
}
