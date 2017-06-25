package View_Interfaces;

/**
 * This interface extends {@link IRequirementFormView} by adding text fields for specific parameter of product data.
 *
 * @author 9045534
 * @version 1.0
 * @see IRequirementFormView
 */
public interface IProductDataEditView
	extends IRequirementFormView
{

	/**
	 * Returns text field entry for the content of the product data
	 * @return Entry for content
	 */
	public String getContentEntry();

	/**
	 * Returns text field entry for the max count of the product data
	 * @return Entry for max count
	 */
	public String getMaxCountEntry();

	/**
	 * Returns text field entry for the attribute of the product data
	 * @return Entry for attribute
	 */
	public String getAttributeEntry();

}
