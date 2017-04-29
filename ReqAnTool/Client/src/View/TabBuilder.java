package View;

import javax.swing.*;

public class TabBuilder extends JPanelBuilder {
    
    @Override
    public void addTitle(String titleText) {
        // TODO Implement this method
    }

    @Override
    public void addText(String textContent) {
        // TODO Implement this method
    }

    @Override
    public JButton[] addButtonBar(String[] buttonNames) {
        // TODO Implement this method
        return new JButton[0];
    }

    @Override
    public JTextField addNamedTextField(String description, String content) {
        // TODO Implement this method

        return null;
    }

    @Override
    public JTextArea addNamedTextArea(String description, String content) {
        // TODO Implement this method

        return null;
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
