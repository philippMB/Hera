package Controller;

import Model_Interfaces.IModel;
import Model_Interfaces.XMLFormatType;
import View_Interfaces.FileAccessType;
import View_Interfaces.IFileChooser;
import View_Interfaces.IStartView;

/**
 * Created by phlippe on 11.06.17.
 */
public class StartViewController
	extends BasicViewController<IStartView>
{

	public StartViewController(IModel model, IStartView viewToBeControlled)
	{
		super(model, viewToBeControlled);
	}

	@Override
	protected void executeNewProjectAction()
	{
		controllerManager.createControlledProjectCreateView();
		closeView();
	}

	@Override
	protected void executeOpenProjectAction()
	{
		accessFile(
				(absolutePath) ->
				{
					//TODO: Open ReqAn
					//myModel.openReqAn(absolutePath);
					controllerManager.createControlledProjectView();
					closeView();
				},
				FileAccessType.OPEN,
				null
		);
	}

	@Override
	protected void executeFromXMLAction()
	{
		accessFile(
				(absolutePath) ->
				{
					//TODO: Import with XMLFormatType
					boolean isImported = tryToImportXMLFromAddress(absolutePath);
					if(isImported)
					{
						controllerManager.forceQuitAllViews();
						controllerManager.createControlledProjectView();
						closeView();
					}
				},
				FileAccessType.IMPORT,
				null
		);
	}

	private boolean tryToImportXMLFromAddress(String address)
	{
		boolean isExported;
		try
		{
			myModel.importFromXML(address, XMLFormatType.CUSTOM_XML_FORMAT);	//TODO: Nach Format fragen
			isExported = true;
		}
		catch(Exception ex)
		{
			isExported = false;
			handleException(ex);
		}
		return isExported;
	}

	@Override
	protected void executeCloseAction()
	{
		controllerManager.closeProgram();
	}
}
