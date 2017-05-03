package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import View_Interfaces.IFRequirementTab;

import javax.xml.soap.Text;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 28.04.17.
 */
public class FRequirementTab
	extends TableTab
	implements IFRequirementTab
{


	public FRequirementTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_FREQ);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(myTextBundle.getTitleText(TextNameConstants.TITLE_FREQ));
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IFRequirement> allFRequirements = myModel.getAllFReq();

		tableEntries = new String[allFRequirements.size()][getColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IFRequirement fRequirementAtRow = allFRequirements.get(row);
			tableEntries[row][0] = fRequirementAtRow.getID();
			tableEntries[row][1] = fRequirementAtRow.getTitle();
			tableEntries[row][2] = fRequirementAtRow.getActor();
			tableEntries[row][3] = convertListToSingleString(fRequirementAtRow.getReferenceIDs());
		}

		return tableEntries;
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				myTextBundle.getParameterText(TextNameConstants.PAR_TITLE),
				myTextBundle.getParameterText(TextNameConstants.PAR_ACTOR),
				myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES)
		};
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}

}
