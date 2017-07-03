package View_Interfaces;

/**
 * This interface defines the basic functionality for editing a cost estimation in a view.
 * <p>
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
 *
 *
 * @author 9045534
 * @version 1.0
 * @see IProcessClassificationView
 * @see ICostEstimationEditView
 */
public interface ICostEstimationEditView
	extends IView
{

	/**
	 * Returns the ID of the selected requirement as elementary process
	 * @return ID of selected requirement. If no element is selected null will be returned.
	 */
	public String getSelectedID();

}
