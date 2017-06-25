package View_Interfaces;

/**
 * This interface extends {@link IRequirementFormView} by adding text fields for specific parameter of functional
 * requirements.
 *
 * @author 9045534
 * @version 1.0
 * @see IRequirementFormView
 */
public interface IFRequirementEditView
	extends IRequirementFormView
{

	/**
	 * Returns entry in the text field for the title
	 * @return Entry for title
	 */
	public String getTitleEntry();

	/**
	 * Returns entry in the text field for the actor
	 * @return Entry for actor
	 */
	public String getActorEntry();

	/**
	 * Returns entry in the text field for the description
	 * @return Entry for description
	 */
	public String getDescriptionEntry();

}
