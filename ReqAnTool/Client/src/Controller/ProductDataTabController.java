package Controller;

import LanguageAndText.DialogConstants;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IProductDataTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 18.06.17.
 */
public class ProductDataTabController
		extends TableTabController<IProductDataTab>
{


	public ProductDataTabController(IModel model, IView parentView, IProductDataTab productDataTab)
	{
		super(model, parentView, productDataTab);
	}

	@Override
	protected void executeAddAction()
	{
		controllerManager.createControlledProductDataEditView(null);
	}

	@Override
	protected void executeEditAction()
	{
		String ID = getSelectedIdentifier();

		if(ID != null)
		{
			controllerManager.createControlledProductDataEditView(ID);
		}
		else
		{
			//TODO: ERROR-DIALOG - Nothing selected
		}
	}

	@Override
	protected void executeShowAction()
	{
		String ID = getSelectedIdentifier();
		if(ID != null)
		{
			controllerManager.createControlledProductDataShowView(ID);
		}
		else
		{
			//TODO: ERROR-DIALOG - Nothing selected
		}
	}

	@Override
	protected void executeDeleteAction()
	{
		controllerManager.createControlledWarningDialog(
				parentView,
				DialogConstants.DIALOG_DELETE_WARNING,
				new String[]{
						myTextBundle.getParameterText(TextNameConstants.PAR_PRODUCTDATA) + " " + getSelectedIdentifier()
				},
				new DeleteWarningController(myModel, null)
				{
					@Override
					protected void deleteObject()
					{
						closeView();
						myModel.remProdDataByID(getSelectedIdentifier());
					}

					@Override
					protected void cancelDeletion()
					{
						closeView();
					}
				}
		);
	}
}
