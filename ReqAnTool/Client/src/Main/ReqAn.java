package Main;

import Controller.ControllerManager;
import Logging.ILogger;
import Logging.ILoggerFactory;
import Model.Model;

/**
 * Created by phlippe on 25.04.17.
 */
public class ReqAn
{

    public static void main(String args[])
    {

		ILogger myLogger = ILoggerFactory.getInstance().createLogger();
        try
        {
			System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            myLogger.error("Error by setting apple.laf.useScreenMenuBar to true");
        }
    	Model newModel = new Model();
		ControllerManager controllerManager = ControllerManager.getInstance(newModel);
		controllerManager.createControlledStartView();
    }
}
