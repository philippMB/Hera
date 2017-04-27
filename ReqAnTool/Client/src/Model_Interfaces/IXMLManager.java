package Model_Interfaces;

public interface IXMLManager
{

  public int exportAnalysis(IRequirementAnalysis analysis, String address);

  IRequirementAnalysis importAnalysis(String address);

}
