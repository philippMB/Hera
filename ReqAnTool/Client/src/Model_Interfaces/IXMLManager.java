package Model_Interfaces;

import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

public interface IXMLManager
{

  public int exportAnalysis(IRequirementAnalysis analysis, String address)
    throws JAXBException, FileNotFoundException;

  public IRequirementAnalysis importAnalysis(String address);

}
