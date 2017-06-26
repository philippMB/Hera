package Controller;

import Controller_Interfaces.IViewController;
import Model_Interfaces.IModel;
import View_Interfaces.IView;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.awt.event.WindowEvent;

/**
 * Default controller class which provides a general structure for handling actions which are performed and errors
 * with creating dialogs.
 */
public abstract class BasicViewController<ViewType extends IView>
	extends BasicController
	implements IViewController
{

	protected ViewType myView;


	public BasicViewController(@NotNull IModel modelToBeControlled, @Nullable ViewType viewToBeControlled)
	{
		super(modelToBeControlled);
		setView(viewToBeControlled);
	}

	public void setView(ViewType viewToBeControlled)
	{
		setView(viewToBeControlled, true);
	}

	public void setView(ViewType viewToBeControlled, boolean showViewAfterwards)
	{
		//TODO: Controller muss sich von View abmelden
		myView = viewToBeControlled;

		if(myView != null)
		{
			myView.addController(this);
			if(showViewAfterwards)
			{
				myView.showView();
			}
		}
		else
		{
			myLogger.warning("myView is null");
		}
	}

	public ViewType getControlledView()
	{
		return myView;
	}

	@Override
	public void windowOpened(WindowEvent e)
	{

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		closeView();
		controllerManager.removeController(this);
	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		//controllerManager.removeController(this);
	}

	@Override
	public void windowIconified(WindowEvent e)
	{

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{

	}

	@Override
	public void windowActivated(WindowEvent e)
	{

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{

	}

	@Override
	protected void handleExByDialog(Exception thrownException)
	{
		controllerManager.createControlledErrorDialog(myView, thrownException);
	}

	protected void closeView()	//TODO: Rename that also controller will be destructed
	{
		if(myView != null)
		{
			myView.destruct();
		}
		else
		{
			myLogger.warning("View should be closed but it was null");
		}
		controllerManager.removeController(this);
	}

	protected boolean canViewBeClosed()
	{
		return true;
	}

}
