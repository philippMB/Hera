package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.FileAccess;
import View_Interfaces.IFileChooser;
import View_Interfaces.IViewFacadeFactory;
import View_Interfaces.IWarningDialog;

/**
 * Created by phlippe on 24.05.17.
 */
public class SaveWarningController
	extends WarningController
{

	public SaveWarningController(IModel model, IWarningDialog saveWarning)
	{
		super(model, saveWarning);
	}

	@Override
	protected void executeSaveAction()
	{
		System.out.println("Save-Action");
		myModel.saveReqAn("Test.reqan");
	}

	@Override
	protected void executeSaveAsAction()
	{
		System.out.println("SaveAs-Action");
		String filePath = getChosenFile();
		if(filePath != null)
		{
			myModel.saveReqAn(filePath);
		}
		else
		{
			//TODO: What if no file to save is chosen?
		}
	}

	private String getChosenFile()
	{
		IViewFacadeFactory viewFacadeFactory = IViewFacadeFactory.getInstance(myModel);
		IFileChooser myFileChooser = viewFacadeFactory.createFileChooser(null, FileAccess.SAVE);
		myFileChooser.showFileChooser();
		return myFileChooser.getChosenFile();
	}

	@Override
	protected void executeDontSaveAction()
	{

	}

	@Override
	protected void executeCancelAction()
	{

	}

}
