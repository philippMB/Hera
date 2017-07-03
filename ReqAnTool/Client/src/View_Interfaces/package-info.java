/**
 *
 * This package summarizes all interfaces for decoupling the view of its own implementation.
 *
 * <h2>Decoupling components</h2>
 *		The problem of the MVC pattern when used only these components is the coupling between model, view and
 *		controller. None of them can be replaced without adjusting the other components. To attack this problem every
 *		component gets a extra component in which only the interfaces are determined. In addition every realization
 *		component of model, view and controller <b>exclusively interacts with interfaces</b> of the other components.<br>
 *		With this structure the view package is completely decoupled of the model and controller package. It only
 *		gets their interfaces and uses them. On the other side the controller only interacts with the view interface
 *		package and does not know anything about the real realization. The view interface package is with only one
 *		connection bounded to this realization:
 *		{@link View_Interfaces.IViewFacadeFactory#getInstance(Model_Interfaces.IModelGetData)}. If another view
 *		realization should be used the created FacadeFactory has to changed in this function.<br>
 *		 The diagram below shows the decoupling of components in this application:
 *         <img src="doc-files/DecouplingOfComponents.png" width="100%" height="auto"  alt="Component structure"><br>
 *
 * <h2>Structure of interfaces</h2>
 * The basic view interface is {@link View_Interfaces.IView}. This interface contains basic functionality which must be
 * provided by every view like {@link View_Interfaces.IView#showView()} and
 * {@link View_Interfaces.IView#addController(Controller_Interfaces.IViewController)}. From this one out there are
 * many specialisation of the views, e.g.:
 * <ul>
 *     <li>{@link View_Interfaces.ITab} - Views of this interface are capable to be a tab in {@link View_Interfaces.IProjectView}
 *     and are not an own window</li>
 *     <li>{@link View_Interfaces.IDialog} - show messages to the user which blocks all different views and could also
 *                 block the running thread (see the class definition of the specific dialogs)</li>
 * </ul>
 * For creation of views the class {@link View_Interfaces.IViewFacadeFactory} provides an API from which e.g. the
 * controller could easily create views independently of the real implementation of views.
 *
 * <h2>Class diagram</h2>
 * For visualization of all relationships between classes is a class diagram of the whole
 * <img src="doc-files/View_Interfaces_Structure.png" width="100%" height="auto" alt="View interface structure"><br>
 *
 * @author 9045534
 * @version 1.0
 */
package View_Interfaces;