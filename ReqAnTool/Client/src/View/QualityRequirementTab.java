package View;

/**
 * Created by phlippe on 29.04.17.
 */
public class QualityRequirementTab
	extends TableTab
{

	public QualityRequirementTab()
	{
		super("Qualitätsanforderungen");
	}

	@Override
	protected String[][] getTableEntries()
	{
		return new String[0][];
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{"Name","Bewertung"};
	}

	@Override
	protected String getTitle()
	{
		return "Qualitätsanforderungen";
	}
}
