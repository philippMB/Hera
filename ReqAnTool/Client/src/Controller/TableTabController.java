package Controller;

import Model_Interfaces.IModel;
import View_Interfaces.ITableTab;
import View_Interfaces.IView;

/**
 * Created by phlippe on 11.05.17.
 */
public abstract class TableTabController <TableTabType extends ITableTab>
	extends TabController<TableTabType>
{

	public TableTabController(IModel model, IView parentView, TableTabType tableTab)
	{
		super(model, parentView, tableTab);
	}

	protected String getSelectedIdentifier()
	{
		return getSelectedIdentifier(0);
	}

	protected String getSelectedIdentifier(int columnIndex)
	{
		String identifier;
		String[] selectedRow = ((ITableTab)getControlledView()).getSelectedRow();

		if(selectedRow != null && columnIndex >= 0 && columnIndex < selectedRow.length)
		{
			identifier = selectedRow[columnIndex];
		}
		else
		{
			identifier = null;
		}

		return identifier;
	}

}
