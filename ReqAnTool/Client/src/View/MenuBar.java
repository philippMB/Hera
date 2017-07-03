package View;

import Controller_Interfaces.IMenuController;
import LanguageAndText.ITextFacade;
import View_Interfaces.IMenuBar;
import View_Interfaces.IView;

import javax.swing.*;
import java.util.ArrayList;

/**
 * This class sets up a standard for menu bars of {@link IView}.
 * Every view could have a menu bar. Due to mostly the menu bar is shared between different views they both
 * are separated and should be separately controlled. Which view actions are exactly provided in a menu is specified
 * within the implementation of the view and should be seen as every view actions would be implemented for the
 * controller.
 * <p>
 *     The scope of functions depends on if a project/requirement analysis is opened or not. To handle this case
 *     the function {@link MenuBar#setProjectOpen(boolean)} provides a mechanism to set this restriction or not. The
 *     controller should observe the model and set or unset it when needed.
 * <p>
 * 		This class is only a template for how a menu bar is organized but does not contain any menu items. This is why
 * 		the class is abstract.
 *
 * @author 9045534
 * @version 1.0
 * @see IView
 */
public abstract class MenuBar
	extends JMenuBar
	implements IMenuBar
{

	protected ITextFacade myTextFacade;
	protected ArrayList<JMenu> allMenus;
	protected ArrayList<JMenuItem> itemsNeedOpenProject;


	/**
	 * Default constructor initializing the menu bar
	 */
	public MenuBar()
	{
		myTextFacade = ITextFacade.getInstance();
		allMenus = new ArrayList<>();
		itemsNeedOpenProject = new ArrayList<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProjectOpen(boolean isProjectOpen)
	{
		for(JMenuItem item: itemsNeedOpenProject)
		{
			item.setEnabled(isProjectOpen);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addController(IMenuController menuController)
	{
		for(JMenu menu: allMenus)
		{
			menu.addActionListener(menuController);
			for(int menuItemIndex = 0;menuItemIndex < menu.getItemCount(); menuItemIndex++)
			{
				if(menu.getItem(menuItemIndex) != null)
				{
					menu.getItem(menuItemIndex).addActionListener(menuController);
				}
			}
		}
	}

}
