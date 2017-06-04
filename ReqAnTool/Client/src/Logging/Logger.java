package Logging;

/**
 * Created by phlippe on 24.05.17.
 */
public interface Logger
{

	public void warning(String msg);

	public void warning(String msg, Exception thrownException);

}
