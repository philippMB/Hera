package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.ITextFacade;

import javax.swing.*;
import java.nio.file.Path;
import java.util.Arrays;

public abstract class PanelBuilder
{

    protected JPanel myPanel;
    protected TextStyleBridge textStyler;


    public JPanel getResult()
    {
        return myPanel;
    }

    public abstract void addTitle(String titleText);
    
    public abstract JTextArea addText(String textContent);

    public JButton[] addButtonBar(ViewActions[] buttonActions)
    {
		String[] buttonNames = new String[buttonActions.length];
		ITextFacade myTextBundle = ITextFacade.getInstance();

        for(int i=0;i<buttonNames.length;i++)
        {
            buttonNames[i] = myTextBundle.getButtonText( buttonActions[i] );
        }

        return addButtonBar(buttonNames);
    }

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

    public void addImage(Path imagePath)
    {
    	addImage(imagePath, false);
	}

	public abstract void addImage(Path imagePath, boolean isGIF);

	public abstract SliderPanel addNamedScrollBarPanel(String name, int initValue, int minimumValue, int maximumValue);

    public abstract void addNewSection();

    public abstract JComboBox<String> addNamedDropdownList(String name, String[] options);

    public abstract void addPanel(JPanel newPanel);

}
