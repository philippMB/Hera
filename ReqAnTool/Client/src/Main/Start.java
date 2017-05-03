package Main;

import Controller_Interfaces.ViewActions;
import Logging.LogSystem;
import Model_Interfaces.IRequirementAnalysis;
import View.*;

import javax.swing.*;

import static java.lang.Thread.sleep;

/**
 * Created by phlippe on 25.04.17.
 */
public class Start {

    public final static String[] einArray = {"A","B","C","D","E"};
    public final static ViewActions[] paarActions = {ViewActions.CANCEL, ViewActions.CANCEL, ViewActions.CANCEL, ViewActions.CANCEL, ViewActions.CANCEL};

    public static void main(String args[])
    {
        try
        {
            System.out.println(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            //"com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
        }
        catch(Exception ex)
        {
            System.out.println("Fehler");
        }

		LogSystem.getLogger().info("This is another log");
        try
		{
			sleep(10000);
		}
		catch(Exception ex)
		{

		}
        /*
        System.out.println(einArray);
        FRequirementEditView myView = new FRequirementEditView();
        ProjectView mySecondView = new ProjectView(new IRequirementAnalysis()
        {
            @Override
            public String getTitle()
            {
                return "Hallo Welt";
            }
        });*/
        //StartView myStartView = new StartView();
        //ErrorDialog myDialog = new ErrorDialog("Titel","Das ist eine Infromationejkhfasekjghksdjhgkjhvk<haskv");
        //WarningDialog myWarning = new WarningDialog("Titel", "Das ist eine Beschreibung der aufgetretenen Warnung",einArray,paarActions);
    }
}
