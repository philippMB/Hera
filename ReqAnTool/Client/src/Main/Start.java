package Main;

import Controller.ProjectViewController;
import Controller_Interfaces.ViewActions;
import Logging.LogSystem;
import Model_Interfaces.ErrorCodes;
import View.*;
import Model.Model;
import View_Interfaces.IViewFacadeFactory;

import java.util.ArrayList;

/**
 * Created by phlippe on 25.04.17.
 */
public class Start {

    public final static ViewActions[] paarActions = {ViewActions.OK, ViewActions.SAVE, ViewActions.DELETE, ViewActions.BACK, ViewActions.CANCEL};


    public static void main(String args[])
    {

        try
        {
            //System.out.println(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //UIManager.setLookAndFeel("javax.swing.plaf.modena.ModenaLookAndFeel");
			//setUserAgentStylesheet(STYLESHEET_MODENA);
        }
        catch(Exception ex)
        {
            System.out.println("Fehler");
            ex.printStackTrace();
        }
    	/*
		JOptionPane.showMessageDialog(new JFrame(), "Message", "Dialog",
				JOptionPane.INFORMATION_MESSAGE);
		*/
    	Logging.Logger myLogger = LogSystem.getLogger();
		Model newModel = new Model();
		newModel.makeNewReqAn("Anforderungsanalysentool","Ich","ll@sd.com","049");
		ErrorCodes errorCode = newModel.addFReq("/222/","Das ist ein Titel","Ich","Und das ist eine lange beschreibung",new ArrayList<String>());
		ErrorCodes errorCode2 = newModel.addNFReq("/223/","Das ist ein Titel","Ich","Und das ist eine lange beschreibung",new ArrayList<String>());
		ErrorCodes errorCode3 = newModel.addProdData("/224/","Das ist ein Titel","Ich","100",new ArrayList<String>());
		System.out.println(errorCode);
		IViewFacadeFactory viewFacade = IViewFacadeFactory.getInstance(newModel);

		ProjectViewController projectViewController = new ProjectViewController(newModel, viewFacade.createProjectView());
        StartView myStartView = new StartView();
        //ErrorDialog myDialog = new ErrorDialog("Titel","Das ist eine Infromationejkhfasekjghksdjhgkjhvk<haskv");
        //WarningDialog myWarning = new WarningDialog("Titel", "Das ist eine Beschreibung der aufgetretenen Warnung",paarActions);
    }
}
