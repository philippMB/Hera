package View;

import javax.swing.*;
import java.awt.*;

public class FormulaBuilder extends JPanelBuilder {

    int _globalRowNumber;

    public FormulaBuilder(){
        _myPanel = new JPanel();
        _myPanel.setLayout(new GridBagLayout());
        _globalRowNumber = -1;
        _textStyler = new DialogTextStyle();
    }

    @Override
    public JTextField addNamedTextField(String description, String content){
        _globalRowNumber++;

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = _globalRowNumber;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,5);

        JLabel descLabel = new JLabel(description);
        _textStyler.styleAsTagedName(descLabel);
        constraints.gridx = 1;
        _myPanel.add(descLabel,constraints);

        JTextField textField = new JTextField(10);
        textField.setText(content);
        constraints.gridx = 2;
        constraints.insets = new Insets(10,5,10,10);
        _myPanel.add(textField,constraints);

        return textField;
    }
    
    @Override
    public JTextArea addNamedTextArea(String description, String content){

        return null;
    }


    @Override
    public void addTitle(String s) {
        _globalRowNumber++;

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = _globalRowNumber;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,0,10,0);
        constraints.gridwidth = 2;

        JLabel descLabel = new JLabel(s,SwingConstants.CENTER);
        constraints.gridx = 1;
        _myPanel.add(descLabel,constraints);
    }

    @Override
    public JButton[] addButtonBar(String[] button_names) {
        // TODO Implement this method
        return null;
    }

    @Override
    public void addText(String textContent) {
        // TODO Implement this method
    }

    @Override
    public JTable addTable(String[][] elements) {
        // TODO Implement this method
        return null;
    }

    @Override
    public JTable addTableSelection(String description, String[] selectionList, String[] defaultEntries) {
        // TODO Implement this method
        return null;
    }
}
