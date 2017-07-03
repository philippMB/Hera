/**
 * This package provides classes for handling logging in the project to track internal events.
 * <p>
 *     This package contains several classes which provides a simple interface for logging events. The class
 *     structure is shown in the following image:<br>
 * <img src="doc-files/LoggingStructure.png" width="100%" height="auto"  alt="LoggingStructure"><br>
 * <p>
 *     The interfaces {@link Logging.ILogger} and {@link Logging.ILoggerFactory} represent the facade for classes
 *     from other packages who wants to use the provided services for logging of this package. <br>
 *     As the naming indicates the {@link Logging.ILoggerFactory} is an abstract factory for creating and handling
 *     logger. For this it provides a method to get an instance, which access to inner classes of the package to
 *     create a specific factory, and to create a logger. The API for creating such a factory is as follows:<br>
 *         <p>
 *             <code>
 *         			ILoggerFactory myLoggerFactory = ILoggerFactory.getInstance(); //get factory (most time singleton)<br>
 *         			ILogger myLogger = myLoggerFactory.createLogger(); //create default logger <br>
 *         			myLogger.info("This logger was created by an ILoggerFactory"); //example info message  <br>
 *     			</code>
 *         </p>
 *     <br>
 *     The type of these logger is {@link Logging.ILogger} which defines standard methods a logger must support. This
 *     includes the writing of log messages in three different level:
 *     <ul>
 *         <li><b>Info</b> - An information, which could be helpful for debugging. Even many messages could be useful
 *         for debugging it is recommended to use it rarely.
 *         <li><b>Warning</b> - A message to give notice that something unexpected has happened.
 *         <li><b>Error</b> - An error, which occurred while executing. Necessary for debugging.
 *     </ul>
 *
 * <p>
 *     Within this package there are three classes which are implementing the given interfaces above.<br>
 *     To write all log message in a file which is updated while execution the {@link Logging.FileLogger} class
 *     represents a basic element for this. It extends the standard java logger {@link java.util.logging.Logger} and
 *     implements {@link Logging.ILogger} so that all messages are automatically written in a log file.<br>
 *     {@link Logging.TraceLogger} extends this structure by adding the stack trace to every warning and error message.
 *     Thus it is much easier to track the course of events of the problem.<br>
 *     The {@link Logging.TraceLoggerFactory} is a factory using the singleton method to guarantee the uniqueness
 *     of a logger in a project while using {@link Logging.TraceLogger} as standard logger class.
 *     Does a class or object want to create a logger which already exists the factory will
 *     only return the existing logger object and not create a new one. With this different objects can simply agree
 *     on one logger collecting all messages.
 * </p>
 * <p>
 * Detailed information on every class could be found on their specific site.
 * </p>
 * <p>
 * 	<b>Dependencies</b><br>
 * 	The logging package has no dependencies to other packages in this project.
 *
 * @author 9045534
 * @version 1.0
 */
package Logging;