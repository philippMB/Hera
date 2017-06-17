package View;

import Controller_Interfaces.IController;
import Logging.ILoggerFactory;
import Logging.TraceLoggerFactory;
import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirementAnalysis;
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


	public ProjectView(IModelGetData model)
	{
		super();
		myModel = model;
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
	}

	protected void addTab(String tabName, JPanel newTab)
	{
		tabPanel.add(tabName, newTab);
		repaint();
	}

	@Override
	public void addTab(ITab newTab)
	{
		addTab(newTab.getTabName(), newTab.getPanel());
	}

	@Override
	public void addController(IController newController)
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(newController);
	}

	@Override
	public void showView()
	{
		SwingUtilities.invokeLater(
				() -> setVisible(true)
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

}
