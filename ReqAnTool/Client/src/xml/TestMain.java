package xml;

import Model_Interfaces.*;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

public class TestMain
{
  public static void main(String[]args)
          throws JAXBException, FileNotFoundException, XMLUnmarschallException
  {
    XMLManager manager = XMLManager.getInstance();

    IRequirementAnalysis newReqAn = null;
    try {
      newReqAn = manager.importAnalysis("xmlTest.xml");
    } catch (Exception e) {
      e.printStackTrace();
    }

    FileOperator fp = new FileOperator();
    CustomXMLFormat format = new CustomXMLFormat();

    ArrayList<String> refItems = new ArrayList<String>();
    refItems.add("Eins");
    refItems.add("Zwei");
    refItems.add("Drei");
    CustomerData cd = new CustomerData();
    cd.setPMName("Horst");
    cd.setPMEMail("Horst@gmail");
    cd.setPMPNumber("1234565432");
    cd.setCName("Bums");
    cd.setCNumber("8765345678");
    cd.setCEMail("comp@gmail");
    cd.setCompanyCity("jasl");
    cd.setCompanyCountry("kadfh");
    cd.setCompanyName("akdjhf");
    cd.setCompanyPLZ(1243);
    cd.setCompanyStreet("adföhjsdf");
    FRequirement fr0 = new FRequirement();
    fr0.setActor("akdöufh");
    fr0.setDescription("fghjklsadhghbdnmecjxykjldm");
    fr0.setTitle("asdfkjhadf");
    fr0.setId("1");
    fr0.setReferenceIDs(refItems);
    FRequirement fr1 = new FRequirement();
    fr1.setTitle("adfsgfsh");
    fr1.setDescription("asdgasfuhöef-j ajfae faljfhcal");
    fr1.setActor("sadliha");
    fr1.setId("2");
    fr1.setReferenceIDs(refItems);
    FRequirement fr2 = new FRequirement();
    fr2.setTitle("afbsff");
    fr2.setDescription("asdjadhfcljadnfv");
    fr2.setActor("asfiadjf");
    fr2.setId("3");
    fr2.setReferenceIDs(refItems);
    ArrayList<FRequirement> frList = new ArrayList<FRequirement>();
    frList.add(fr0);
    frList.add(fr1);
    frList.add(fr2);
    DataFP df0 = new DataFP();
    df0.setDet(32);
    df0.setRet(42);
    df0.setType(ClassOfDataFP.ILF_INTERNAL_LOGICAL_FILE);
    df0.setReferenceIDs(refItems);
    df0.setReqID(fr0.getID());
    DataFP df1 = new DataFP();
    df1.setDet(323);
    df1.setRet(142);
    df1.setType(ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE);
    df1.setReferenceIDs(refItems);
    df1.setReqID(fr0.getID());
    DataFP df2 = new DataFP();
    df2.setDet(932);
    df2.setRet(422);
    df2.setType(ClassOfDataFP.ILF_INTERNAL_LOGICAL_FILE);
    df2.setReferenceIDs(refItems);
    df2.setReqID(fr1.getID());
    DataFP df3 = new DataFP();
    df3.setDet(42);
    df3.setRet(421);
    df3.setType(ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE);
    df3.setReferenceIDs(refItems);
    df3.setReqID(fr2.getID());
    DataFP df4 = new DataFP();
    df4.setDet(372);
    df4.setRet(451);
    df4.setType(ClassOfDataFP.EIF_EXTERNAL_INPUT_FILE);
    df4.setReferenceIDs(refItems);
    df4.setReqID(fr1.getID());
    ArrayList<DataFP> dfList = new ArrayList<DataFP>();
    dfList.add(df0);
    dfList.add(df1);
    dfList.add(df2);
    dfList.add(df3);
    dfList.add(df4);
    GlossaryEntry g0 = new GlossaryEntry();
    g0.setBoundary("adfdsljf");
    g0.setLabel("adfjhdf");
    g0.setObscurities("saödhÖALH");
    g0.setReferenceTerms(refItems);
    g0.setSense("adfjh");
    g0.setTerm("adfjkhdf");
    g0.setValidity("asfhjkl");
    GlossaryEntry g1 = new GlossaryEntry();
    g1.setBoundary("ahf.jd");
    g1.setLabel("sal-dj");
    g1.setObscurities("akdfh");
    g1.setReferenceTerms(refItems);
    g1.setSense("öijad");
    g1.setTerm("woiqfnc");
    g1.setValidity("dvjhdsofu");
    GlossaryEntry g2 = new GlossaryEntry();
    g2.setBoundary("jhgfd");
    g2.setLabel("tre");
    g2.setObscurities("dfyb");
    g2.setReferenceTerms(refItems);
    g2.setSense("fg n");
    g2.setTerm("fgvreg");
    g2.setValidity("vbgre5ghq");
    ArrayList<GlossaryEntry> gList = new ArrayList<GlossaryEntry>();
    gList.add(g0);
    gList.add(g1);
    gList.add(g2);
    NFRequirement nfr0 = new NFRequirement();
    nfr0.setActor("adkfhaf");
    nfr0.setDescription("djflhweöf");
    nfr0.setTitle("söoihfe");
    nfr0.setReferenceIDs(refItems);
    nfr0.setId("1");
    NFRequirement nfr1 = new NFRequirement();
    nfr1.setActor("öpoiujh");
    nfr1.setDescription("dxfgchvjbknlm");
    nfr1.setTitle("mcpoejfe");
    nfr1.setReferenceIDs(refItems);
    nfr1.setId("2");
    NFRequirement nfr2 = new NFRequirement();
    nfr2.setActor("aefcnöoef");
    nfr2.setDescription("aciofqefh");
    nfr2.setTitle("acpväoejfe");
    nfr2.setReferenceIDs(refItems);
    nfr2.setId("3");
    ArrayList<NFRequirement> nfrList = new ArrayList<NFRequirement>();
    nfrList.add(nfr0);
    nfrList.add(nfr1);
    nfrList.add(nfr2);
    ProductApplication pa = new ProductApplication();
    pa.setDescription("asfgclnj cöaduvb kjaf");
    ProductData pd0 = new ProductData();
    pd0.setAttribute("sdgsh");
    pd0.setContent("aefrw");
    pd0.setMaxCount("2345");
    pd0.setReferenceIDs(refItems);
    pd0.setId("1");
    ProductData pd1 = new ProductData();
    pd1.setAttribute("aefie");
    pd1.setContent("äölkje");
    pd1.setMaxCount("32");
    pd1.setReferenceIDs(refItems);
    pd1.setId("2");
    ArrayList<ProductData> pdList = new ArrayList<ProductData>();
    pdList.add(pd0);
    pdList.add(pd1);
    QualityRequirement qr0 = new QualityRequirement();
    qr0.setCriteria("ssertzuiop");
    qr0.setValue(Score.NORMAL);
    QualityRequirement qr1 = new QualityRequirement();
    qr1.setCriteria("dfghjkl");
    qr1.setValue(Score.NORMAL);
    QualityRequirement qr2 = new QualityRequirement();
    qr2.setCriteria("poiuztfgvbn");
    qr2.setValue(Score.NORMAL);
    QualityRequirement qr3 = new QualityRequirement();
    qr3.setCriteria("xcvbnmlkjhgf");
    qr3.setValue(Score.NORMAL);
    QualityRequirement qr4 = new QualityRequirement();
    qr4.setCriteria("ölaoie");
    qr4.setValue(Score.NORMAL);
    ArrayList<QualityRequirement> qrList = new ArrayList<QualityRequirement>();
    qrList.add(qr0);
    qrList.add(qr1);
    qrList.add(qr2);
    qrList.add(qr3);
    qrList.add(qr4);
    TargetDefinition td = new TargetDefinition();
    td.setDescription("öpocnd alshc dw3e qiwd");
    TransactionFP tfp0 = new TransactionFP();
    tfp0.setDet(4);
    tfp0.setFtr(2);
    tfp0.setReferenceIDs(refItems);
    tfp0.setType(ClassOfTransactionFP.EI_INPUT);
    tfp0.setReqID(fr0.getID());
    TransactionFP tfp1 = new TransactionFP();
    tfp0.setDet(42);
    tfp0.setFtr(12);
    tfp0.setReferenceIDs(refItems);
    tfp0.setType(ClassOfTransactionFP.EO_OUTPUT);
    tfp0.setReqID(fr2.getID());
    TransactionFP tfp2 = new TransactionFP();
    tfp0.setDet(43);
    tfp0.setFtr(25);
    tfp0.setReferenceIDs(refItems);
    tfp0.setType(ClassOfTransactionFP.EQ_QUERY);
    tfp0.setReqID(fr1.getID());
    ArrayList<TransactionFP> tfpList = new ArrayList<TransactionFP>();
    tfpList.add(tfp0);
    tfpList.add(tfp1);
    tfpList.add(tfp2);
    WeightFactor wf0 = new WeightFactor();
    wf0.setMaxValue(312);
    wf0.setTitle("asfsg");
    wf0.setValue(42);
    WeightFactor wf1 = new WeightFactor();
    wf1.setMaxValue(341);
    wf1.setTitle("dfgvahbfjn");
    wf1.setValue(12);
    ArrayList<WeightFactor> wfList = new ArrayList<WeightFactor>();
    wfList.add(wf0);
    wfList.add(wf1);
    CostEstimation ce = new CostEstimation();
    ce.setDataFPList(dfList);
    ce.setFunctionPoints(77.3);
    ce.setManMonth(42.2);
    ce.setTransactionFPList(tfpList);
    ce.setWeightFactorList(wfList);

    format.setCostEstimation(ce);
    format.setCustData(cd);
    format.setFuncRequirementList(frList);
    format.setGlossary(gList);
    format.setNonFuncRequirementList(nfrList);
    format.setProductApplication(pa);
    format.setProductDataList(pdList);
    format.setQualityRequirementList(qrList);
    format.setTargetDef(td);


    try {
      manager.exportAnalysis(format,"xmlTest.xml", XMLFormatType.CUSTOM_XML_FORMAT);
    } catch (Exception e) {
      e.printStackTrace();
    }

    /*fp.writeToFile("test", format);
    System.out.println("Ich war hier");*/
    
    /*CustomXMLFormat ncf = new CustomXMLFormat();
    //ncf = fp.readFromFile("bums");
    System.out.println("Ich war nochmal hier");*/
    try {
      newReqAn = manager.importAnalysis("xmlTest.xml");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
