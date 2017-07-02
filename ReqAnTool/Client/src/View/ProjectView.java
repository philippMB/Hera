package View;

import Controller_Interfaces.IViewController;
import Logging.ILoggerFactory;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirementAnalysis;
import View_Interfaces.IMenuBar;
import View_Interfaces.IProjectView;
import View_Interfaces.ITab;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by phlippe on 27.04.17.
 */
public class ProjectView
	extends JFrame
	implements IProjectView
{

	private JTabbedPane tabPanel;
	private IModelGetData myModel;
	private IRequirementAnalysis myAnalysis;
	private MenuBar myMenuBar;


	public ProjectView(IModelGetData model)
	{
		super();
		myModel = model;
		myModel.addObserver(this);
		myMenuBar = new StandardMenuBar(true);
		setJMenuBar(myMenuBar);
		myAnalysis = myModel.getReqAnalysis();
		if(myAnalysis != null)
		{
			init();
		}
		else
		{
			ILoggerFactory.getInstance().createLogger().error(
					"RequirementsAnalysis can not be null in the model!"
			);
		}
	}

	private void init()
	{
		setTitle(myAnalysis.getTitle());
		setMinimumSize(new Dimension(550,400));
		setSize(823,400);

		getContentPane().setLayout(new BorderLayout());

		tabPanel = new JTabbedPane();
		getContentPane().add(tabPanel);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	protected void addTab(String tabName, JPanel newTab)
	{
		tabPanel.add(tabName, newTab);
	}

	@Override
	public void addTab(ITab newTab)
	{
		if(newTab instanceof JPanel)
		{
			addTab(newTab.getTabName(), (JPanel)newTab);
		}
	}

	@Override
	public void addController(IViewController newController)
	{
		addWindowListener(newController);
	}

	@Override
	public void showView()
	{
		SwingUtilities.invokeLater(
				() -> {
					setVisible(true);
					repaint();
				}
		);
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	@Override
	public void bringToFront()
	{
		toFront();
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

	/**
	 * Returns the belonging menu bar
	 *
	 * @return Menu bar which belongs to the view
	 */
	@Override
	public IMenuBar getViewMenu()
	{
		return myMenuBar;
	}
}
