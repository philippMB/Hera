package View;

import Logging.ILogger;
import Logging.ILoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;

/**
 * This class is based on {@link PanelBuilder} and adjusted to dialog views. Its {@link JPanel} layout is based on
 * {@link GridBagLayout}. A speciality is the support to tag a image next to the dialog message. The buttons are
 * bead horizontal.
 * <p>
 *     <b>CAUTION</b> - not all functions are implemented yet due to time bounds.
 *
 * @author 9045534
 * @version 1.0
 */
public class DialogBuilder
	extends PanelBuilder
{

	private static final int GRID_WIDTH = 2;

    private int globalRowNumber;
    private boolean imageAdded;
    private ILogger myLogger;


    public DialogBuilder()
	{
        myPanel = new JPanel();
        myPanel.setLayout(new GridBagLayout());
        myPanel.setBackground(null);
        globalRowNumber = -1;
        imageAdded = false;
        textStyler = new SubWindowTextStyler();
        myLogger = ILoggerFactory.getInstance().createLogger();
    }

	/**
	 * {@inheritDoc}
	 * The buttons are bread horizontal.
	 */
	@Override
    public JButton[] addButtonBar(String[] buttonNames)
	{
		globalRowNumber++;

		JButton[] myButtons;

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.fill = GridBagConstraints.NONE;
		layoutConstraints.anchor = GridBagConstraints.LINE_END;
		layoutConstraints.gridwidth = GRID_WIDTH;
		layoutConstraints.insets = new Insets(0,0,0,0);

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

	/**
	 * {@inheritDoc}
	 * If a image was added before the text will be placed next to it.
	 */
	@Override
    public JTextArea addText(String textContent)
	{
    	if(!imageAdded)
		{
			globalRowNumber++;
		}

		GridBagConstraints layoutConstraints = getDefaultConstraints();
    	layoutConstraints.insets = new Insets(0,0,0,0);
		if(!imageAdded)
		{
			layoutConstraints.gridwidth = GRID_WIDTH;
			layoutConstraints.gridx = 0;
		}
		else
		{
			layoutConstraints.gridwidth = 1;
			layoutConstraints.gridx = 1;
		}

		JTextArea myText = new JTextArea(textContent);
		myText.setColumns(18);
		myText.setRows(3);
		myText.setEditable(false);
		myText.setLineWrap(true);
		myText.setWrapStyleWord(true);
		myText.setBackground(null);
		JPanel pane = new JPanel();
		pane.add(myText);
		myPanel.add(pane, layoutConstraints);

		return myText;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
    public void addTitle(String title)
	{

		globalRowNumber++;

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.insets = new Insets(0,0,0,0);
		layoutConstraints.gridwidth = GRID_WIDTH;

		JLabel titleLabel = new JLabel(title);
		textStyler.styleAsTitle(titleLabel);
		myPanel.add(titleLabel, layoutConstraints);
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
    public JTextField addNamedTextField(String name, String content, boolean isEditable)
	{
		globalRowNumber++;

		addLeftNameTag(name);

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.gridx = 1;
		layoutConstraints.insets = new Insets(10,5,10,10);

		JTextField myTextField = new JTextField(10);
		myTextField.setEditable(isEditable);
		myTextField.setText(content);
		myPanel.add(myTextField,layoutConstraints);

		return myTextField;
    }

	/**
	 * {@inheritDoc}
	 * @deprecated Not implemented yet
	 */
	@Override
    public JTextArea addNamedTextArea(String name, String content, boolean isEditable)
	{
		myLogger.error("This function is not implemented yet - addNamedTextArea - DialogBuilder");
        return null;
    }

	/**
	 * {@inheritDoc}
	 * @deprecated Not implemented yet
	 */
	@Override
    public JTable addTable(String name, String[][] elements, String[] columnNames)
	{
		myLogger.error("This function is not implemented yet - addTable - DialogBuilder");
        return null;
    }

	/**
	 * {@inheritDoc}
	 * @deprecated Not implemented yet
	 */
	@Override
    public TableSelectionPanel addTableSelection(String name, String[] selectionList, String[] defaultEntries)
	{
		myLogger.error("This function is not implemented yet - addTableSelection - DialogBuilder");
        return null;
    }

	/**
	 * {@inheritDoc}
	 * If a {@link DialogBuilder#addText(String)} is called after this it will be placed next to this image.
	 */
	@Override
	public void addImage(Path imagePath, boolean isGIF)
	{
		globalRowNumber++;

		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.weightx = 0;
		layoutConstraints.insets = new Insets(5,5,5,0);

		ImageLabel myImage = new ImageLabel(imagePath,50,50, isGIF);
		myPanel.add(myImage,layoutConstraints);
		imageAdded = true;
	}

	/**
	 * {@inheritDoc}
	 * @deprecated Not implemented yet
	 */
	@Override
	public SliderPanel addNamedScrollBarPanel(String name, int initValue, int minimumValue, int maximumValue)
	{
		myLogger.error("This function is not implemented yet - addNamedScrollBarPanel - DialogBuilder");
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @deprecated Not implemented yet
	 */
	@Override
	public void addNewSection()
	{
		myLogger.error("This function is not implemented yet - addNewSection - DialogBuilder");
	}

	/**
	 * {@inheritDoc}
	 * @deprecated Not implemented yet
	 */
	@Override
	public JComboBox<String> addNamedDropdownList(String name, String[] options)
	{
		myLogger.error("This function is not implemented yet - addNamedDropdownList - DialogBuilder");
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @deprecated Not implemented yet
	 */
	@Override
	public void addPanel(JPanel newPanel)
	{
		myLogger.error("This function is not implemented yet - addPanel - DialogBuilder");
	}

	/**
	 * Adds a name tag for e.g. text fields. It is placed left to it. <br>
	 * Even this function is implemented by most classes of {@link PanelBuilder} it is not usable to put it in there
	 * because it is not constraint where the name tag has to be. In addition it is based on {@link GridBagLayout} which
	 * is not determined by the superclass.
	 * @param name Text which should be displayed next to the component
	 */
	private void addLeftNameTag(String name)
	{
		GridBagConstraints layoutConstraints = getDefaultConstraints();
		layoutConstraints.insets = new Insets(10,10,10,5);

		JLabel nameLabel = new JLabel(name);
		textStyler.styleAsTagedNameToField(nameLabel);
		myPanel.add(nameLabel,layoutConstraints);
	}

	/**
	 * Creates the most likely constraints in this builder. <br>
	 * Even this function is implemented by most classes of {@link PanelBuilder} it is not usable to put it in there
	 * because it is not constraint where the name tag has to be. In addition it is based on {@link GridBagLayout} which
	 * is not determined by the superclass.
	 * @return Most likely constraints in this builder
	 */
	private GridBagConstraints getDefaultConstraints()
	{
		GridBagConstraints layoutConstraints = new GridBagConstraints();
		layoutConstraints.gridy = globalRowNumber;
		layoutConstraints.gridx = 0;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		layoutConstraints.fill = GridBagConstraints.HORIZONTAL;
		layoutConstraints.insets = new Insets(10,10,10,10);
		return layoutConstraints;
	}

}
