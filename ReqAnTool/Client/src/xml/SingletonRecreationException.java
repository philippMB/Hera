package xml;

/**
 * Created by Philipp on 24.06.17.
 */

/**
 * This Exception is thrown whenever there is an error while instantiating an instance of a singleton.
 * This Exception is thrown if there is already an instance of a singleton in the system and another instance should be
 * instantiated.
 *
 * @author 3852430
 * @version 1.0
 */
public class SingletonRecreationException
        extends Exception
{
    private final static String EXCEPTION_MESSAGE = " could not be created, because there is already an instance of " +
            "this class ";

    /**
     * The constructor for the SingletonRecreationException.
     * The exception message should provide the singleton class which is requested to be instantiated although there is
     * already an instance of this class present.
     * @param type The singleton object which should be instantiated although there is already an instance present.
     */
    public SingletonRecreationException(Object type)
    {
        super(type.getClass().toString() + EXCEPTION_MESSAGE);
    }
}
