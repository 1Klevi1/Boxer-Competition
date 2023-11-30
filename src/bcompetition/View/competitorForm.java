package bcompetition.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class competitorForm extends JPanel {

    private JTextField idField;
    private JTextField detailsField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField countryField;
    private JTextField levelField;
    private JTextField categoryField;
    private JTextField scoresField;
    private JButton addButton;
    private JButton viewButton;


    public competitorForm() {

        JLabel idLabel = new JLabel("ID:");
        JLabel detailsLabel = new JLabel("Details:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel genderLabel = new JLabel("Gender:");
        JLabel countryLabel = new JLabel("Country:");
        JLabel levelLabel = new JLabel("Level:");
        JLabel categoryLabel = new JLabel("Category:");
        JLabel scoresLabel = new JLabel("Scores (comma-separated):");

        idField = new JTextField(25);
        detailsField = new JTextField(25);
        ageField = new JTextField(25);
        genderField = new JTextField(25);
        countryField = new JTextField(25);
        levelField = new JTextField(25);
        categoryField = new JTextField(25);
        scoresField = new JTextField(25);

        addButton = new JButton("Add Competitor");
        addButton.setPreferredSize(new Dimension(278, 40));

        viewButton = new JButton("View All Competitors");
        viewButton.setPreferredSize(new Dimension(278, 40));

        Insets buttonInset = new Insets(20,0,0,0);

        setLayout(new GridLayout(0, 2, 0, 10));  // 0 rows (variable), 2 columns, no horizontal gap, vertical gap of 10 pixels

        addLabelAndField(idLabel, idField);
        addLabelAndField(detailsLabel, detailsField);
        addLabelAndField(ageLabel, ageField);
        addLabelAndField(genderLabel, genderField);
        addLabelAndField(countryLabel, countryField);
        addLabelAndField(levelLabel, levelField);
        addLabelAndField(categoryLabel, categoryField);
        addLabelAndField(scoresLabel, scoresField);

// Add buttons with proper spacing
        addButton(addButton, buttonInset);
        addButton(viewButton, buttonInset);
    }
    private void addLabelAndField(JLabel label, JTextField field) {
        add(label);
        add(field);
    }
    private void addButton(JButton button, Insets inset) {
        add(button);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = inset;
        add(new JLabel(), gridBagConstraints);  // Empty label for vertical spacing
    }
    // getters
    public String getIdField() {
        return idField.getText();
    }

    public String getDetailsField() {
        return detailsField.getText();
    }

    public String getAgeField() {
        return ageField.getText();
    }

    public String getGenderField() {
        return genderField.getText();
    }

    public String getCountryField() {
        return countryField.getText();
    }

    public String getLevelField() {
        return levelField.getText();
    }

    public String getCategoryField() {
        return categoryField.getText();
    }

    public String getScoresField() {
        return scoresField.getText();
    }

    public void submitUsers(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewUsers(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            idField.setText("");
            detailsField.setText("");
            ageField.setText("");
            genderField.setText("");
            countryField.setText("");
            levelField.setText("");
            categoryField.setText("");
            scoresField.setText("");

        }
    }
}
