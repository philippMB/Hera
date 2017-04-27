package Model_Interfaces;

public interface IXMLManager
{

  int exportAnalysis(IRequirementAnalysis analysis, String address);

  public IRequirementAnalysis importAnalysis();

}
