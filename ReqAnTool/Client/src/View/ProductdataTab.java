package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.INFRequirement;
import Model_Interfaces.IProductData;
import View_Interfaces.IProductDataTab;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by phlippe on 29.04.17.
 */
public class ProductDataTab
	extends TableTab
	implements IProductDataTab
{

	public ProductDataTab(IModelGetData model)
	{
		super(model, TextNameConstants.TITLE_PRODUCTDATA);
	}

	@Override
	protected void init()
	{
		myBuilder.addTitle(
				myTextBundle.getTitleText(TextNameConstants.TITLE_PRODUCTDATA)
		);
		buildTablePanel();

		add(myBuilder.getResult(), BorderLayout.CENTER);
	}

	@Override
	protected String[][] getTableEntries()
	{
		String[][] tableEntries;
		ArrayList<IProductData> allProductData = myModel.getAllProdData();

		tableEntries = new String[allProductData.size()][getColumnNames().length];

		for(int row = 0; row < tableEntries.length; row++)
		{
			IProductData productDataAtRow = allProductData.get(row);
			tableEntries[row][0] = productDataAtRow.getID();
			tableEntries[row][1] = productDataAtRow.getContent();
			tableEntries[row][2] = productDataAtRow.getMaxCount();
			tableEntries[row][3] = convertListToSingleString(productDataAtRow.getReferenceIDs());
		}

		return tableEntries;
	}

	@Override
	protected String[] getColumnNames()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				myTextBundle.getParameterText(TextNameConstants.PAR_CONTENT),
				myTextBundle.getParameterText(TextNameConstants.PAR_MAX_COUNT),
				myTextBundle.getParameterText(TextNameConstants.PAR_REFERENCES)
		};
	}


	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}
}
