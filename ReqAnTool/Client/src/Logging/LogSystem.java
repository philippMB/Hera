package Logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 * Created by phlippe on 01.05.17.
 */
public class LogSystem
{

	private static Logger myLogger;


	public static Logging.Logger getLogger()
	{
		if(myLogger == null)
		{
			myLogger = buildTraceLogger();
		}
		return myLogger;
	}

	private static TraceLogger buildTraceLogger()
	{
		TraceLogger newLogger = new TraceLogger("MyLogger",null);

		FileHandler fh;
		try {

			// This block configure the logger with handler and formatter
			fh = new FileHandler("ReqAnLog.log",true);
			newLogger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			// the following statement is used to log any messages
			newLogger.info("Logger started");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return newLogger;
	}

}
