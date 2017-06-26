package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ICostEstimationEditView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 * Created by phlippe on 01.05.17.
 */
public class CostEstimationEditView
	extends FormWindow
	implements ICostEstimationEditView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.EDIT_EP,
			ViewActions.RATE_WF,
			ViewActions.SAVE,
			ViewActions.CANCEL
	};

	private IModelGetData myModel;
	private JTable tableProcesses;
	private SingleColumnTableModel tableProcessesModel;


	public CostEstimationEditView(IModelGetData model)
	{
		super();
		myModel = model;
		setButtonActions(BUTTON_ACTIONS);

		init();
	}

	@Override
	protected void init()
	{
		String titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_COST_ESTIMATION);
		setTitle(titleText);
		myBuilder.addTitle(titleText);
		tableProcesses = myBuilder.addTable(
				myTextBundle.getParameterText(TextNameConstants.PAR_ELEMENTARY_PROCESSES),
				new String[0][0],
				new String[0]
		);
		tableProcessesModel = new SingleColumnTableModel(calcTableProcessEntries(), null);
		tableProcesses.setModel(tableProcessesModel);

		JButton[] buttonBar0 = myBuilder.addButtonBar(Arrays.copyOfRange(myButtonActions,0,1));
		myButtons[0] = buttonBar0[0];
		JButton[] buttonBar1 = myBuilder.addButtonBar(Arrays.copyOfRange(myButtonActions,1,2));
		myButtons[1] = buttonBar1[0];
		JButton[] buttonBar2 = myBuilder.addButtonBar(Arrays.copyOfRange(myButtonActions,2,4));
		myButtons[2] = buttonBar2[0];
		myButtons[3] = buttonBar2[1];

		setActionCommands();
		getContentPane().add(myBuilder.getResult());

		pack();
	}

	private String[] calcTableProcessEntries()
	{
		String[] allRequirementIDs = myModel.getAllReqIDs().toArray(new String[0]);
		return allRequirementIDs;
	}

	@Override
	public String getSelectedID()
	{
		int selectedRow = tableProcesses.getSelectedRow();
		String selectedID;
		if(selectedRow > 0)
		{
			selectedID = (String) tableProcesses.getValueAt(selectedRow, 0);
		}
		else
		{
			selectedID = null;
		}
		return selectedID;
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	@Override
	public void update(Observable o, Object arg)
	{
		updateTable();
	}

	private void updateTable()
	{
		tableProcessesModel.setTableEntries(calcTableProcessEntries());
	}

}
