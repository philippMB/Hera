package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 28.04.17.
 */
public class ProductEnvironmentTab
		extends TabPanel
{

	private JTextArea textAreaDescription;
	private JButton buttonSave;
	private JButton buttonDelete;


	public ProductEnvironmentTab()
	{
		super("Produktumgebung");
	}

	@Override
	protected void init()
	{
		String[] buttonNames = {"Speichern","Löschen"};

		myBuilder.addTitle("Produktumgebung");
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

