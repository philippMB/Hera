package View_Interfaces;

/**
 * Created by phlippe on 30.04.17.
 */
public interface IRequirementFormView
	extends IView
{

	public String getIDEntry();

	public String getSelectedLink();

	public void addSelectedLink();

	public void deleteSelectedLink();

}
