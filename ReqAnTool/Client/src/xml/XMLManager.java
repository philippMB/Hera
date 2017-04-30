package xml;

import Model_Interfaces.IXMLManager;
import Model_Interfaces.IRequirementAnalysis;

public class XMLManager
  implements IXMLManager
{
  private XMLImporter importer;
  private XMLExporter exporter;
  private int ret = 0;
  private IRequirementAnalysis requirementAnalysis;

  @Override
  public int exportAnalysis(IRequirementAnalysis analysis, String address)
  {
    exporter = new XMLExporter();
    ret = exporter.save(analysis, address);
    return ret;
  }

  @Override
  public IRequirementAnalysis importAnalysis(String address)
  {
    importer = new XMLImporter();
    requirementAnalysis = importer.load(address);
    return requirementAnalysis;
  }

}
