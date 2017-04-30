package View;

/**
 * Created by phlippe on 29.04.17.
 */
public class AdditionTab
	extends TableTab
{

	public AdditionTab()
	{
		super("Ergänzungen");
	}

	@Override
	protected String[][] getTableEntries()
	{
		return new String[0][];
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{"Titel","Beschreibung"};
	}

	@Override
	protected String getTitle()
	{
		return "Ergänzungen";
	}

}
