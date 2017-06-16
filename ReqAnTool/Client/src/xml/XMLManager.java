package xml;

import Model_Interfaces.IXMLManager;
import Model_Interfaces.IRequirementAnalysis;
import Model_Interfaces.XMLErrorCodes;

public class XMLManager
  implements IXMLManager
{
  @Override
  public XMLErrorCodes exportAnalysis(IRequirementAnalysis analysis, String address)
  {
    XMLErrorCodes error = XMLErrorCodes.NO_ERROR;
    XMLExporter exporter;
    exporter = new XMLExporter();
    error = exporter.save(analysis, address);
    return error;
  }

  @Override
  public IRequirementAnalysis importAnalysis(String address)
  {
    IRequirementAnalysis requirementAnalysis;
    XMLImporter importer;
    importer = new XMLImporter();
    requirementAnalysis = importer.load(address);
    return requirementAnalysis;
  }

}
