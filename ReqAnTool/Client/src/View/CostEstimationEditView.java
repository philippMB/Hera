package View;

import Controller_Interfaces.ViewActions;
import LanguageAndText.TextNameConstants;
import Model_Interfaces.ICostEstimation;
import Model_Interfaces.IModelGetData;
import View_Interfaces.ICostEstimationEditView;
import View_Interfaces.IProcessClassificationView;
import View_Interfaces.IWeightFactorEditView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

/**
 * This view provides basic functionality for editing a cost estimation in a view.
 * <p>
 *     <b>View actions for controller</b>
 *     A cost estimation contains multiple data and transaction function points which has to be set and edited. This
 *     view sets a basic structure for his. The provided view actions are following:
 *     <ul>
 *         <li>{@link Controller_Interfaces.ViewActions#EDIT_EP} - edit a elementary process to create and edit data
 *         and transaction function points in a {@link IProcessClassificationView}</li>
 *         <li>{@link Controller_Interfaces.ViewActions#RATE_WF} - edit/rate weight factors in a
 *         {@link IWeightFactorEditView}</li>
 *         <li>{@link Controller_Interfaces.ViewActions#SAVE} - saves the changes in requirement analysis</li>
 *         <li>{@link Controller_Interfaces.ViewActions#CANCEL} - cancel the changes</li>
 *     </ul>
 *	   For editing or creating a elementary process all requirements are shown in a table. To get the selected element
 *	   the function {@link ICostEstimationEditView#getSelectedID()} returns the id of this requirement.
 * <p>
 *     <b>Inner structure</b><br>
 *         The view contains a table in which all elementary processes of the current system are listed. The user can
 *         choose a entry and edit it with {@link Controller_Interfaces.ViewActions#EDIT_EP}.
 *
 * @author 9045534
 * @version 1.0
 * @see IProcessClassificationView
 */
public class CostEstimationEditView
	extends FormWindow
	implements ICostEstimationEditView
{

	private final ViewActions[] BUTTON_ACTIONS = {
			ViewActions.EDIT_EP,
			ViewActions.RATE_WF,
			ViewActions.SHOW,
			ViewActions.CLOSE
	};

	private IModelGetData myModel;
	private JTable tableProcesses;
	private StandardTableModel tableProcessesModel;


	public CostEstimationEditView(IModelGetData model)
	{
		super();
		myModel = model;
		myModel.addObserver(this);
		setButtonActions(BUTTON_ACTIONS);

		init();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void init()
	{
		String titleText = myTextBundle.getTitleText(TextNameConstants.TITLE_COST_ESTIMATION);
		setTitle(titleText);
		myBuilder.addTitle(titleText);
		myBuilder.addTitle(myTextBundle.getParameterText(TextNameConstants.PAR_ELEMENTARY_PROCESSES));
		tableProcesses = myBuilder.addTable(
				null,
				new String[0][0],
				new String[0]
		);
		tableProcessesModel = new StandardTableModel(calcTableProcessEntries(), getColumnNamesOfEPTable());
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

	private String[][] calcTableProcessEntries()
	{
		String[][] tableEntries;
		String[] allRequirementIDs = myModel.getAllReqIDs().toArray(new String[0]);
		tableEntries = new String[allRequirementIDs.length][2];
		ICostEstimation myCostEstimation = myModel.getCostEstimation();
		for(int index=0;index < allRequirementIDs.length;index++)
		{
			String reqID = allRequirementIDs[index];
			tableEntries[index][0] = reqID;
			tableEntries[index][1] = "---";
			if(myCostEstimation.hasIDDataFP(reqID))
			{
				tableEntries[index][1] = myTextBundle.getParameterText(TextNameConstants.PAR_DFP);
			}
			if(myCostEstimation.hasIDTransactionFP(reqID))
			{
				tableEntries[index][1] = myTextBundle.getParameterText(TextNameConstants.PAR_TFP);
			}
		}
		return tableEntries;
	}

	private String[] getColumnNamesOfEPTable()
	{
		return new String[]{
				myTextBundle.getParameterText(TextNameConstants.PAR_ID),
				myTextBundle.getParameterText(TextNameConstants.PAR_TYP)
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSelectedID()
	{
		int selectedRow = tableProcesses.getSelectedRow();
		String selectedID;
		if(selectedRow >= 0)
		{
			selectedID = (String)tableProcesses.getValueAt(selectedRow, 0);
		}
		else
		{
			selectedID = null;
		}
		return selectedID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destruct()
	{
		super.destruct();
		myModel.deleteObserver(this);
	}

	/**
	 * {@inheritDoc}
	 * For this the table of elementary processes is updated.
	 */
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
