package View;

/**
 * Created by phlippe on 29.04.17.
 */
public class ProductdataTab
	extends TableTab
{

	public ProductdataTab(){
		super("Produktdaten");
	}

	@Override
	protected String[][] getTableEntries()
	{
		return new String[0][];
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{"ID","Speicherinhalt","Verweise","Max. Anzahl"};
	}

	@Override
	protected String getTitle()
	{
		return "Produktdaten";
	}
}
