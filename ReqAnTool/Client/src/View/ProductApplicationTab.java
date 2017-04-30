package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 28.04.17.
 */
public class ProductApplicationTab
	extends TabPanel
{

	private JTextArea textAreaDescription;
	private JButton buttonSave;
	private JButton buttonDelete;


	public ProductApplicationTab()
	{
		super("Produkteinsatz");
	}

	@Override
	protected void init()
	{
		String[] buttonNames = {"Speichern","Löschen"};

		myBuilder.addTitle("Produkteinsatz");
		textAreaDescription = myBuilder.addNamedTextArea(null,"");
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonSave = myButtons[0];
		buttonDelete = myButtons[1];

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	public String getDescriptionText()
	{
		return textAreaDescription.getText();
	}

}
