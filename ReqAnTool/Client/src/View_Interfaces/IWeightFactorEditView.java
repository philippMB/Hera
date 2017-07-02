package View_Interfaces;

import java.util.Map;

/**
 * //TODO: Comment this
 * @author 9045534
 * @version 1.0
 *
 */
public interface IWeightFactorEditView
	extends IView
{

	public int getValueByTitle(String title);

	public Map<String, Integer> getAllWeightFactorValues();

}
