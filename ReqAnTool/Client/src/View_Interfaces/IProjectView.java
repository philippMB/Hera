package View_Interfaces;

/**
 * This interface defines the basic view structure for editing a requirement analysis.
 * <p>
 *     For editing a requirement analysis the view has to provide many functions. Splitting these functions up to tabs
 *     which could be design individually in different classes gives a better overview. This is why {@link ITab} instances
 *     could be added dynamically to the main view giving the needed functionality.
 * </p>
 * <p>
 *     To build up the whole main view an view of this interface has to be created and then creating and adding tabs to
 *     this one. This modularity is done to give also the controller the possibility to split up.
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 * @see ITab
 */
public interface IProjectView
	extends IView
{

	/**
	 * Appends a new tab to the current tab panel. For displaying the name in the tab bar {@link ITab#getTabName()} is
	 * used.
	 * @param newTab Tab which should be added
	 */
	public void addTab(ITab newTab);

}
