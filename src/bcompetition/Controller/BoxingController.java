package bcompetition.Controller;

import bcompetition.Model.Category;
import bcompetition.Model.CompetitorList;
import bcompetition.Model.KABoxer;
import bcompetition.Model.Level;
import bcompetition.View.boxingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Comparator;

public class BoxingController {

    private CompetitorList model;
    private boxingGUI view;

    public BoxingController(CompetitorList model, boxingGUI view) {
        this.model = model;
        this.view = view;
        initView();
        attachEventListenersMakeFrame();
        attachEventListenersMakeMenuBar();
    }

    private void initView() {
        view.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowClosingListener();
        view.makeFrame();
        view.makeMenuBar();
    }

    private void attachEventListenersMakeFrame() {
        view.getViewTable().addActionListener(e -> {
            Object[][] data = new Object[model.getAllParticipants().size()][16];

            for (int i = 0; i < model.getAllParticipants().size(); i++) {
                KABoxer boxer = model.getAllParticipants().get(i);
                data[i][0] = boxer.getCompetitorId();
                data[i][1] = boxer.getCompetitorDetails().getFullName();
                data[i][2] = Arrays.toString(boxer.getScoresHeavy());
                data[i][3] = Arrays.toString(boxer.getScoresMiddle());
                data[i][4] = Arrays.toString(boxer.getScoresLight());
                data[i][5] = boxer.getCompetitorDetails().getCountry();
                data[i][6] = boxer.getCompetitorDetails().getAge();
                data[i][7] = boxer.getCompetitorDetails().getGender();
                data[i][8] = boxer.getCompetitorLvl();
                data[i][9] = boxer.getCompetitorCategory();
                data[i][10] = model.calcTotals(boxer);
                data[i][11] = model.calcMax(boxer);
                data[i][12] = model.calcMin(boxer);
                data[i][13] = model.calcFrequency(boxer);
                data[i][14] = model.calcAverages(boxer);
                data[i][15] = boxer.getOverallScore();
            }
            // Column names
            String[] columnNames = {
                    "Id", "Full Name", "Heavy Score",
                    "Middle Score", "Light Score",
                    "Country", "Age", "Gender",
                    "Level", "Category", "Total",
                    "Max score", "Min score", "Frequency",
                    "Average", "Overall Score"
            };
            JTable table = new JTable(data, columnNames);

            table.setPreferredScrollableViewportSize(new Dimension(1000, 500));
            table.setRowHeight(20);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for (int i = 0; i < columnNames.length; i++) {
                table.getColumnModel().getColumn(i).setPreferredWidth(150); // Adjust the width for each column
            }
            table.getColumnModel().getColumn(13).setPreferredWidth(600); // Adjust the width for each column

            // Create buttons for sorting
            JButton ascendingButton = new JButton("Ascending");
            JButton descendingButton = new JButton("Descending");

            // Add action listeners to the buttons
            ascendingButton.addActionListener((j -> {
                Arrays.sort(data, Comparator.comparing(row -> (int) row[0]));
                table.repaint();
            }));

            descendingButton.addActionListener((j -> {
                Arrays.sort(data, Comparator.comparing(row -> (int) row[0], Comparator.reverseOrder()));
                table.repaint();
            }));

            // Create a panel for the buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(ascendingButton);
            buttonPanel.add(descendingButton);

            JPanel contentPane = new JPanel(new BorderLayout());
            contentPane.add(buttonPanel, BorderLayout.NORTH);
            contentPane.add(new JScrollPane(table), BorderLayout.CENTER);

            JOptionPane.showMessageDialog(view.getFrame(), contentPane, "Table View", JOptionPane.PLAIN_MESSAGE);
        });

        view.getViewStateButton().addActionListener(e -> view.getListing().setText(model.boxerTable()));

        view.getClearButton().addActionListener(e -> view.getListing().setText(""));
    }

    public void attachEventListenersMakeMenuBar() {
        view.getFullDetails().addActionListener(e -> {
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput != null) {
                    int boxerId = Integer.parseInt(userInput);
                    view.getListing().setText(model.getCompetitorFullDetails(boxerId));
                    view.getListing().setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                }
            } catch (NumberFormatException l) {
                JOptionPane.showMessageDialog(view.getFrame(), "Wrong input provided.");
            }
        });

    }

    public void windowClosingListener() {

        view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                model.writeToFile("report_data.txt");
                JOptionPane.showMessageDialog(null,
                        "The filename for the report is \"report_data.txt.\"", "Closing Window",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });

        view.getShortDetails().addActionListener(e -> {
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput != null) {
                    int boxerId = Integer.parseInt(userInput);
                    view.getListing().setText(model.getCompetitorShortDetails(boxerId));
                    view.getListing().setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                }
            } catch (NumberFormatException l) {
                JOptionPane.showMessageDialog(view.getFrame(), "Wrong input provided.");
            }
        });

        view.getRemoveBoxer().addActionListener(e -> {
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput != null) {
                    int boxerId = Integer.parseInt(userInput);
                    if (model.boxerExists(boxerId)) {
                        JOptionPane.showMessageDialog(view.getFrame(), model.removeBoxer(boxerId));
                    } else {
                        JOptionPane.showMessageDialog(view.getFrame(), "Boxer doesn't exist.");
                    }
                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                }
            } catch (NumberFormatException l) {
                JOptionPane.showMessageDialog(view.getFrame(), "Wrong input provided.");
            }
        });

        view.getEditBoxerDetails().addActionListener(e -> {
            String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
            int boxerId = -1;  // Initialize to a default value
            if (userInput == null) {
                JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                return;
            }
            try {
                boxerId = Integer.parseInt(userInput);
                if (!(model.boxerExists(boxerId))) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Boxer doesn't exist.");
                    return;
                }
            } catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(view.getFrame(), "Wrong input provided.");
                return;
            }

            Object[] details = {
                    "Name", "Middle Name", "Surname", "Country",
                    "Age", "Gender", "Competitor Level", "Competitor Category", "Scores Heavy (comma-separated)",
                    "Scores Middle (comma-separated)", "Scores Light (comma-separated)"
            };

            Object settingDetail = JOptionPane.showInputDialog(
                    view.getFrame(),
                    "Select detail:",
                    "Details Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    details,
                    null
            );
            String setDetail = (String) settingDetail;
            if (setDetail == null) {
                JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                return;
            }
            if (setDetail.equals("Competitor Category")) {
                Category[] categories = Category.values();
                Category selectedCategory = (Category) JOptionPane.showInputDialog(
                        view.getFrame(),
                        "Select Category:",
                        "Category Selection",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        categories,
                        null
                );
                if (String.valueOf(selectedCategory).equals("null")) {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                    return;
                }
                view.getListing().setText(model.editBoxerDetails(boxerId, setDetail, String.valueOf(selectedCategory).toUpperCase()));
                view.getListing().setEditable(false);
            } else if (setDetail.equals("Competitor Level")) {
                Level[] lvl = Level.values();
                Level selectedLevel = (Level) JOptionPane.showInputDialog(
                        view.getFrame(),
                        "Select Level:",
                        "Level Selection",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        lvl,
                        null
                );
                if (String.valueOf(selectedLevel).equals("null")) {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                    return;
                }
                view.getListing().setText(model.editBoxerDetails(boxerId, setDetail, String.valueOf(selectedLevel).toUpperCase()));
                view.getListing().setEditable(false);
            } else {
                String newValue = JOptionPane.showInputDialog("Enter new value for " + setDetail + ": ");
                if (newValue == null || newValue.equals("NULL")) {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                    return;
                }
                view.getListing().setText(model.editBoxerDetails(boxerId, setDetail, newValue));
                view.getListing().setEditable(false);
            }
        });

        view.getEditBoxerScore().addActionListener(e -> {
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                    return;
                }
                int boxerId = Integer.parseInt(userInput);
                if (!(model.boxerExists(boxerId))) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Boxer doesn't exist.");
                    return;
                }
                String boxerScore = JOptionPane.showInputDialog("Enter boxer score (comma-separated): ");
                if (boxerScore == null) {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                    return;
                }
                String[] scoreStrings = boxerScore.split(",");
                int[] boxerScores = new int[scoreStrings.length];
                for (int i = 0; i < scoreStrings.length; i++) {
                    try {
                        boxerScores[i] = Integer.parseInt(scoreStrings[i].trim());
                    } catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(view.getFrame(), "Invalid input. Please enter valid integers.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(view.getFrame(), model.alterBoxerScores(boxerId, boxerScores));

            } catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(view.getFrame(), "Invalid ID provided.");
            }
        });

        view.getViewDetailsCategory().addActionListener(e -> {
            Category[] categories = Category.values();
            Category selectedCategory = (Category) JOptionPane.showInputDialog(
                    view.getFrame(),
                    "Select Category:",
                    "Category Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    categories,
                    null
            );
            view.getListing().setText(model.viewDetailsCategory(selectedCategory));
            view.getListing().setEditable(false);
        });

    }

    public void start() {
        SwingUtilities.invokeLater(() -> view.getFrame().setVisible(true));
    }
}
