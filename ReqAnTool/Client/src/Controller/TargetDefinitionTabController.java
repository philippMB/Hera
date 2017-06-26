package Controller;

import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModel;
import View_Interfaces.IProductApplicationTab;
import View_Interfaces.ITargetDefinitionTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 25.06.17.
 */
public class TargetDefinitionTabController
		extends TextTabController<ITargetDefinitionTab>
{


	public TargetDefinitionTabController(IModel model, IView parentView, ITargetDefinitionTab viewToBeControlled)
	{
		super(model, parentView, viewToBeControlled);
	}

	@Override
	protected void editDescriptionInModel(String newDescription)
	{
		myModel.editTargetDef(newDescription);
	}

	@Override
	protected String getParameterPropertyName()
	{
		return TextNameConstants.PAR_TARGET_DEFINITION;
	}

}
