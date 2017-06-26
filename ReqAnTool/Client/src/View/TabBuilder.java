package View;

import Logging.ILogger;
import Logging.ILoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.nio.file.Path;

public class TabBuilder
	extends PanelBuilder
{

	private static final int GRID_WIDTH = 2;

	private int globalRowNumber;
	private int globalColumnNumber;
	private int section;
	private boolean splitNextUp;
	private ILogger myLogger;

	public TabBuilder()
	{
		myPanel = new JPanel();
		myPanel.setLayout(new GridBagLayout());
		myPanel.setOpaque(false);
		globalRowNumber = -1;
		globalColumnNumber = 0;
		section = 0;
		splitNextUp = false;
		textStyler = new TabTextStyle();
		myLogger = ILoggerFactory.getInstance().createLogger();
	}

    @Override
    public void addTitle(String titleText)
    {
        globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = section*GRID_WIDTH+globalColumnNumber;
		layoutConstraints.anchor = GridBagConstraints.WEST;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,0,10,0);
		layoutConstraints.gridwidth = GRID_WIDTH;

		JLabel nameLabel = new JLabel(titleText,SwingConstants.CENTER);
		textStyler.styleAsTitle(nameLabel);
		myPanel.add(nameLabel,layoutConstraints);
    }

    @Override
    public JTextArea addText(String textContent)
	{
		myLogger.error("This function is not implemented yet - addNamedDropdownList - DialogBuilder");
		return null;
    }

    @Override
    public JButton[] addButtonBar(String[] buttonNames)
	{
		globalColumnNumber++;
		if(!splitNextUp)
		{
			globalRowNumber++;
		}

		JButton[] myButtons;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = GRID_WIDTH*section+globalColumnNumber;
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.gridheight = 100;
		layoutConstraints.weighty = 1.0f;

		if(buttonNames != null && buttonNames.length != 0)
		{
			JPanel myButtonPanel = new JPanel();
			myButtonPanel.setLayout(new GridBagLayout());
			myButtonPanel.setOpaque(false);
			GridBagConstraints innerConstraints = new GridBagConstraints();
			innerConstraints.gridx = 0;
			innerConstraints.fill = GridBagConstraints.HORIZONTAL;
			innerConstraints.insets = new Insets(10,10,10,10);
			innerConstraints.ipady = 10;

			myButtons = new JButton[buttonNames.length];
			for (int i = 0; i < myButtons.length; i++)
			{
				myButtons[i] = new JButton(buttonNames[i]);
				if(buttonNames.length >= 6)
				{
					//Bei mehr als 6 Buttons nebeneinander anordnen
					innerConstraints.gridy = i/2;
					innerConstraints.gridx = i%2;
					//Bei ungerader Anzahl wird der letzter Button mittig platziert
					if(myButtons.length % 2 == 1 && i == myButtons.length-1)
					{
						innerConstraints.gridwidth = 2;
						innerConstraints.fill = GridBagConstraints.NONE;
						innerConstraints.anchor = GridBagConstraints.CENTER;
					}
				}
				else
				{
					innerConstraints.gridy = i;
				}
				myButtonPanel.add(myButtons[i], innerConstraints);
			}


			myPanel.add(myButtonPanel, layoutConstraints);
		}
		else
		{
			myButtons = new JButton[0];
		}

		return myButtons;
    }

    @Override
    public JTextField addNamedTextField(String name, String content, boolean isEditable)
	{
		globalRowNumber++;

		addLeftNameTag(name);

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.gridx = section*GRID_WIDTH+globalColumnNumber+1;
		layoutConstraints.insets = new Insets(10,5,10,10);
		layoutConstraints.weighty = 0.0f;

		JTextField myTextField = new JTextField(20);
		myTextField.setEditable(isEditable);
		myTextField.setText(content);
		myPanel.add(myTextField,layoutConstraints);

		return myTextField;
    }

    @Override
    public JTextArea addNamedTextArea(String name, String content, boolean isEditable)
	{
		globalRowNumber++;
		splitNextUp = true;

		GridBagConstraints layoutConstraints = getDefaultConstraints();

		if(name != null && name.length() > 0)
		{
			JLabel nameLabel = new JLabel(name);
			textStyler.styleAsTagedNameToArea(nameLabel);
			myPanel.add(nameLabel,layoutConstraints);

			globalRowNumber++;
			layoutConstraints.gridy = globalRowNumber;
		}

		JTextArea myTextArea = new JTextArea(content);
		myTextArea.setWrapStyleWord(true);
		myTextArea.setLineWrap(true);
		myTextArea.setEditable(isEditable);
		if(!myTextArea.isEditable())
		{
			myTextArea.setBackground(null);
		}
		JScrollPane scrollableTextArea = new JScrollPane(myTextArea);
		myPanel.add(scrollableTextArea,layoutConstraints);

        return myTextArea;
    }

    @Override
    public JTable addTable(String name, String[][] elements, String[] columnNames)
	{
		globalRowNumber++;
		splitNextUp = true;

		GridBagConstraints layoutConstraints = getDefaultConstraints();

		if(name != null && name.length() > 0)
		{
			JLabel nameLabel = new JLabel(name);
			textStyler.styleAsTagedNameToArea(nameLabel);
			myPanel.add(nameLabel,layoutConstraints);

			globalRowNumber++;
			layoutConstraints.gridy = globalRowNumber;
		}


		boolean showHeader = true;
		if(columnNames == null)
		{
			showHeader = false;
			columnNames = new String[elements[0].length];
			for(int i=0;i<columnNames.length;i++)
			{
				columnNames[i] = "-";
			}
		}

		TableModel myTableModel = new DefaultTableModel(elements,columnNames)
		{
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex)
			{
				return false;
			}
		};
		JTable myTable = new JTable(myTableModel);
		if(!showHeader)
		{
			myTable.setTableHeader(null);
		}
		JScrollPane scrollableTable = new JScrollPane(myTable);
		myPanel.add(scrollableTable,layoutConstraints);

        return myTable;
    }

    @Override
    public TableSelectionPanel addTableSelection(String name, String[] selectionList, String[] defaultEntries)
	{
		myLogger.error("This function is not implemented yet - addTableSelection - TabBuilder");
        return null;
    }

	@Override
	public void addImage(Path imagePath, boolean isGIF)
	{
		globalRowNumber++;
		globalColumnNumber++;

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		ImageLabel myImage = new ImageLabel(imagePath,75,75, isGIF);
		myPanel.add(myImage,layoutConstraints);
		globalRowNumber--;
	}

	@Override
	public SliderPanel addNamedScrollBarPanel(String name, int initValue, int minimumValue, int maximumValue)
	{
		myLogger.error("This function is not implemented yet - addNamedScrollBarPanel - TabBuilder");
		return null;
	}

	@Override
	public void addNewSection()
	{
		section++;
		globalRowNumber = -1;
		globalColumnNumber = 0;
	}

	@Override
	public JComboBox<String> addNamedDropdownList(String name, String[] options)
	{
		myLogger.error("This function is not implemented yet - addNamedDropdownList - TabBuilder");
		return null;
	}

	@Override
	public void addPanel(JPanel newPanel)
	{
		globalRowNumber++;
		GridBagConstraints layoutConstraints = getDefaultConstraints();
		myPanel.add(newPanel, layoutConstraints);
	}

	private void addLeftNameTag(String name)
	{
		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,10,10,5);
		layoutConstraints.weightx = 0.0f;
		layoutConstraints.weighty = 0.0f;

		JLabel nameLabel = new JLabel(name);
		textStyler.styleAsTagedNameToField(nameLabel);
		myPanel.add(nameLabel,layoutConstraints);
	}

	private GridBagConstraints getDefaultConstraints()
	{
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = section*GRID_WIDTH+globalColumnNumber;
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10,10,10,10);
		layoutConstraints.weightx = 1.0f;
		layoutConstraints.weighty = 1.0f;
		return layoutConstraints;
	}

}
