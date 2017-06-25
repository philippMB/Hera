package xml;

import Model_Interfaces.IRequirementAnalysis;

/**
 * Created by Philipp on 24.06.17.
 */
public class XMLMarschallingException
    extends Exception
{
    private final static String EXCEPTION_MESSAGE = "Could not marschall requirement analysis: ";

    public XMLMarschallingException(IRequirementAnalysis analysis)
    {
        super(EXCEPTION_MESSAGE + analysis.getTitle());
    }
}
