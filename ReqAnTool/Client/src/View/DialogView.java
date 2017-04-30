package View;

import View_Interfaces.IView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by phlippe on 27.04.17.
 */
public abstract class DialogView
	extends JDialog
{

	protected JPanelBuilder myBuilder;

	public DialogView(String title){
		super((JFrame)null, title);

		setSize(300,200);   //Ungefähre Größe, damit Factory richtigen Builder erzeugen kann
		setResizable(false);
		setModal(true);

		myBuilder = JPanelBuilderFactory.getInstance().createPanelBuilder(this);
	}

	protected abstract void init();

	public void destruct()
	{
		setVisible(false);
		dispose();
	}

}
