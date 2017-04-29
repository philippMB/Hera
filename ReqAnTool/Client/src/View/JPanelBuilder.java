package View;

import javax.swing.*;

public abstract class JPanelBuilder {
    
    protected JPanel _myPanel;
    protected TextStyleBridge _textStyler;


    public JPanel getResult() {
        return _myPanel;
    }

    public abstract void addTitle(String titleText);
    
    public abstract void addText(String textContent);

    public abstract JButton[] addButtonBar(String[] buttonNames);
    
    public abstract JTextField addNamedTextField(String description, String content);
    
    public abstract JTextArea addNamedTextArea(String description, String content);
    
    public abstract JTable addTable(String[][] elements);
    
    public abstract JTable addTableSelection(String description, String[] selectionList, String[] defaultEntries);
}
