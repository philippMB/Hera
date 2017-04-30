package View;

import javax.swing.*;
import java.nio.file.Path;
import java.util.Vector;

public abstract class JPanelBuilder
{

    protected JPanel myPanel;
    protected TextStyleBridge textStyler;


    public JPanel getResult()
    {
        return myPanel;
    }

    public abstract void addTitle(String titleText);
    
    public abstract JTextArea addText(String textContent);

    public abstract JButton[] addButtonBar(String[] buttonNames);

    public JTextField addNamedTextField(String name, String content)
    {
        return addNamedTextField(name,content,true);
    }

    public abstract JTextField addNamedTextField(String name, String content, boolean isEditable);
    
    public JTextArea addNamedTextArea(String name, String content)
    {
        return addNamedTextArea(name,content,true);
    }

    public abstract JTextArea addNamedTextArea(String name, String content, boolean isEditable);

    public JTable addTable(String name, String[][] elements)
    {
        return addTable(name,elements,null);
    }

    public abstract JTable addTable(String name, String[][] elements, String[] columnNames);
    
    public abstract TableSelectionPanel addTableSelection(String name, String[] selectionList, String[] defaultEntries);

    public abstract void addImage(Path imagePath);

}
