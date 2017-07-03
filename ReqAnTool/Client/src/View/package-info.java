/**
 * This package is the realisation of the MVC-View component using Java-Swing.
 * <p>
 * The MVC pattern consists of three basic components:
 * <ul>
 *     <li><b>Model</b> - Managing data, logic and rules of system</li>
 *     <li><b>View</b> - Output representation of information given by the model to user</li>
 *     <li><b>Controller</b> - Interaction with user converting input in view to command of model</li>
 * </ul>
 * In this package the view is realized and will be described further as follows.
 * <p>
 *     <h2>1) Component structure</h2>
 *         To understand how this package is integrated in the system the following diagram shows the component diagram
 *         of this application: <br>
 *         <img src="doc-files/ComponentStructure.png" width="100%" height="auto"  alt="Component structure"><br>
 *             <h3>Connection to controller</h3>
 *         The view provides interfaces for the controller to create and manage views. This includes
 *         a <u>Facade</u> realizing simultaneously a <u>Factory</u> and all views itself, which is described further
 *         in the section <i>4) Inner structure</i>.<br>
 *
 *             <h3>Connection to model</h3>
 *             Due to the application of the view is to present information of the model to the user it has to use
 *             interfaces of it providing getter for all necessary parameter. Application functions or setter are
 *             <b>not</b> used and provided to the view because the view only presents information and does not change.
 *           <br> Next to this it must update its fields if the model is changed. A <u>Observer</u> pattern is used to realize
 *           this connection. Due to views could use Multi-Threading which is a challenge for the observer pattern the
 *           standard {@link java.util.Observer} class is used.<br>
 *
 *             <h3>Connection to LanguageAndText</h3>
 *               Text in views always depend on the current language which is used. In addition many views share e.g.
 *               the same name tags for standard parameter like "ID" or "Description". To standardize the usage of text
 *               and <u>decouple the whole text of every view</u> the <b>LanguageAndText</b> component summarize all
 *               accesses to texts in views while storing it in resource files. This has two main advantages:
 *               <ul>
 *                   <li><b>Language independency</b> - when a different language should be used the component just has
 *                   to change it resource files to the new language. The views will not even notice that the language
 *                   is different and perform exactly the same way. If the language should be changed during execution
 *                   a observer pattern has to be implemented between views and LanguageAndText</li>
 *                   <li><b>Standard messages</b> - especially if the controller wants to raise error dialogs it
 *                   has also to determine which message should be shown. With the LanguageAndText package this
 *  				 dependencies are decoupled of the controller and view and standardized over the whole project.</li>
 *  				 <li><b>Displaying language independent numbers</b> - due to floating point numbers are displayed
 *  				 differently in different cultures and languages (e.g. "8.2" vs. "8,2") this package provides
 *  				 functions to converts numbers to language dependent strings and also the other way round.</li>
 *               </ul>
 *
 *         <br>
 * <p>
 *		<h2>Decoupling components</h2>
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
 *
 *         <img src="doc-files/DecouplingOfComponents.png" width="100%" height="auto"  alt="Component structure"><br>
 * <p>
 *     <h2>3) Enum dependencies</h2><br>
 *         The controller has to know what kind of action events a view throws. To solve this while holding the
 *         independency between controller and view a new interface is defined: {@link Controller_Interfaces.ViewActions}
 *         (see diagram below).<br>
 *		   <img src="doc-files/EnumDependencies.png" width="100%" height="auto"  alt="Enum dependencies"><br>
 *         This enum defines all action commands which a view can throw. The controller can now listen to action events
 *         and determines the view action by comparing the thrown action command with all possible ones. Due to ViewActions
 *         are mostly used for buttons the LanguageAndText package supports the conversion of a
 *         {@link Controller_Interfaces.ViewActions} to the text which should be displayed on this button (see
 *         {@link LanguageAndText.ITextFacade#getButtonText(Controller_Interfaces.ViewActions)}).
 * <p>
 *     <h2>4) Inner structure</h2><br>
 *         For the implementation of views this package uses <b>Java Swing</b>. The advantages of Swing are the generic
 *         views which could be created by execution, and the flexibility of functions. While frameworks like JavaFX
 *         decouples the definition of views in an one file Swing views created in this package are solely build up by
 *         code. This is why a <b>Builder pattern</b> is used to set up all views. The whole inner structure is shown
 *         in the following diagram:<br>
 *         <img src="doc-files/ViewStructure.png" width="100%" height="auto"  alt="Inner structure"><br>
 *             <h3>Facade to controller</h3>
 *             To decouple controller and view the {@link View.ViewFacadeFactory} represents the separation between them.
 *             This class contains three standard design patterns in one:
 *             <ul>
 *                 <li><b>Singleton</b> - only one object should be created so that every controller uses the same
 *                 one for interaction with the view package</li>
 *                 <li><b>Facade</b> - abstracts the whole package to one class</li>
 *                 <li><b>Abstract Factory</b> - determines which view should be created. Although most functions
 *                 determine by their name which view interface type is created and returned but the
 *                 {@link View_Interfaces.IViewFacadeFactory} represents an abstract template what views can be created.
 *                 The real implementation which exact view is created is the task of the concrete factory, which is here
 *                 {@link View.ViewFacadeFactory}</li>
 *             </ul>
 *             <h3>Kind of views</h3>
 *             Views are separated in three different classes in this package:
 *             <ul>
 *                 <li><b>Dialogs</b> - show messages to the user which blocks all different views and could also
 *                 block the running thread (see the class definition of the specific dialogs)</li>
 *                 <li><b>Tabs</b> - tabs in the project view which gives the basic functionality to edit a
 *                 requirement analysis</li>
 *                 <li><b>Formulas</b> - form windows for show, enter or edit information</li>
 *             </ul>
 *             From this basic structure there are many specialisation. But within these classes the views share
 *             their appearance. This is why to creation of views is summarized in <b>Builders</b> which are described
 *             in the next section.
 *             <h3>Builder</h3>
 *             Building up a view is like constructing a complex object which could be simplified by a <b>Builder
 *             pattern</b>. In this case every view creates its own builder by calling the <u>BuilderFactory</u> function
 *             {@link View.PanelBuilderFactory#createPanelBuilder(java.awt.Container)} with itself as parameter. The
 *             factory determines which builder fits the best to the given view and returns it. As a next step the
 *             view selects which view components it needs like
 *             {@link View.PanelBuilder#addNamedTextField(java.lang.String, java.lang.String)} and adds the result to
 *             its own panel by running {@link View.PanelBuilder#getResult()}. With this the whole creation process
 *             and design of the views is standardized in the Builder.<br>
 *                 While the Builder mainly determines where a view component is a {@link View.TextStyleBridge}
 *                 responsible for the design of a text. Due to these both components belong together but could be
 *                 specialized in its own manner a <b>Bridge pattern</b> is used to decouple these both.
 *             <h3>Class diagram</h3>
 *             To finish the package description the following class diagram shows the whole structure of this package as
 *             a hierarchy:<br>
 *         <img src="doc-files/ViewClassDiagramm.png" width="100%" height="auto"  alt="Class diagram"><br>
 *
 *
 * @author 9045534
 * @version 1.0
 *
 */
package View;