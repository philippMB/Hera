package Logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by phlippe on 01.05.17.
 */
public class LogSystem
{

	private static Logger myLogger;

	public static Logger getLogger()
	{
		if(myLogger == null)
		{
			myLogger = Logger.getLogger("MyLog");
			FileHandler fh;
			try {

				// This block configure the logger with handler and formatter
				fh = new FileHandler("ReqAnLog.log");
				myLogger.addHandler(fh);
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter(formatter);

				// the following statement is used to log any messages
				myLogger.info("Logger started");
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return myLogger;
	}
}
