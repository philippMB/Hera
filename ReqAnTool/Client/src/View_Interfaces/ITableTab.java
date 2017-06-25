package View_Interfaces;

/**
 * This interface is a specialisation of {@link ITab} defining a standard structure of editing, creating, showing and
 * deleting multiple entries displayed in a table.
 * <p>
 * A requirement analysis contains many variable lists of objects which has to be created, edited, shown and deleted. To
 * give such tasks a standard structure all subclasses of this interface are unified on the following points.
 * </p>
 * <p>
 *     <b>View actions in view</b><br>
 *         A table tab provides four different view actions:
 *         <ul>
 *             <li>{@link Controller_Interfaces.ViewActions#ADD} - creates a new entry</li>
 *             <li>{@link Controller_Interfaces.ViewActions#EDIT} - edits selected element</li>
 *             <li>{@link Controller_Interfaces.ViewActions#SHOW} - shows details of selected element</li>
 *             <li>{@link Controller_Interfaces.ViewActions#DELETE} - deletes selected element</li>
 *         </ul>
 *         Controller of views implementing this interface have to listen to these actions.
 *
 * <p>
 *     <b>Table entries</b><br>
 *         The table entries are strings where the first column has to be the ID with which the controller can
 *         get the selected element from the model.
 * </p>
 * <p>
 *     The current implementations of this interface are shown below to give a better overview of the tab structure:<br>
 *     <img src="doc-files/TableTabInterfacesDiagram.png" alt="Implementations of table tab">
 * </p>
 * @author 9045534
 * @version 1.0
 * @see ITab
 */
public interface ITableTab
	extends ITab
{

	/**
	 * Returns the content of the row which is selected by the user. If no row is selected null is returned.
	 * The first entry of the row is always the ID used by the requirement analysis.
	 * @return Content of row which is selected. Null is returned ff no row is selected.
	 */
	public String[] getSelectedRow();

}
