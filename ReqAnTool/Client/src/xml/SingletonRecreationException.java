package xml;

/**
 * Created by Philipp on 24.06.17.
 */
public class SingletonRecreationException
        extends Exception
{
    private final static String EXCEPTION_MESSAGE = " could not be created, because there is already an instance of this class ";

    public SingletonRecreationException(Object type)
    {
        super(type.getClass().toString() + EXCEPTION_MESSAGE);
    }
}
