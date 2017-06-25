package View_Interfaces;

/**
 * This view is shown by starting the application. For this it provides four view actions to the user:
 * <ul>
 *     <li>{@link Controller_Interfaces.ViewActions#NEW_PROJECT} - opens a {@link IProjectCreateView} for creating
 *     a new requirement analysis</li>
 *     <li>{@link Controller_Interfaces.ViewActions#OPEN_PROJECT} - opens a requirement analysis specified by a
 *     {@link IFileChooser}</li>
 *     <li>{@link Controller_Interfaces.ViewActions#FROM_XML} - import a requirement analysis specified by a
 *     {@link IFileChooser}</li>
 *     <li>{@link Controller_Interfaces.ViewActions#CLOSE} - closes the application</li>
 * </ul>
 * The controller has to observe these actions and react to them.
 *
 * @author 9045534
 * @version 1.0
 *
 */
public interface IStartView
	extends IView
{

}
