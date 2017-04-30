package View;

import Model_Interfaces.IModelGetData;
import Model_Interfaces.IRequirementAnalysis;
import View_Interfaces.IProjectView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
		init();
	}

	private void init()
	{
		setTitle("Anforderungsanalyse \""+myAnalysis.getTitle()+"\"");
		setMinimumSize(new Dimension(550,400));
		setSize(823,400);

		getContentPane().setLayout(new BorderLayout());

		tabPanel = new JTabbedPane();
		getContentPane().add(tabPanel);

		//Nicht direkt sichtbar, da zunächst Tabs hinzugefügt werden müssen
	}

	protected void addTab(String tabName, JPanel newTab)
	{
		tabPanel.add(tabName, newTab);
		repaint();
	}

	protected void addTab(TabPanel newTab)
	{
		addTab(newTab.getTabName(), newTab);
	}

	@Override
	public void addController(ActionListener newListener)
	{
		//Nothing to be controlled...
	}

	@Override
	public void destruct()
	{
		setVisible(false);
		dispose();
	}

	@Override
	public void update(Observable o, Object arg)
	{

	}

}
