package xml;

import Model_Interfaces.IRequirementAnalysis;

public interface IXMLFormat
    extends IRequirementAnalysis
{
    void createFragments(IRequirementAnalysis rawData);
}
