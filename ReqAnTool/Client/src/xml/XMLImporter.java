package xml;

import Model_Interfaces.IRequirementAnalysis;

public class XMLImporter
{
  private IRequirementAnalysis reqData = null;



  public IRequirementAnalysis load(String address)
  {
    IXMLFormat customData;
    customData = loadFrom(address);
    if (customData == null)
    {
      System.out.println("Failed to read data from file.");
      return null;
    }
    else
    {
      reqData = unmarshall();
    }
    return reqData;
  }

  private IRequirementAnalysis unmarshall()
  {
    return reqData;
  }

  private IXMLFormat loadFrom(String address)
  {
    FileOperator fileOperator = new FileOperator();
    IXMLFormat customData;
    customData = fileOperator.readFromFile(address, CustomXMLFormat.class);
    return customData;
  }
}
