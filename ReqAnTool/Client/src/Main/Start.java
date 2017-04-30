package Main;

import Controller_Interfaces.ButtonActions;
import Model_Interfaces.IRequirementAnalysis;
import View.*;

import javax.swing.*;

/**
 * Created by phlippe on 25.04.17.
 */
public class Start {

    public final static String[] einArray = {"A","B","C","D","E"};
    public final static ButtonActions[] paarActions = {ButtonActions.CANCEL,ButtonActions.CANCEL,ButtonActions.CANCEL,ButtonActions.CANCEL,ButtonActions.CANCEL};

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
        System.out.println(einArray);
        FRequirementEditView myView = new FRequirementEditView();
        ProjectView mySecondView = new ProjectView(new IRequirementAnalysis()
        {
            @Override
            public String getTitle()
            {
                return "Hallo Welt";
            }
        });
        StartView myStartView = new StartView();
        //ErrorDialog myDialog = new ErrorDialog("Titel","Das ist eine Infromationejkhfasekjghksdjhgkjhvk<haskv");
        //WarningDialog myWarning = new WarningDialog("Titel", "Das ist eine Beschreibung der aufgetretenen Warnung",einArray,paarActions);
    }
}
