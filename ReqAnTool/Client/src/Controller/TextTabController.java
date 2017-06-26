package Controller;

import LanguageAndText.DialogConstants;
import Model_Interfaces.IModel;
import View_Interfaces.ITextTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 25.06.17.
 */
public abstract class TextTabController<TextTabType extends ITextTab>
	extends TabController<TextTabType>
{

	private TextFieldController textFieldController;
	private boolean canBeClosed;


	public TextTabController(IModel model, IView parentView, TextTabType viewToBeControlled)
	{
		super(model, parentView, viewToBeControlled);
		textFieldController = new TextFieldController(viewToBeControlled);
		canBeClosed = true;
	}

	@Override
	public void setView(TextTabType viewToBeControlled, boolean showViewAfterwards)
	{
		super.setView(viewToBeControlled, showViewAfterwards);
		if(textFieldController != null)
		{
			textFieldController.setView(viewToBeControlled);
		}
	}

	@Override
	protected boolean canViewBeClosed()
	{
		if(textFieldController.hasTextChangedSinceSaving())
		{
			myView.bringToFront();
			controllerManager.createControlledWarningDialog(
					parentView,
					DialogConstants.DIALOG_SAVE_DATA_WARNING,
					new String[]{
							myTextBundle.getParameterText(getParameterPropertyName())
					},
					new WarningController(myModel, null)
					{
						@Override
						protected void executeCancelAction()
						{
							canBeClosed = false;
							closeView();
						}

						@Override
						protected void executeSaveAction()
						{
							closeView();
							canBeClosed = tryToSaveDescription();
						}

						@Override
						protected void executeDontSaveAction()
						{
							canBeClosed = true;
							closeView();
						}
					}
			);
		}
		else
		{
			canBeClosed = true;
		}
		return canBeClosed;
	}

	@Override
	protected void executeSaveAction()
	{
		if(tryToSaveDescription())
		{
			controllerManager.createControlledInfoDialog(
					parentView,
					DialogConstants.DIALOG_INFO_SAVING_DATA,
					new String[]{
							myTextBundle.getParameterText(getParameterPropertyName())
					}
			);
		}
	}

	private boolean tryToSaveDescription()
	{
		boolean exceptionThrown = false;
		String newDescription = myView.getDescription();
		try
		{
			editDescriptionInModel(newDescription);
			textFieldController.setSaved();
		}
		catch(Exception ex)
		{
			exceptionThrown = true;
			handleException(ex);
		}
		return !exceptionThrown;
	}

	@Override
	protected void executeResetAction()
	{
		controllerManager.createControlledWarningDialog(
				parentView,
				DialogConstants.DIALOG_RESET_WARNING,
				new String[]{
						myTextBundle.getParameterText(getParameterPropertyName())
				},
				new WarningController(myModel, null)
				{
					@Override
					protected void executeResetAction()
					{
						resetProdApp();
						closeView();
					}

					@Override
					protected void executeCancelAction()
					{
						closeView();
					}
				}
		);
	}

	private void resetProdApp()
	{
		myView.resetDescription();
		textFieldController.setSaved();
	}

	protected abstract void editDescriptionInModel(String newDescription);

	protected abstract String getParameterPropertyName();
}
