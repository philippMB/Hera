/**
 * This package provides a language independent management of text for GUI applications.
 * <p>
 *     <h2>General</h2>
 *     Text in views always depend on the current language which is used. In addition many views share e.g.
 *  the same name tags for standard parameter like "ID" or "Description". To standardize the usage of text
 *  and <u>decouple the whole text of every view</u> the <b>LanguageAndText</b> component summarize all
 *  accesses to texts in views while storing it in resource files. This has two main advantages:
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
 *  <p>
 *      <h2>Interfaces</h2>
 *      To other components the {@link LanguageAndText.ITextFacade} is the main class managing the interaction with these.
 *      The other classes and especially the realization is only used inside the package which is described in the
 *      next section. <br>
 *          The interface splits text in four types:
 *          <ul>
 *              <li><b>Button</b> - text for buttons, also possible to get for {@link Controller_Interfaces.ViewActions}</li>
 *              <li><b>Dialog</b> - message which should be displayed in dialogs. Contains placeholder for adjust the message
 *              (see {@link LanguageAndText.ITextFacade#getDialogText(java.lang.String, java.lang.String[])})</li>
 *              <li><b>Parameter</b> - name tags for parameters, especially for form views</li>
 *              <li><b>Title</b> - titles of views</li>
 *          </ul>
 *          To get the concrete text for a property the calling object has to know what under what property name its
 *          needed text stands. For this there are many constants listed in this package which should be used:
 *          <ul>
 *              <li>{@link LanguageAndText.DialogConstants} - defines dialog property constants for warnings and infos</li>
 *              <li>{@link LanguageAndText.ExceptionToTextConverter} - defines dialog properties for exception dialogs</li>
 *              <li>{@link LanguageAndText.TextNameConstants} - general file with title and parameter property constants</li>
 *              <li>{@link Controller_Interfaces.ViewActions} - string is used as property name for buttons</li>
 *          </ul>
 *      <h2>Inner structure</h2>
 *      The basic structure of this package is the {@link LanguageAndText.TextFacade}. For accessing resource files
 *      the class {@link LanguageAndText.TextResourceBundle} abstracts all functions for that. The TextFacade has for
 *      every resource file one object of this and passes the request of the other components further to them. <br>
 *     <img src="doc-files/LanguageAndTextStructure.png" width="100%" height="auto"  alt="Class structure LanguageAndText"><br>
 *
 *
 * @author 9045534
 * @version 1.0
 */
package LanguageAndText;