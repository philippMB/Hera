package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.IView;

/**
 * Created by phlippe on 17.06.17.
 */
public class DialogController<DialogType extends IView>
	extends BasicController<DialogType>
{


	public DialogController(IModel modelToBeControlled, DialogType viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
	}


	@Override
	protected void closeView()
	{
		myView.destruct();
		//controllermanager could not know about this controller due to the view is blocking the executing thread
	}
}
