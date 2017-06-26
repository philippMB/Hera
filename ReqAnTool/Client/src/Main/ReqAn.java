package Main;

import Controller.ControllerManager;
import Controller.ProjectViewController;
import Controller_Interfaces.ViewActions;
import Exceptions.MissingReqAnException;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Logging.TraceLoggerFactory;
import Model_Interfaces.ErrorCodes;
import View.*;
import Model.Model;
import View_Interfaces.IViewFacadeFactory;

import java.util.ArrayList;

/**
 * Created by phlippe on 25.04.17.
 */
public class ReqAn
{

    public final static ViewActions[] paarActions = {ViewActions.OK, ViewActions.SAVE, ViewActions.DELETE, ViewActions.BACK, ViewActions.CANCEL};


    public static void main(String args[])
    {

        try
        {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
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
    	ILogger myLogger = ILoggerFactory.getInstance().createLogger();
    	Model newModel = new Model();
		newModel.makeNewReqAn("Anforderungsanalysentool","Ich","ll@sd.com","049");
		newModel.addFReq("/222/","Das ist ein Titel","Ich","Und das ist eine lange beschreibung",new ArrayList<String>());
		newModel.addNFReq("/223/","Das ist ein Titel","Ich","Und das ist eine lange beschreibung",new ArrayList<String>());
		newModel.addProdData("/224/","Das ist ein Titel","Ich","100",new ArrayList<String>());

		ControllerManager controllerManager = ControllerManager.getInstance(newModel);
		controllerManager.createControlledStartView();
		controllerManager.createControlledErrorDialog(null, new MissingReqAnException());
    }
}
