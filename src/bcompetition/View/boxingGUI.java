package bcompetition.View;

import bcompetition.Category;
import bcompetition.Level;
import bcompetition.Model.CompetitorList;
import bcompetition.Model.KABoxer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Provides a GUI interface for the game.
 *
 * @author Klevi, Jack, Luke, Abdulla
 * @version 04/04/2023
 */
public class boxingGUI {
    private  CompetitorList clist = new CompetitorList("src/bcompetition/RunCompetitor.csv");
    private final JFrame frame = new JFrame("Game GUI");
    private final JPanel eastPanel = new JPanel();
    private final JPanel outputPanel = new JPanel();
    private final JMenuBar menubar = new JMenuBar();
    private final JTextArea listing = new JTextArea();
    private final JMenu ViewMenu = new JMenu("Boxer Menu");
    private final JButton clearButton = new JButton("Clear");
    private final JButton viewStateButton = new JButton("View State");
    private final JMenuItem listASFItem = new JMenuItem("List ASF");
    private final JMenuItem recallForceItem = new JMenuItem("Recall Force");
    private final JMenuItem activateForceItem = new JMenuItem("Activate Force");
    private final JMenuItem fullDetails = new JMenuItem("View Full details of the Boxer");
    private final JMenuItem shortDetails = new JMenuItem("View Short details of the Boxer");
    private final JMenuItem removeBoxer = new JMenuItem("Remove boxer");
    private final JMenuItem editBoxerScore = new JMenuItem("Edit boxer score");
    private final JMenuItem editBoxerDetails = new JMenuItem("Edit boxer details");
    private final JMenuItem viewDetailsCategory = new JMenuItem("View a list of boxer using Category");
    private final JScrollPane scrollPane = new JScrollPane(listing, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    private final JButton viewTable = new JButton("View Table");


    /**
     * Constructs a game GUI object.
     */
    public boxingGUI() {
        // Create the GUI
        makeFrame();
        makeMenuBar();
    }

    /**
     * Runs the GUI.
     *
     * @param args A string array of CLI arguments.
     */
    public static void main(String[] args) {
//        CompetitorList l = new CompetitorList();
//        l.readAllParticipants("src/bcompetition/RunCompetitor.csv");
        new boxingGUI();
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame() {
        // Assuming you have a JFrame named 'frame'
        frame.setLayout(new BorderLayout());
        frame.setBackground(Color.WHITE);

        // Create the output panel listing the result from top to bottom
        outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));
        outputPanel.setBackground(Color.WHITE);

        scrollPane.setPreferredSize(new Dimension(867, 600));
        scrollPane.setMinimumSize(new Dimension(867, 600));

        listing.setLineWrap(true);
        listing.setWrapStyleWord(true);
        outputPanel.add(scrollPane);

        // Create the eastPanel
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBackground(Color.WHITE);

        // Add components to eastPanel
        eastPanel.add(viewStateButton);
        eastPanel.add(Box.createVerticalStrut(10)); // Add spacing if needed
        eastPanel.add(clearButton);
        eastPanel.add(Box.createVerticalStrut(10)); // Add spacing if needed
        eastPanel.add(viewTable);


        // Set up the east panel
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBackground(Color.WHITE);

        // Add rigid areas for spacing
        eastPanel.add(Box.createVerticalStrut(10));

        // Set maximum size for components
        Dimension buttonSize = new Dimension(117, 30); // Adjust the size as needed

        // Add viewStateButton
        viewStateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewStateButton.setPreferredSize(buttonSize); // Set the preferred size
        eastPanel.add(viewStateButton);

        // Add rigid areas for spacing
        eastPanel.add(Box.createVerticalStrut(10));

        // Add clearButton
        clearButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearButton.setMaximumSize(buttonSize); // Set the preferred size
        eastPanel.add(clearButton);

        // Add rigid areas for spacing
        eastPanel.add(Box.createVerticalStrut(10));

        // Add viewTable
        viewTable.addActionListener(e -> {
            // Sample data for the table
            Object[][] data = new Object[clist.getAllParticipants().size()][16]; // Assuming you have three attributes in your Person class

            for (int i = 0; i < clist.getAllParticipants().size(); i++) {
                KABoxer boxer = clist.getAllParticipants().get(i);
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
                data[i][10] = clist.calcTotals(boxer);
                data[i][11] = clist.calcMax(boxer);
                data[i][12] = clist.calcMin(boxer);
                data[i][13] = clist.calcFrequency(boxer);
                data[i][14] = clist.calcAverages(boxer);
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

            JOptionPane.showMessageDialog(frame, contentPane, "Table View", JOptionPane.PLAIN_MESSAGE);
        });
        viewTable.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewTable.setPreferredSize(buttonSize); // Set the preferred size
        eastPanel.add(viewTable);

        // Set up the view button
        viewStateButton.addActionListener(e -> listing.setText(clist.boxerTable()));
        viewStateButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewStateButton.setForeground(Color.WHITE);
        viewStateButton.setBackground(Color.BLUE);

        // Set up the view table button
        viewTable.setFont(new Font("Arial", Font.BOLD, 16));
        viewTable.setForeground(Color.WHITE);
        viewTable.setBackground(Color.BLUE);

        // Set up the clear button
        clearButton.addActionListener(e -> listing.setText(""));
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLUE);

        // Set minimum sizes for the components
        eastPanel.setMinimumSize(new Dimension(867, 600)); // Adjust as needed

        // Set the preferred size of the frame
        frame.setPreferredSize(new Dimension(1000, 600)); // Adjust as needed
        frame.pack();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // Your method to write to file
                clist.writeToFile("report_data.txt");
                JOptionPane.showMessageDialog(null,
                        "The filename for the report is \"report_data.txt.\"", "Closing Window",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
        frame.setMinimumSize(new Dimension(867, 600)); // Adjust as needed
        // Arrange the components on the frame and show the GUI
        frame.add(eastPanel, BorderLayout.EAST);
        frame.add(scrollPane, BorderLayout.WEST);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar() {
        // Create a menubar
        menubar.setLayout(new BoxLayout(menubar, BoxLayout.X_AXIS));
        menubar.setBackground(Color.WHITE);
        menubar.add(Box.createHorizontalStrut(10));
        ViewMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        menubar.add(ViewMenu);
        menubar.add(Box.createHorizontalStrut(10));
        menubar.setVisible(true);

        fullDetails.addActionListener(e ->{
           try {
               String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
               if (userInput != null) {
                   int boxerId = Integer.parseInt(userInput);
                   listing.setText(clist.getCompetitorFullDetails(boxerId));
                   listing.setEditable(false);
               } else {
                   JOptionPane.showMessageDialog(frame, "User canceled the input.");
               }
           }catch (NumberFormatException l){
               JOptionPane.showMessageDialog(frame, "Wrong input provided.");
           }
        });

        shortDetails.addActionListener(e ->{
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput != null) {
                    int boxerId = Integer.parseInt(userInput);
                    listing.setText(clist.getCompetitorShortDetails(boxerId));
                    listing.setEditable(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "User canceled the input.");
                }
            }catch (NumberFormatException l){
                JOptionPane.showMessageDialog(frame, "Wrong input provided.");
            }
        });

        removeBoxer.addActionListener(e ->{
            try {
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if (userInput != null) {
                    int boxerId = Integer.parseInt(userInput);
                    if(clist.boxerExists(boxerId)){
                        JOptionPane.showMessageDialog(frame, clist.removeBoxer(boxerId));
                    }else{
                        JOptionPane.showMessageDialog(frame, "Boxer doesn't exist.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "User canceled the input.");
                }
            }catch (NumberFormatException l){
                JOptionPane.showMessageDialog(frame, "Wrong input provided.");
            }
        });

        editBoxerDetails.addActionListener(e ->{
            String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
            int boxerId = -1;  // Initialize to a default value
            if(userInput == null){
                JOptionPane.showMessageDialog(frame, "User canceled the input.");
                return;
            }
            try{
                boxerId = Integer.parseInt(userInput);
                if(!(clist.boxerExists(boxerId))) {
                    JOptionPane.showMessageDialog(frame, "Boxer doesn't exist.");
                    return;
                }
            }catch(NumberFormatException E){
                JOptionPane.showMessageDialog(frame, "Wrong input provided.");
                return;
            }

            Object[] details = {
                    "Name", "Middle Name", "Surname", "Country",
                    "Age", "Gender", "Competitor Level", "Competitor Category","Scores Heavy (comma-separated)",
                    "Scores Middle (comma-separated)", "Scores Light (comma-separated)"
            };

            Object settingDetail = JOptionPane.showInputDialog(
                    frame,
                    "Select detail:",
                    "Details Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    details,
                    null
            );
            String setDetail = (String) settingDetail;
            if(setDetail == null){
                JOptionPane.showMessageDialog(frame, "User canceled the input.");
                return;
            }
            if(setDetail.equals("Competitor Category")){
                Category[] categories = Category.values();
                Category selectedCategory = (Category) JOptionPane.showInputDialog(
                        frame,
                        "Select Category:",
                        "Category Selection",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        categories,
                        null
                );
                if(String.valueOf(selectedCategory).equals("null")){
                    JOptionPane.showMessageDialog(frame, "User canceled the input.");
                    return;
                }
                listing.setText(clist.editBoxerDetails(boxerId, setDetail, String.valueOf(selectedCategory).toUpperCase()));
                listing.setEditable(false);
            } else if(setDetail.equals("Competitor Level")){
                Level[] lvl = Level.values();
                Level selectedLevel = (Level) JOptionPane.showInputDialog(
                        frame,
                        "Select Level:",
                        "Level Selection",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        lvl,
                        null
                );
                if(String.valueOf(selectedLevel).equals("null")){
                    JOptionPane.showMessageDialog(frame, "User canceled the input.");
                    return;
                }
                listing.setText(clist.editBoxerDetails(boxerId, setDetail, String.valueOf(selectedLevel).toUpperCase()));
                listing.setEditable(false);
            } else{
                String newValue = JOptionPane.showInputDialog("Enter new value for " + setDetail + ": ");
                if(newValue == null || newValue.equals("NULL")){
                    JOptionPane.showMessageDialog(frame, "User canceled the input.");
                    return;
                }
                listing.setText(clist.editBoxerDetails(boxerId, setDetail, newValue));
                listing.setEditable(false);
            }
        });

        editBoxerScore.addActionListener(e ->{
            try{
                String userInput = JOptionPane.showInputDialog("Enter boxer Id: ");
                if(userInput == null){
                    JOptionPane.showMessageDialog(frame, "User canceled the input.");
                    return;
                }
                int boxerId = Integer.parseInt(userInput);
                if(!(clist.boxerExists(boxerId))){
                    JOptionPane.showMessageDialog(frame, "Boxer doesn't exist.");
                    return;
                }
                String boxerScore = JOptionPane.showInputDialog("Enter boxer score (comma-separated): ");
                if(boxerScore == null){
                    JOptionPane.showMessageDialog(frame, "User canceled the input.");
                    return;
                }
                String[] scoreStrings = boxerScore.split(",");
                int[] boxerScores = new int[scoreStrings.length];
                for (int i = 0; i < scoreStrings.length; i++) {
                    try {
                        boxerScores[i] = Integer.parseInt(scoreStrings[i].trim());
                    } catch (NumberFormatException s) {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid integers.");
                        return;
                    }
                }
                JOptionPane.showMessageDialog(frame, clist.alterBoxerScores(boxerId, boxerScores));

            }catch(NumberFormatException E){
            JOptionPane.showMessageDialog(frame, "Invalid ID provided.");
        }
        });

        viewDetailsCategory.addActionListener(e ->{
            Category[] categories = Category.values();
            Category selectedCategory = (Category) JOptionPane.showInputDialog(
                    frame,
                    "Select Category:",
                    "Category Selection",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    categories,
                    null
            );
            listing.setText(clist.viewDetailsCategory(selectedCategory));
            listing.setEditable(false);
        });
        // Arrange the components on the battlesMenu
        ViewMenu.add(fullDetails);
        ViewMenu.add(shortDetails);
        ViewMenu.add(removeBoxer);
        ViewMenu.add(viewDetailsCategory);
        ViewMenu.add(editBoxerScore);
        ViewMenu.add(editBoxerDetails);

        // Arrange the components on the frame
        frame.setJMenuBar(menubar);
        // Update the UI
        frame.validate();
        frame.repaint();
    }
}