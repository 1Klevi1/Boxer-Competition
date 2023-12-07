package bcompetition.Controller;

import bcompetition.Model.CompetitorList;
import bcompetition.Model.KABoxer;
import bcompetition.View.boxingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Comparator;

public class BoxingController {

    private CompetitorList model = new CompetitorList("src/bcompetition/RunCompetitor.csv");
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
                    "Id", "Full Name","Heavy Score",
                    "Middle Score","Light Score",
                    "Country","Age","Gender",
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

    public void attachEventListenersMakeMenuBar(){
        view.getFullDetails().addActionListener(e ->{
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput != null) {
                    int boxerId = Integer.parseInt(userInput);
                    view.getListing().setText(model.getCompetitorFullDetails(boxerId));
                    view.getListing().setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                }
            }catch (NumberFormatException l){
                JOptionPane.showMessageDialog(view.getFrame(), "Wrong input provided.");
            }
        });

    }
    public void windowClosingListener(){

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

        view.getShortDetails().addActionListener(e ->{
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput != null) {
                    int boxerId = Integer.parseInt(userInput);
                    view.getListing().setText(model.getCompetitorShortDetails(boxerId));
                    view.getListing().setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "User canceled the input.");
                }
            }catch (NumberFormatException l){
                JOptionPane.showMessageDialog(view.getFrame(), "Wrong input provided.");
            }
        });

    }

    public void start() {
        SwingUtilities.invokeLater(() -> view.getFrame().setVisible(true));
    }
}
