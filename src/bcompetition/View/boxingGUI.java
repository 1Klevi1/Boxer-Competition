package bcompetition.View;

import bcompetition.Model.Category;
import bcompetition.Model.Level;
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
    private final JFrame frame = new JFrame("Game GUI");
    private final JPanel eastPanel = new JPanel();
    private final JPanel outputPanel = new JPanel();
    private final JMenuBar menubar = new JMenuBar();
    private final JTextArea listing = new JTextArea();
    private final JMenu ViewMenu = new JMenu("Boxer Menu");
    private final JButton clearButton = new JButton("Clear");
    private final JButton viewStateButton = new JButton("View State");
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
    public JFrame getFrame() {
        return frame;
    }

    public JPanel getEastPanel() {
        return eastPanel;
    }

    public JPanel getOutputPanel() {
        return outputPanel;
    }

    public JMenuBar getMenubar() {
        return menubar;
    }

    public JTextArea getListing() {
        return listing;
    }

    public JMenu getViewMenu() {
        return ViewMenu;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getViewStateButton() {
        return viewStateButton;
    }

    public JMenuItem getFullDetails() {
        return fullDetails;
    }

    public JMenuItem getShortDetails() {
        return shortDetails;
    }

    public JMenuItem getRemoveBoxer() {
        return removeBoxer;
    }

    public JMenuItem getEditBoxerScore() {
        return editBoxerScore;
    }

    public JMenuItem getEditBoxerDetails() {
        return editBoxerDetails;
    }

    public JMenuItem getViewDetailsCategory() {
        return viewDetailsCategory;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JButton getViewTable() {
        return viewTable;
    }

    /**
     * Create the Swing frame and its content.
     */
    public void makeFrame() {
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
        viewTable.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewTable.setPreferredSize(buttonSize); // Set the preferred size
        eastPanel.add(viewTable);

        // Set up the view button
        viewStateButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewStateButton.setForeground(Color.WHITE);
        viewStateButton.setBackground(Color.BLUE);

        // Set up the view table button
        viewTable.setFont(new Font("Arial", Font.BOLD, 16));
        viewTable.setForeground(Color.WHITE);
        viewTable.setBackground(Color.BLUE);

        // Set up the clear button
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(Color.WHITE);
        clearButton.setBackground(Color.BLUE);

        // Set minimum sizes for the components
        eastPanel.setMinimumSize(new Dimension(867, 600)); // Adjust as needed

        // Set the preferred size of the frame
        frame.setPreferredSize(new Dimension(1000, 600)); // Adjust as needed
        frame.pack();

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
    public void makeMenuBar() {
        // Create a menubar
        menubar.setLayout(new BoxLayout(menubar, BoxLayout.X_AXIS));
        menubar.setBackground(Color.WHITE);
        menubar.add(Box.createHorizontalStrut(10));
        ViewMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        menubar.add(ViewMenu);
        menubar.add(Box.createHorizontalStrut(10));
        menubar.setVisible(true);

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