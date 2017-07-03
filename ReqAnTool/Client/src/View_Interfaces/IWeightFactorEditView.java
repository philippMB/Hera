package View_Interfaces;

import java.util.Map;

/**
 * Views implementing this interface provide basic functionality to edit weight factors of a cost estimation.
 * For this it has a structure where the user can simply change the value for every single weight factor. Due to the
 * values are in a specific bound views are not returning string entries but directly the integer value which was
 * entered.
 *
 * @author 9045534
 * @version 1.0
 *
 */
public interface IWeightFactorEditView
	extends IView
{

	/**
	 * Returns the entered value for a specific weight factor identified by its title.
	 * @param title Identifier for weight factor
	 * @return Entered value by user
	 */
	public int getValueByTitle(String title);

	/**
	 * Returns a Map of all weight factors which could be edited to the entered value for each of them.
	 * @return Map of weight factor title to entered value
	 */
	public Map<String, Integer> getAllWeightFactorValues();

}
