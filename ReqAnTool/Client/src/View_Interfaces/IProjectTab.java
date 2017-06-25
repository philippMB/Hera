package View_Interfaces;

/**
 * This tab interface provides basic functionality for managing the opened requirement analysis.
 * It includes following view actions:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#SAVE} - saves requirement analysis</li>
 *     <li>{@link Controller_Interfaces.ViewActions#TO_PDF} - exports requirement analysis to PDF</li>
 *     <li>{@link Controller_Interfaces.ViewActions#TO_XML} - exports requirement analysis to XML</li>
 *     <li>{@link Controller_Interfaces.ViewActions#DELETE} - deletes requirement analysis</li>
 *     <li>{@link Controller_Interfaces.ViewActions#CLOSE} - closes requirement analysis</li>
 * </ul>
 * The controller has to observe these actions and react to them.
 *
 * @author 9045534
 * @version 1.0
 *
 */
public interface IProjectTab
	extends ITab
{

}
