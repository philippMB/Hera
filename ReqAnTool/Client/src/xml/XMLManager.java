package xml;

import Model_Interfaces.IXMLManager;
import Model_Interfaces.IRequirementAnalysis;

public class XMLManager
  implements IXMLManager
{
  private XMLImporter importer;
  private XMLExporter exporter;

  @Override
  public int exportAnalysis(IRequirementAnalysis analysis, String address)
  {
    // TODO Implement this method
    return 0;
  }

  @Override
  public IRequirementAnalysis importAnalysis(String address)
  {
    // TODO Implement this method
    return null;
  }

}
