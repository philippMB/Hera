package View;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

/**
 * Ist ein Erzeugungsmuster Builder, der komplexere Zusammenhaenge fuer andere Klassen baut.
 * Hier sollen also Text: Textfield und Text | Button Button Button erzeugt werden koennen.
 * Rueckgabe koennen JPanels sein.
 * Quelle: https://sourcemaking.com/design_patterns/builder
 */
public class DialogBuilder
	extends PanelBuilder
{

	private static final int GRID_WIDTH = 2;

    private int globalRowNumber;
    private boolean imageAdded;


    public DialogBuilder()
	{
        myPanel = new JPanel();
        myPanel.setLayout(new GridBagLayout());
        myPanel.setBackground(null);
        globalRowNumber = -1;
        imageAdded = false;
        textStyler = new DialogTextStyle();
    }

    public JButton[] addButtonBar(String[] buttonNames)
	{
		globalRowNumber++;

		JButton[] myButtons;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.LINE_END;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.gridwidth = GRID_WIDTH;
		layoutConstraints.gridx = 0;

		if(buttonNames != null && buttonNames.length != 0)
		{
			myButtons = new JButton[buttonNames.length];
			JPanel myButtonPanel = new JPanel(new GridLayout(1,buttonNames.length));
			for (int i = 0; i < myButtons.length; i++)
			{
				myButtons[i] = new JButton(buttonNames[i]);
				myButtonPanel.add(myButtons[i]);
			}
			myButtonPanel.setAlignmentX(JPanel.RIGHT_ALIGNMENT);

			myPanel.add(myButtonPanel, layoutConstraints);
		}
		else
		{
			myButtons = new JButton[0];
		}

		return myButtons;
    }

    public JTextArea addText(String textContent)
	{
    	if(!imageAdded)
		{
			globalRowNumber++;
		}

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		if(!imageAdded)
		{
			layoutConstraints.gridwidth = 2;
			layoutConstraints.gridx = 0;
		}
		else
		{
			layoutConstraints.gridwidth = 1;
			layoutConstraints.gridx = 1;
		}

		JTextArea myText = new JTextArea(textContent);
		myText.setColumns(18);
		myText.setEditable(false);
		myText.setLineWrap(true);
		myText.setWrapStyleWord(true);
		myText.setBackground(null);
		JPanel pane = new JPanel();
		pane.add(myText);
		myPanel.add(pane, layoutConstraints);

		return myText;
    }

    @Override
    public void addTitle(String title)
	{

		globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.gridwidth = 2;
		layoutConstraints.gridx = 0;

		JLabel titleLabel = new JLabel(title);
		textStyler.styleAsTitle(titleLabel);
		myPanel.add(titleLabel, layoutConstraints);
    }

    @Override
    public JTextField addNamedTextField(String name, String content, boolean isEditable)
	{
        // TODO Implement this method

        return null;
    }

    @Override
    public JTextArea addNamedTextArea(String name, String content, boolean isEditable)
	{
        // TODO Implement this method

        return null;
    }

    @Override
    public JTable addTable(String name, String[][] elements, String[] columnNames)
	{
        // TODO Implement this method
        return null;
    }

    @Override
    public TableSelectionPanel addTableSelection(String name, String[] selectionList, String[] defaultEntries)
	{
        // TODO Implement this method

        return null;
    }

	@Override
	public void addImage(Path imagePath)
	{
		globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.weightx = 0;
		layoutConstraints.insets = new Insets(5,5,5,0);

		ImageLabel myImage = new ImageLabel(imagePath,50,50);
		myPanel.add(myImage,layoutConstraints);
		imageAdded = true;
	}

	@Override
	public SliderPanel addNamedScrollBarPanel(String name, int initValue, int minimumValue, int maximumValue)
	{
		return null;
	}

	@Override
	public void addNewSection()
	{

	}

	@Override
	public JComboBox<String> addNamedDropdownList(String name, String[] options)
	{
		return null;
	}

	@Override
	public void addPanel(JPanel newPanel)
	{

	}

}
