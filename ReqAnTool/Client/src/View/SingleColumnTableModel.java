package View;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.table.AbstractTableModel;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by phlippe on 15.06.17.
 */
public class SingleColumnTableModel
	extends AbstractTableModel
{

	private Vector<Vector<String>> tableEntries;
	private Vector<String> columnNames;


	public SingleColumnTableModel()
	{
		setTableEntries((String[])null);
		setColumnNames((String[])null);
	}

	public SingleColumnTableModel(@Nullable String[] tableEntries, @Nullable String[] columnNames)
	{
		setTableEntries(tableEntries);
		setColumnNames(columnNames);
	}

	public SingleColumnTableModel(@Nullable Vector<Vector<String>> tableEntries, @Nullable Vector<String> columnNames)
	{
		setTableEntries(tableEntries);
		setColumnNames(columnNames);
	}

	private Vector<Vector<String>> castArrayToEntriesVector(@Nullable String[] arrayToCast)
	{
		Vector<Vector<String>> castedArrayToEntriesVector = new Vector<>();
		if(arrayToCast != null)
		{
			for (String s : arrayToCast)
			{
				Vector<String> rowVector = new Vector<>();
				rowVector.add(s);
				castedArrayToEntriesVector.add(rowVector);
			}
		}

		return castedArrayToEntriesVector;
	}

	private Vector<String> castArrayToColumnVector(@Nullable String[] arrayToCast)
	{
		Vector<String> castedArrayToColumnVector = new Vector();
		if(arrayToCast != null)
		{
			for (String s : arrayToCast)
			{
				castedArrayToColumnVector.add(s);
			}
		}

		return castedArrayToColumnVector;
	}

	private void createDefaultColumns()
	{
		columnNames = new Vector<>();
		columnNames.add("");
	}

	private void sortTableEntries()
	{
		tableEntries.sort((o1,o2) -> o1.get(0).compareTo(o2.get(0)));
	}

	public void addRow(@NotNull String entry)
	{
		Objects.requireNonNull(entry);

		Vector<String> newRow = new Vector<>();
		newRow.add(entry);
		tableEntries.add(newRow);
		sortTableEntries();
		fireTableRowsInserted(tableEntries.size(), tableEntries.size());
	}

	public void deleteRow(String entry)
	{
		int rowIndex = 0;
		while(rowIndex < tableEntries.size())
		{
			Vector<String> rowVector = tableEntries.get(rowIndex);
			if(rowVector.get(0).equals(entry))
			{
				deleteRow(rowIndex);
			}
			else
			{
				rowIndex++;
			}
		}
	}

	public void deleteRow(int rowIndex)
	{
		if(rowIndex >= 0 && rowIndex < tableEntries.size())
		{
			tableEntries.remove(rowIndex);
			fireTableRowsDeleted(rowIndex, rowIndex);
		}
	}

	public void setTableEntries(@Nullable Vector<Vector<String>> tableEntries)
	{
		if(tableEntries != null)
		{
			this.tableEntries = tableEntries;
		}
		else
		{
			this.tableEntries = new Vector<>();
		}
		sortTableEntries();
		fireTableDataChanged();
	}

	public void setTableEntries(@Nullable String[] tableEntries)
	{
		this.tableEntries = castArrayToEntriesVector(tableEntries);
		sortTableEntries();
		fireTableDataChanged();
	}

	public void setColumnNames(@Nullable Vector<String> columnNames)
	{
		if(columnNames == null)
		{
			createDefaultColumns();
		}
		else
		{
			this.columnNames = columnNames;
		}
		fireTableDataChanged();
	}

	public void setColumnNames(@Nullable String[] columnNames)
	{
		if(columnNames == null)
		{
			createDefaultColumns();
		}
		else
		{
			this.columnNames = castArrayToColumnVector(columnNames);
		}
		fireTableDataChanged();
	}

	public String[] getTableEntries()
	{
		String[] tableEntriesArray = new String[tableEntries.size()];
		for(int rowIndex = 0; rowIndex < tableEntries.size(); rowIndex++)
		{
			tableEntriesArray[rowIndex] = tableEntries.get(rowIndex).get(0);
		}
		return tableEntriesArray;
	}

	@Override
	public int getRowCount()
	{
		return tableEntries.size();
	}

	@Override
	public int getColumnCount()
	{
		return columnNames.size();
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex)
	{
		return tableEntries.get(rowIndex).get(columnIndex);
	}

	public String getValueAt(int rowIndex)
	{
		return getValueAt(rowIndex, 0);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}
}
