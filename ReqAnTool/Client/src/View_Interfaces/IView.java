package View_Interfaces;

import Controller_Interfaces.IController;

import java.util.Observer;


/**
 * Created by phlippe on 27.04.17.
 */
public interface IView
	extends Observer
{

	public void addController(IController newController);	//Fügt einen Controller zu jedem Button hinzu

	public void destruct();	//Ausblenden und Löschen von Views (falls nicht mehr benötigt)

}
