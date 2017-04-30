package View;

import javax.swing.*;

/**
 * Created by phlippe on 29.04.17.
 */
public class CostEstimationTab
	extends TabPanel
{

	JButton buttonShowCE;
	JButton buttonEditCE;
	JButton buttonDeleteCE;
	JButton buttonFPCalc;
	JButton buttonOptimize;
	JButton buttonEnterAS;


	public CostEstimationTab()
	{
		super("Aufwandsschätzung");
	}

	@Override
	protected void init()
	{
		String[] buttonNames = {"Aufwandsschätzung anzeigen",
								"Function-Points berechnen",
								"Aufwandsschätzung bearbeiten",
								"Gewichtsfaktoren optimieren",
								"Aufwandsschätzung löschen",
								"Ist-Zustand eintragen"
						       };

		myBuilder.addTitle("Aufwandsschätzung");
		JButton[] myButtons = myBuilder.addButtonBar(buttonNames);
		buttonShowCE = myButtons[0];
		buttonFPCalc = myButtons[1];
		buttonEditCE = myButtons[2];
		buttonOptimize = myButtons[3];
		buttonDeleteCE = myButtons[4];
		buttonEnterAS = myButtons[5];

		add(myBuilder.getResult());
	}
}
