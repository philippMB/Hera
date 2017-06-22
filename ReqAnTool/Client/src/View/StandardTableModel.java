package View;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import javax.swing.table.AbstractTableModel;
import java.util.Objects;
import java.util.Vector;

/**
 * Created by phlippe on 18.06.17.
 */
public class StandardTableModel
		extends AbstractTableModel
{

	private Vector<Vector<String>> tableEntries;
	private Vector<String> columnNames;


	public StandardTableModel()
	{
		setTableEntries((String[][])null);
		setColumnNames((String[])null);
	}

	public StandardTableModel(@Nullable String[][] tableEntries, @Nullable String[] columnNames)
	{
		setTableEntries(tableEntries);
		setColumnNames(columnNames);
	}

	public StandardTableModel(@Nullable Vector<Vector<String>> tableEntries, @Nullable Vector<String> columnNames)
	{
		setTableEntries(tableEntries);
		setColumnNames(columnNames);
	}

	protected static Vector<Vector<String>> cast2DArrayToVector(@Nullable String[][] arrayToCast)
	{
		Vector<Vector<String>> castedArrayToVector = new Vector<>();
		if(arrayToCast != null)
		{
			for (String[] rowArray : arrayToCast)
			{
				Vector<String> rowVector = cast1DArrayToVector(rowArray);
				castedArrayToVector.add(rowVector);
			}
		}

		return castedArrayToVector;
	}

	protected static String[][] castVectorTo2DArray(@NotNull Vector<Vector<String>> vectorToCast)
	{
		Objects.requireNonNull(vectorToCast);
		int rowAmount = vectorToCast.size();
		int columnAmount;
		if(vectorToCast.size() == 0)
		{
			columnAmount = 0;
		}
		else
		{
			Objects.requireNonNull(vectorToCast.get(0));
			columnAmount = vectorToCast.get(0).size();
		}

		String[][] castedVectorToArray = new String[rowAmount][columnAmount];
		for(int rowIndex=0;rowIndex<rowAmount;rowIndex++)
		{
			castedVectorToArray[rowIndex] = castVectorTo1DArray(vectorToCast.get(rowIndex));
		}
		return castedVectorToArray;
	}

	protected static Vector<String> cast1DArrayToVector(@Nullable String[] arrayToCast)
	{
		Vector<String> castedArrayToVector = new Vector();
		if(arrayToCast != null)
		{
			for (String s: arrayToCast)
			{
				castedArrayToVector.add(s);
			}
		}

		return castedArrayToVector;
	}

	protected static String[] castVectorTo1DArray(@NotNull Vector<String> vectorToCast)
	{
		Objects.requireNonNull(vectorToCast);

		String[] castedVectorToArray = vectorToCast.toArray(new String[0]);
		return castedVectorToArray;
	}

	protected static boolean isVectorEqualsArray(Vector<String> vectorToCompare, String[] arrayToCompare)
	{
		boolean isEqual = true;
		if(vectorToCompare == null && arrayToCompare == null)
		{
			isEqual = true;
		}
		else
		{
			if(vectorToCompare == null || arrayToCompare == null)
			{
				isEqual = false;
			}
			else
			{
				if(vectorToCompare.size() != arrayToCompare.length)
				{
					isEqual = false;
				}
				else
				{
					int index = 0;
					while(index < vectorToCompare.size() && isEqual)
					{
						if(!vectorToCompare.get(index).equals(arrayToCompare[index]))
						{
							isEqual = false;
						}
						index++;
					}
				}
			}
		}
		return isEqual;
	}

	protected void createDefaultColumns()
	{
		columnNames = new Vector<>();
		columnNames.add("");
	}

	private void sortTableEntries()
	{
		if(tableEntries != null && tableEntries.size() > 0)
		{
			tableEntries.sort(
					(o1, o2) -> {
						int compareValue;
						if(o1.size() > 0 && o2.size() > 0)
						{
							compareValue = o1.get(0).compareTo(o2.get(0));
						}
						else
						{
							if(o1.size() == 0)
							{
								compareValue = -1;
							}
							else
							{
								compareValue = 1;
							}
						}
						return compareValue;
					}
			);
		}
	}

	public void addRow(@NotNull String[] rowArray)
	{
		Objects.requireNonNull(rowArray);

		Vector<String> newRow = cast1DArrayToVector(rowArray);
		tableEntries.add(newRow);
		sortTableEntries();
		fireTableRowsInserted(tableEntries.size(), tableEntries.size());
	}

	public void deleteRow(@NotNull String[] rowArray)
	{
		Objects.requireNonNull(rowArray);

		int rowIndex = 0;
		while(rowIndex < tableEntries.size())
		{
			Vector<String> rowVector = tableEntries.get(rowIndex);
			if(isVectorEqualsArray(rowVector, rowArray))
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

	public String[] getRow(int rowIndex)
	{
		String[] rowArray;
		if(rowIndex >= 0 && rowIndex < tableEntries.size())
		{
			rowArray = castVectorTo1DArray(tableEntries.get(rowIndex));
		}
		else
		{
			rowArray = null;
		}
		return rowArray;
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

	public void setTableEntries(@Nullable String[][] tableEntries)
	{
		this.tableEntries = cast2DArrayToVector(tableEntries);
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
			this.columnNames = cast1DArrayToVector(columnNames);
		}
		fireTableDataChanged();
	}

	public String[][] getTableEntries()
	{
		String[][] tableEntriesArray = castVectorTo2DArray(tableEntries);
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
		int columnCount;
		if(tableEntries.size() > 0)
		{
			columnCount = Math.min(columnNames.size(), tableEntries.get(0).size());
		}
		else
		{
			columnCount = columnNames.size();
		}
		return columnCount;
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex)
	{
		String value;
		if(tableEntries != null &&
				rowIndex >= 0 && rowIndex < tableEntries.size() &&
				columnIndex >= 0 && columnIndex < tableEntries.get(rowIndex).size())
		{
			value = tableEntries.get(rowIndex).get(columnIndex);
		}
		else
		{
			value = "";
		}
		return value;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}

	/**
	 * Returns the saved column name of <code>columnNames</code>. If column is out of bounds the default
	 * column name from {@link AbstractTableModel#getColumnName(int)} is returned.
	 *
	 * @param column the column being queried
	 *
	 * @return a string containing the name of <code>columnNames</code>. If index is out of bounds the default name
	 * will be returned
	 */
	@Override
	public String getColumnName(int column)
	{
		String columnName;
		if(column >= 0 && column < columnNames.size())
		{
			columnName = columnNames.get(column);
		}
		else
		{
			columnName = super.getColumnName(column);
		}
		return columnName;
	}
}
