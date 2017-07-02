package View_Interfaces;

/**
 * This interface builds up a standard structure for view for adding and editing a requirement.
 * A requirement has some parameters which are shared between functional, nonfunctional requirements and product data.
 * To this belongs
 * <ul>
 *     <li><b>ID</b> - unique identifier of requirement</li>
 *     <li><b>References</b> - references to other requirements</li>
 * </ul>
 * References are a more complicated parameter for editing because they have a limited range of values and could be
 * added and deleted. This is why this interface contains multiple functions for interactions with the controller. In
 * addition this view provides the following view actions:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#SAVE} - saves changes of requirement</li>
 *     <li>{@link Controller_Interfaces.ViewActions#DELETE} - cancels changes of requirement</li>
 *     <li>{@link Controller_Interfaces.ViewActions#TABLE_SELECTION_ADD} - adds reference which is selected</li>
 *     <li>{@link Controller_Interfaces.ViewActions#TABLE_SELECTION_DELETE} - deletes reference which is selected</li>
 * </ul>
 * A controller for this view has to observe these view actions and, especially for the references, controls these actions
 * by calling the functions of this interface. In addition this interface extends {@link ITextView} so that the text
 * fields could be controlled on change.
 *
 * @author 9045534
 * @version 1.0
 * @see ITextView
 */
public interface IRequirementFormView
	extends IView, ITextView
{

	/**
	 * Returns ID entry for requirement
	 * @return ID entry for requirement
	 */
	public String getIDEntry();

	/**
	 * Returns all references IDs which are chosen by the user.
	 * @return References ID of this requirement
	 */
	public String[] getRefEntry();

	/**
	 * Returns reference's ID which is selected to be added
	 * @return Reference to be added
	 */
	public String getSelectedRefToAdd();

	/**
	 * Returns reference's ID which is selected to be deleted
	 * @return Reference to be deleted
	 */
	public String getSelectedLinkToDelete();

	/**
	 * Adds selected reference to the set of chosen references for the requirement
	 */
	public void addSelectedRef();

	/**
	 * Removes selected reference to the set of chosen references for the requirement
	 */
	public void deleteSelectedRef();

}
