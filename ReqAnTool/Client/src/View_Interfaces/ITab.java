package View_Interfaces;

/**
 * This interface defines a basic structure of tabs used for {@link IProjectView}. It is based on {@link IView}.
 * <p>
 *     To structure the view for editing a requirement analysis it is separated in tabs. Every tab provides different
 *     functionality but have all the same basis structure which is defined in this interface.
 * </p>
 * <p>
 *     A tab has a name which is displayed in the tab bar. It has the getter {@link ITab#getTabName()}. Further functions
 *     are not needed. When implementing this please be sure that tabs have a compatible type for the {@link IProjectView}
 *     to add.
 * </p>
 * <p>
 *     The overall structure of the tab classes is shown in the diagram below. It has to specialisations {@link ITextTab}
 *     and {@link ITableTab} which aggregates basic standards for tabs working with pure text or tables. Other more
 *     extraordinary tabs are direct subclasses of this interface.
 *     <img src="doc-files/TabInterfacesDiagram.png" alt="Class structure of tabs">
 * </p>
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 * @see IProjectView
 * @see ITextTab
 * @see ITableTab
 */
public interface ITab
	extends IView
{

	/**
	 * Returns the tab name which should be displayed in tab bar.
	 * @return Name of the tab
	 */
	public String getTabName();

}
