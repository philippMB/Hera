package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.ErrorCodes;
import Model_Interfaces.IModel;
import View_Interfaces.INFRequirementEditView;
import View_Interfaces.IProductDataEditView;

import java.util.ArrayList;
import java.util.Arrays;

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
	protected boolean tryToSaveReq()
	{
		boolean reqIsSaved;
		ErrorCodes saveError;
		ArrayList<String> referenceList = new ArrayList<>( Arrays.asList(myView.getRefEntry()) );

		if(myReqID == null || myReqID.equals(""))
		{
			saveError = myModel.addProdData(
					myView.getIDEntry(),
					myView.getContentEntry(),
					myView.getAttributeEntry(),
					myView.getMaxCountEntry(),
					referenceList
			);
		}
		else
		{
			saveError = myModel.editNFReq(
					myReqID,
					myView.getIDEntry(),
					myView.getContentEntry(),
					myView.getAttributeEntry(),
					myView.getMaxCountEntry(),
					referenceList
			);
		}

		if(saveError == ErrorCodes.NO_ERROR)
		{
			reqIsSaved = true;
		}
		else
		{
			reqIsSaved = false;
			handleErrorCode(saveError);
		}
		return reqIsSaved;
	}

	@Override
	protected String[] createSaveDataWarningPlaceholder()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_PRODUCTDATA) + " " + myReqID
		};
	}

}


