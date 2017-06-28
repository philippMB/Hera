package xml;

import Model_Interfaces.IRequirementAnalysis;

/**
 * Created by Philipp on 24.06.17.
 */

/**
 * This Exception is thrown whenever there is an error while creating the XML file from the requirement analysis class.
 * This Exception is an addition to the {@link javax.xml.bind.JAXBException} and covers all errors that are now
 * caught in the JAXBException.
 *
 * @author 3852430
 * @version 1.0
 */
public class XMLMarschallingException
    extends Exception
{
    private final static String EXCEPTION_MESSAGE = "Could not marschall requirement analysis: ";

    /**
     * The constructor for the XMLMarschallingException.
     * The exception message should provide the title of the requirement analysis that causes the error.
     * @param analysis The requirement analysis that caused the error
     */
    public XMLMarschallingException(IRequirementAnalysis analysis)
    {
        super(EXCEPTION_MESSAGE + analysis.getTitle());
    }
}
