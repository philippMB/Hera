package View;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IFRequirement;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IProductData;
import Model_Interfaces.IRequirement;

import javax.swing.*;

/**
 * Created by phlippe on 03.05.17.
 */
public class ProcessClassificationProdDataView
	extends ProcessClassificationView
{

	private IProductData myReq;
	private JTextField fieldContent;
	private JTextField fieldMaxCount;
	private JTextArea fieldAttributes;

	public ProcessClassificationProdDataView(IModelGetData model, String ID)
	{
		super(model, ID);
	}

	@Override
	protected void loadInternRequirement(String ID)
	{
		myReq = myModel.getProductDataByID(ID);
	}

	@Override
	protected void buildReqSpecificDescription()
	{
		fieldContent = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_CONTENT),
				"",
				false
		);
		fieldMaxCount = myBuilder.addNamedTextField(
				myTextBundle.getParameterText(TextNameConstants.PAR_MAX_COUNT),
				"",
				false
		);
		fieldAttributes = myBuilder.addNamedTextArea(
				myTextBundle.getParameterText(TextNameConstants.PAR_ATTRIBUTES),
				"",
				false
		);

		updateReqSpecificDescription();
	}

	@Override
	protected void updateReqSpecificDescription()
	{
		fieldContent.setText(myReq.getContent());
		fieldMaxCount.setText(myReq.getMaxCount());
		fieldAttributes.setText(myReq.getAttribute());
	}

	@Override
	public IRequirement getMyRequirement()
	{
		return myReq;
	}

}
