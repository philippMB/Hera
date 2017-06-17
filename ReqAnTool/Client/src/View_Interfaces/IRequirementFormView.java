package View_Interfaces;

/**
 * Created by phlippe on 30.04.17.
 */
public interface IRequirementFormView
	extends IView
{

	public String getIDEntry();

	public String[] getRefEntry();

	public String getSelectedRefToAdd();

	public String getSelectedLinkToDelete();

	public void addSelectedRef();

	public void deleteSelectedRef();

}
