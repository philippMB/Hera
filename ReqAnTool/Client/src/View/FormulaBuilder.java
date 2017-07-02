package View;

import Logging.ILogger;
import Logging.ILoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

public class FormulaBuilder
	extends PanelBuilder
{

    private static final int GRID_WIDTH = 2;

	private int globalRowNumber;
	private ILogger myLogger;
	private boolean hasTitle;
	private boolean addedPanel;
	private int columnSection;


	public FormulaBuilder()
	{
		myPanel = new JPanel();
		myPanel.setSize(200,500);
		myPanel.setLayout(new GridBagLayout());
		globalRowNumber = -1;
		textStyler = new DialogTextStyle();
		myLogger = ILoggerFactory.getInstance().createLogger();
		hasTitle = false;
		addedPanel = false;
		columnSection = 0;
	}

    @Override
    public JTextField addNamedTextField(String name, String content, boolean isEditable)
	{
        globalRowNumber++;

        addLeftNameTag(name);

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.gridx += 1;
		layoutConstraints.insets = new Insets(10,5,10,10);

        JTextField myTextField = new JTextField(10);
		myTextField.setEditable(isEditable);
        myTextField.setText(content);
        myPanel.add(myTextField,layoutConstraints);

        return myTextField;
    }

	@Override
    public JTextArea addNamedTextArea(String name, String content, boolean isEditable)
	{
        globalRowNumber++;

        GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.gridwidth = GRID_WIDTH;
        layoutConstraints.insets = new Insets(10,10,10,5);

        JLabel nameLabel = new JLabel(name);
        textStyler.styleAsTagedNameToArea(nameLabel);
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
        layoutConstraints = getDefaultConstraints();
        layoutConstraints.gridwidth = GRID_WIDTH;
        myPanel.add(scrollableTextArea,layoutConstraints);

        return myTextArea;
    }

    @Override
    public void addTitle(String title)
	{
        globalRowNumber++;

        GridBagConstraints layoutConstraints = getDefaultConstraints();
        layoutConstraints.anchor = GridBagConstraints.WEST;
        layoutConstraints.insets = new Insets(10,0,10,0);
        layoutConstraints.gridwidth = GRID_WIDTH;

        JLabel titleLabel = new JLabel(title,SwingConstants.CENTER);
        if(!hasTitle)
		{
			textStyler.styleAsTitle(titleLabel);
		}
		else
		{
			textStyler.styleAsSubtitle(titleLabel);
		}
        myPanel.add(titleLabel,layoutConstraints);
    }

    @Override
    public JButton[] addButtonBar(String[] buttonNames)
	{
    	globalRowNumber++;

		JButton[] myButtons;

        GridBagConstraints layoutConstraints = getDefaultConstraints();
        layoutConstraints.anchor = GridBagConstraints.LINE_END;
        layoutConstraints.gridwidth = GRID_WIDTH;

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

        GridBagConstraints layoutConstraints = getDefaultConstraints();
        layoutConstraints.anchor = GridBagConstraints.WEST;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.gridwidth = GRID_WIDTH;

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
		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.insets = new Insets(10,10,10,5);

		if(name != null)
		{
			addLeftNameTag(name);
			layoutConstraints.gridx += 1;
		}
		else
		{
			layoutConstraints.gridwidth = GRID_WIDTH;
			layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
			layoutConstraints.weightx = 1.0f;
			layoutConstraints.weighty = 1.0f;
		}
        JTable myTable = new JTable(elements,columnNames);
		myTable.setPreferredScrollableViewportSize(new Dimension(100,100));
        JScrollPane scrollableTable = new JScrollPane(myTable);
        myPanel.add(scrollableTable,layoutConstraints);

        return myTable;
    }

    @Override
    public TableSelectionPanel addTableSelection(String name, String[] selectionList, String[] defaultEntries)
	{
        globalRowNumber++;

        GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.anchor = GridBagConstraints.PAGE_START;
		layoutConstraints.insets = new Insets(15,10,10,5);

		JLabel nameLabel = new JLabel(name);
		textStyler.styleAsTagedNameToField(nameLabel);
		myPanel.add(nameLabel,layoutConstraints);

		layoutConstraints.gridx += 1;
		layoutConstraints.insets.top = 10;
		TableSelectionPanel myTableSelection = new TableSelectionPanel(selectionList,defaultEntries);
		myPanel.add(myTableSelection,layoutConstraints);

        return myTableSelection;
    }

	@Override
	public void addImage(Path imagePath, boolean isGIF)
	{
		globalRowNumber++;

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.weightx = 0;
		layoutConstraints.insets = new Insets(5,10,5,10);

		ImageLabel myImage = new ImageLabel(imagePath,50,50, isGIF);
		myPanel.add(myImage,layoutConstraints);
	}

	@Override
	public SliderPanel addNamedScrollBarPanel(String name, int initValue, int minimumValue, int maximumValue)
	{
		globalRowNumber++;

		addLeftNameTag(name);

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.gridx += 1;
		layoutConstraints.insets = new Insets(10,5,10,10);

		SliderPanel mySliderPanel = new SliderPanel(initValue,minimumValue,maximumValue);

		myPanel.add(mySliderPanel,layoutConstraints);

		return mySliderPanel;
	}

	@Override
	public void addNewSection()
	{
		globalRowNumber++;

		JSeparator mySeparator;
		GridBagConstraints layoutConstraints = getDefaultConstraints();
		if(globalRowNumber >= 6 || addedPanel)
		{
			mySeparator = new JSeparator(SwingConstants.VERTICAL);
			mySeparator.setMinimumSize(new Dimension(10,10));
			mySeparator.setPreferredSize(new Dimension(10,10));
			layoutConstraints.gridy = 0;
			layoutConstraints.gridx += 2;
			layoutConstraints.gridheight = GridBagConstraints.REMAINDER;
			layoutConstraints.fill = GridBagConstraints.VERTICAL;
			layoutConstraints.weighty = 1;
			globalRowNumber = -1;
			columnSection++;
			addedPanel = false;
		}
		else
		{
			mySeparator = new JSeparator(SwingConstants.HORIZONTAL);
			layoutConstraints.gridwidth = GRID_WIDTH;
		}
		myPanel.add(mySeparator,layoutConstraints);
	}

	@Override
	public JComboBox<String> addNamedDropdownList(String name, String[] options)
	{
		globalRowNumber++;

		addLeftNameTag(name);

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.gridx += 1;
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
		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.gridwidth = GRID_WIDTH;
		myPanel.add(newPanel, layoutConstraints);
		addedPanel = true;
	}

	private void addLeftNameTag(String name)
	{
		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.insets = new Insets(10,10,10,5);

		JLabel nameLabel = new JLabel(name);
		textStyler.styleAsTagedNameToField(nameLabel);
		myPanel.add(nameLabel,layoutConstraints);
	}

	@Override
	public JPanel getResult()
	{
		myPanel = new BorderDecorater(myPanel);
		return super.getResult();
	}

	private GridBagConstraints getDefaultConstraints()
	{
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = columnSection * (GRID_WIDTH + 1);
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.insets = new Insets(10,10,10,10);
		return layoutConstraints;
	}

}
