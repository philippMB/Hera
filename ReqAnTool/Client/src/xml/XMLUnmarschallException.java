package xml;

/**
 * Created by Philipp on 24.06.17.
 */
public class XMLUnmarschallException
        extends Exception
{
    private final static String EXCEPTION_MESSAGE = "Could not unmarschall requirement analysis from: ";

    public XMLUnmarschallException(String address)
    {
        super(EXCEPTION_MESSAGE + address.toString());
    }
}