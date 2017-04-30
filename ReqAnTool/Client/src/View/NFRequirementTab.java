package View;

/**
 * Created by phlippe on 29.04.17.
 */
public class NFRequirementTab
	extends TableTab
{

	public NFRequirementTab(){
		super("Nichtfunktionale Anforderungen");
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
		return "Nichtfunktionale Anforderungen";
	}

}