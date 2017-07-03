/**
 * This package provides several exceptions which could be thrown in this project. All exceptions are based on the
 * standard java exception class {@link java.lang.Exception}, which is extended by the {@link Exceptions.LoggedException}.
 * A logged exception writes after its construction a log message in an exception specific log file. So all
 * thrown exceptions in this application are traced in the file {@link Exceptions.LoggedException#LOG_FILE_NAME}.
 * <h2>Overview of exceptions</h2>
 * The following list gives a basic overview of all exceptions which are defined in this package:
 * <ul>
 *     <li>{@link Exceptions.ArgumentPatternException} - gives an error that string does not comply with the needed pattern.
 *     Possible pattern types are listed in {@link Exceptions.PatternType} to give a standard what could be thrown.</li>
 *     <li>{@link Exceptions.DataAccessException} - error while loading or saving a file</li>
 *     <li>{@link Exceptions.DuplicateIDException} - ID which should be created is already used in package</li>
 *     <li>{@link Exceptions.ListOverflowException} - a list contains more elements than the maximum size which is defined for it</li>
 *     <li>{@link Exceptions.MissingCostEstimationException} - cost estimation is needed for execution but it was not created yet</li>
 *     <li>{@link Exceptions.MissingEntryException} - a required text field was not fulfilled</li>
 *     <li>{@link Exceptions.MissingParameterException} - a parameter has to be determined before execution. Possible
 *     parameters are listed in {@link Exceptions.MissingParameter} to give a standard what could be thrown.</li>
 *     <li>{@link Exceptions.MissingReqAnException} - requirement analysis is needed for execution but it was not created yet </li>
 *     <li>{@link Exceptions.NoItemSelectedException} - if item has to be selected in e.g. a table before execution</li>
 *     <li>{@link Exceptions.NumberOutOfBoundsException} - if a number has to be in specific bounds which is not given here.</li>
 *     <li>{@link Exceptions.StringNoNumberException} - if a string could not be converted to a given number. Possible number
 *     types are listed in {@link Exceptions.NumberType} to give a standard what could be thrown.</li>
 *     <li>{@link Exceptions.UnknownEPException} - if a elementary process for a given ID does not exist</li>
 *     <li>{@link Exceptions.UnknownIDException} - if for an ID no belonging requirement could be found</li>
 *     <li>{@link Exceptions.UnknownReferenceException} - if the reference list of a requirement contains ID which are
 *     not known in the application</li>
 * </ul>
 * <h2>Class diagram</h2>
 * For illustration the class diagram of this package is shown below:
 * <img src="doc-files/ExceptionClassDiagram.png" width="100%" height="auto"  alt="Class diagram"><br>
 *
 * @author 9045534
 * @version 1.0
 */
package Exceptions;