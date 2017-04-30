package xml;

public class XMLFormatFactory
{
  public IXMLFormat xmlFormat(int pick)
  {
    switch(pick)
    {
      case 1:
        return new CustomXMLFormat();
      case 2:
        return new RequirementsInterchangeFormat();
      default:
        System.out.println("Unknown option.");
        return null;
    }
  }
}
