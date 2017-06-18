package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.ILoadingDialog;

import java.awt.event.WindowEvent;

/**
 * Created by phlippe on 17.06.17.
 */
public class LoadingController
	extends BasicController<ILoadingDialog>
{


	public LoadingController(IModel model, ILoadingDialog viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	public void setView(ILoadingDialog viewToBeControlled)
	{
		setView(viewToBeControlled, false);
	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		//Do nothing
	}

	public void startLoadingDialog()
	{
		if(myView != null)
		{
			myView.showView();
		}
		else
		{
			myLogger.warning("Should start loading dialog, but no View was set");
		}
	}

	public void stopLoadingDialog()
	{
		closeView();
	}
}
