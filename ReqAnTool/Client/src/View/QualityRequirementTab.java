package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IQualityRequirement;
import View_Interfaces.IQualityRequirementTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class QualityRequirementTab
	extends TableTab
	implements IQualityRequirementTab
{

	public QualityRequirementTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_QUALIRY_REQ);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_QUALIRY_REQ));
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] createTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IQualityRequirement> allQualityRequirements = myModel.getAllQualReq();

		tableEntries = new String[allQualityRequirements.size()][createColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IQualityRequirement qualityReqAtRow = allQualityRequirements.get(row);
			String valuation;
			switch(qualityReqAtRow.getValue())
			{
				case NORMAL:
					valuation = myTextBundle.getParameterText(TextNameConstants.PAR_NORMAL);
					break;
				case IMPORTANT:
					valuation = myTextBundle.getParameterText(TextNameConstants.PAR_IMPORTANT);
					break;
				case VERYIMPORTANT:
					valuation = myTextBundle.getParameterText(TextNameConstants.PAR_VERY_IMPORTANT);
					break;
				case NOTRELEVANT:
					valuation = myTextBundle.getParameterText(TextNameConstants.PAR_NOT_RELEVANT);
					break;
				default:
					valuation = "---";
					break;
			}

			tableEntries[row][0] = qualityReqAtRow.getCriteria();
			tableEntries[row][1] = valuation;
		}

		return tableEntries;
	}

	@Override
	protected String[] createColumnNames()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_NAME),
				myTextBundle.getParameterText(TextNameConstants.PAR_VALUATION)
		};
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}
}
