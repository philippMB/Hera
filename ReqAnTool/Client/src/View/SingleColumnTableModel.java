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
	extends StandardTableModel
{


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

	private static String[] castStringToArray(String stringToCast)
	{
		String[] castedStringToArray = new String[1];
		castedStringToArray[0] = stringToCast;
		return castedStringToArray;
	}

	public void addRow(@NotNull String entry)
	{
		Objects.requireNonNull(entry);

		super.addRow(castStringToArray(entry));
	}

	public void deleteRow(String entry)
	{
		super.deleteRow(castStringToArray(entry));
	}

	public void setTableEntries(@Nullable String[] tableEntries)
	{
		String[][] twoDimTableEntries;
		if(tableEntries == null)
		{
			twoDimTableEntries = null;
		}
		else
		{
			int rowCount = tableEntries.length;
			twoDimTableEntries = new String[rowCount][1];
			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++)
			{
				twoDimTableEntries[rowIndex][0] = tableEntries[rowIndex];
			}
		}
		super.setTableEntries(twoDimTableEntries);
	}

	public String[] getOneColumnTableEntries()
	{
		String[][] tableEntriesArray = super.getTableEntries();
		int rowCount = tableEntriesArray.length;
		String[] oneColumnTableEntries = new String[rowCount];
		for(int rowIndex=0;rowIndex<rowCount;rowIndex++)
		{
			oneColumnTableEntries[rowIndex] = tableEntriesArray[rowIndex][0];
		}
		return oneColumnTableEntries;
	}

	public String getValueAt(int rowIndex)
	{
		return getValueAt(rowIndex, 0);
	}

}
