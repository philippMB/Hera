package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IProductDataEditView;

import java.util.ArrayList;

/**
 * Created by phlippe on 18.06.17.
 */
public class ProductDataEditController
		extends RequirementEditController<IProductDataEditView>
{

	private String myReqID;


	public ProductDataEditController(IModel model, IProductDataEditView viewToBeControlled)
	{
		super(model, viewToBeControlled);
		myReqID = myView.getIDEntry();
	}

	@Override
	protected void addRequirementToModel(ArrayList<String> referenceList) throws Exception
	{
		myModel.addProdData(
				myView.getIDEntry(),
				myView.getContentEntry(),
				myView.getAttributeEntry(),
				myView.getMaxCountEntry(),
				referenceList
		);
	}

	@Override
	protected void editRequirementFromModel(ArrayList<String> referenceList) throws Exception
	{
		myModel.editProdData(
				myReqID,
				myView.getIDEntry(),
				myView.getContentEntry(),
				myView.getAttributeEntry(),
				myView.getMaxCountEntry(),
				referenceList
		);
	}

	@Override
	protected String[] createSaveDataWarningPlaceholder()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_PRODUCTDATA) + " " + myReqID
		};
	}

}


