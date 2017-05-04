package View_Interfaces;

/**
 * Created by phlippe on 30.04.17.
 */
public interface ITextTab
	extends ITab
{

	public String getDescription();

	public void setSaved(boolean saved);

	public boolean isSaved();

}
