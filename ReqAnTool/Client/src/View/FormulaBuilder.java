package View;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class FormulaBuilder
	extends PanelBuilder
{

    private static final int GRID_WIDTH = 2;

	private int globalRowNumber;


	public FormulaBuilder()
	{
		myPanel = new JPanel();
		myPanel.setSize(200,500);
		myPanel.setLayout(new GridBagLayout());
		globalRowNumber = -1;
		textStyler = new DialogTextStyle();
	}

    @Override
    public JTextField addNamedTextField(String name, String content, boolean isEditable)
	{
        globalRowNumber++;

        addLeftNameTag(name);

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.gridx = 1;
		layoutConstraints.insets = new Insets(10,5,10,10);

        JTextField myTextField = new JTextField(10);
		myTextField.setEditable(isEditable);
        if(!myTextField.isEnabled())
		{
			myTextField.setBackground(null);
		}
        myTextField.setText(content);
        myPanel.add(myTextField,layoutConstraints);

        return myTextField;
    }

	@Override
    public JTextArea addNamedTextArea(String name, String content, boolean isEditable)
	{
        globalRowNumber++;

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        layoutConstraints.gridy = globalRowNumber;
        layoutConstraints.anchor = GridBagConstraints.LINE_START;
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(10,10,10,5);

        JLabel nameLabel = new JLabel(name);
        textStyler.styleAsTagedNameToArea(nameLabel);
        layoutConstraints.gridx = 0;
        layoutConstraints.gridwidth = GRID_WIDTH;
        myPanel.add(nameLabel,layoutConstraints);

        globalRowNumber++;

        JTextArea myTextArea = new JTextArea(5,20);	//Default-Werte, die geändert werden können/sollen von der Anwender-Klasse
        myTextArea.setText(content);
        myTextArea.setEditable(isEditable);
        if(!myTextArea.isEditable())
		{
			myTextArea.setBackground(null);
		}
        JScrollPane scrollableTextArea = new JScrollPane(myTextArea);
        layoutConstraints.gridy = globalRowNumber;
        layoutConstraints.gridwidth = GRID_WIDTH;
        layoutConstraints.gridx = 0;
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(10,10,10,10);
        myPanel.add(scrollableTextArea,layoutConstraints);

        return myTextArea;
    }

    @Override
    public void addTitle(String title)
	{
        globalRowNumber++;

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        layoutConstraints.gridy = globalRowNumber;
        layoutConstraints.anchor = GridBagConstraints.WEST;
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
        layoutConstraints.insets = new Insets(10,0,10,0);
        layoutConstraints.gridwidth = GRID_WIDTH;

        JLabel titleLabel = new JLabel(title,SwingConstants.CENTER);
        layoutConstraints.gridx = 0;
        myPanel.add(titleLabel,layoutConstraints);
    }

    @Override
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
			GridLayout myButtonLayout = new GridLayout(1,buttonNames.length);
			myButtonLayout.setHgap(10);
			JPanel myButtonPanel = new JPanel(myButtonLayout);
			for (int i = 0; i < myButtons.length; i++)
			{
				myButtons[i] = new JButton(buttonNames[i]);
				myButtons[i].setMaximumSize(new Dimension(150,50));
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

    @Override
    public JTextArea addText(String textContent)
	{
        globalRowNumber++;

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        layoutConstraints.gridy = globalRowNumber;
        layoutConstraints.anchor = GridBagConstraints.WEST;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.gridwidth = GRID_WIDTH;
		layoutConstraints.insets = new Insets(10,10,10,10);
        layoutConstraints.gridx = 0;

		JTextArea myText = new JTextArea(textContent);
		myText.setEditable(false);
		myText.setLineWrap(true);
		myText.setWrapStyleWord(true);
		myText.setBackground(null);
        textStyler.styleAsInformation(myText);
        ScrollPane pane = new ScrollPane();
        pane.add(myText);

        myPanel.add(pane, layoutConstraints);

        return myText;
    }

    @Override
    public JTable addTable(String name, String[][] elements, String[] columnNames)
	{
        globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,10,10,5);

		layoutConstraints.gridx = 0;
		JLabel nameLabel = new JLabel(name);
		textStyler.styleAsTagedNameToField(nameLabel);
		myPanel.add(nameLabel,layoutConstraints);

		layoutConstraints.gridx = 1;
        JTable myTable = new JTable(elements,columnNames);
        JScrollPane scrollableTable = new JScrollPane(myTable);
        myPanel.add(scrollableTable,layoutConstraints);

        return myTable;
    }

    @Override
    public TableSelectionPanel addTableSelection(String name, String[] selectionList, String[] defaultEntries)
	{
        globalRowNumber++;

        GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.PAGE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,10,10,5);
		
		layoutConstraints.gridx = 0;
		layoutConstraints.insets.top = 15;
		JLabel nameLabel = new JLabel(name);
		textStyler.styleAsTagedNameToField(nameLabel);
		myPanel.add(nameLabel,layoutConstraints);

		layoutConstraints.gridx = 1;
		layoutConstraints.insets.top = 10;
		TableSelectionPanel myTableSelection = new TableSelectionPanel(selectionList,defaultEntries);
		myPanel.add(myTableSelection,layoutConstraints);

        return myTableSelection;
    }

	@Override
	public void addImage(Path imagePath)
	{
		globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.weightx = 0;
		layoutConstraints.insets = new Insets(5,10,5,10);

		ImageLabel myImage = new ImageLabel(imagePath,50,50);
		myPanel.add(myImage,layoutConstraints);
	}

	@Override
	public SliderPanel addNamedScrollBarPanel(String name, int initValue, int minimumValue, int maximumValue)
	{
		globalRowNumber++;

		addLeftNameTag(name);

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = 1;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,5,10,10);

		SliderPanel mySliderPanel = new SliderPanel(initValue,minimumValue,maximumValue);

		myPanel.add(mySliderPanel,layoutConstraints);

		return mySliderPanel;
	}

	@Override
	public void addNewSection()
	{
		globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridwidth = 2;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,10,10,10);

		JSeparator mySeparator = new JSeparator(SwingConstants.HORIZONTAL);
		myPanel.add(mySeparator,layoutConstraints);
	}

	@Override
	public JComboBox<String> addNamedDropdownList(String name, String[] options)
	{
		globalRowNumber++;

		addLeftNameTag(name);

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = 1;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,5,10,10);

		JComboBox<String> myDropdownList = new JComboBox<>(options);
		myDropdownList.setSelectedIndex(0);

		myPanel.add(myDropdownList,layoutConstraints);

		return myDropdownList;
	}

	@Override
	public void addPanel(JPanel newPanel)
	{
		globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = 0;
		layoutConstraints.gridwidth = GRID_WIDTH;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,10,10,10);

		myPanel.add(newPanel, layoutConstraints);
	}

	private void addLeftNameTag(String name)
	{
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,10,10,5);

		JLabel nameLabel = new JLabel(name);
		textStyler.styleAsTagedNameToField(nameLabel);
		layoutConstraints.gridx = 0;
		myPanel.add(nameLabel,layoutConstraints);
	}


}
