package View;

import com.sun.deploy.panel.JreTableModel;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.nio.file.Path;

public class TabBuilder
	extends JPanelBuilder
{

	private int globalRowNumber;
	private int globalColumnNumber;
	private boolean splitNextUp;

	public TabBuilder()
	{
		myPanel = new JPanel();
		myPanel.setLayout(new GridBagLayout());
		globalRowNumber = -1;
		globalColumnNumber = -1;
		splitNextUp = false;
		textStyler = new TabTextStyle();
	}

    @Override
    public void addTitle(String titleText)
    {
        globalRowNumber++;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.anchor = GridBagConstraints.WEST;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,0,10,0);
		layoutConstraints.gridwidth = 2;

		JLabel nameLabel = new JLabel(titleText,SwingConstants.CENTER);
		textStyler.styleAsTitle(nameLabel);
		layoutConstraints.gridx = globalColumnNumber;
		myPanel.add(nameLabel,layoutConstraints);
    }

    @Override
    public JTextArea addText(String textContent)
	{
        // TODO Implement this method
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
		layoutConstraints.gridx = globalColumnNumber;
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;

		if(buttonNames != null && buttonNames.length != 0)
		{
			JPanel myButtonPanel = new JPanel();
			myButtonPanel.setLayout(new GridBagLayout());
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
        // TODO Implement this method

        return null;
    }

    @Override
    public JTextArea addNamedTextArea(String name, String content, boolean isEditable)
	{
		globalRowNumber++;
		globalColumnNumber = 0;
		splitNextUp = true;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = globalColumnNumber;
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10,10,10,10);
		layoutConstraints.weightx = 1.0f;
		layoutConstraints.weighty = 1.0f;

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
		globalColumnNumber = 0;
		splitNextUp = true;

		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = globalColumnNumber;
		layoutConstraints.anchor = GridBagConstraints.CENTER;
		layoutConstraints.fill = GridBagConstraints.BOTH;
		layoutConstraints.insets = new Insets(10,10,10,10);
		layoutConstraints.weightx = 1.0f;
		layoutConstraints.weighty = 1.0f;

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
        // TODO Implement this method

        return null;
    }

	@Override
	public void addImage(Path imagePath)
	{

	}

}
