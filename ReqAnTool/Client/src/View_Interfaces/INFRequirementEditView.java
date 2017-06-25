package View_Interfaces;

/**
 * This interface extends {@link IRequirementFormView} by adding text fields for specific parameter of nonfunctional
 * requirements.
 *
 * @author 9045534
 * @version 1.0
 * @see IRequirementFormView
 */
public interface INFRequirementEditView
	extends IRequirementFormView
{

	/**
	 * Returns the text field entry for title
	 * @return Entry for title
	 */
	public String getTitleEntry();

	/**
	 * Returns the text field entry for description
	 * @return Entry for description
	 */
	public String getDescriptionEntry();

}
