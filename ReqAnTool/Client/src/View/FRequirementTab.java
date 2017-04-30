package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 28.04.17.
 */
public class FRequirementTab
	extends TableTab
{


	public FRequirementTab(){
		super("Funktionale Anforderungen");
	}

	@Override
	protected String[][] getTableEntries()
	{
		return new String[0][];
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{"ID","Titel","Akteur","Verweise"};
	}

	@Override
	protected String getTitle()
	{
		return "Funktionale Anforderungen";
	}

}
