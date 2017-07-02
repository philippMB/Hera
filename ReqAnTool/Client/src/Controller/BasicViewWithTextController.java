package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.ITextView;
import View_Interfaces.IView;

/**
 * Created by phlippe on 26.06.17.
 */
public class BasicViewWithTextController<ViewType extends IView & ITextView>
	extends BasicViewController<ViewType>
{

	protected TextFieldController textController;


	public BasicViewWithTextController(IModel modelToBeControlled, ViewType viewToBeControlled)
	{
		super(modelToBeControlled, viewToBeControlled);
		textController = new TextFieldController(viewToBeControlled);
	}

	@Override
	public void setView(ViewType viewToBeControlled, boolean showViewAfterwards)
	{
		super.setView(viewToBeControlled, showViewAfterwards);
		if(textController != null)
		{
			textController.setView(viewToBeControlled);
		}
	}

}
