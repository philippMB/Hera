package xml;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import javax.xml.bind.JAXBException;

public class TestMain
{
  public static void main(String[]args)
    throws JAXBException, FileNotFoundException
  {
    FileOperator fp = new FileOperator();
    CustomXMLFormat format = new CustomXMLFormat();
    
    CostEstimation ce = new CostEstimation(42.2, 77.3);
    CustomerData cd = new CustomerData("Horst Schröder", "1234567", "hörst@gmx.de", "Peter Enis", "098765432", "p.enis@googlemail.com", "Cumming", "Löchle", 12344, "Die Besorger", "Uruguay");
    DataFP df0 = new DataFP(32, 42);
    DataFP df1 = new DataFP(323, 142);
    DataFP df2 = new DataFP(932, 422);
    DataFP df3 = new DataFP(42, 421);
    DataFP df4 = new DataFP(372, 451);
    ArrayList<DataFP> dfList = new ArrayList<DataFP>();
    dfList.add(df0);
    dfList.add(df1);
    dfList.add(df2);
    dfList.add(df3);
    dfList.add(df4);
    FRequirement fr0 = new FRequirement("Höhe", "PHLIPPE", "Ich hätte da mal ne allgemeine Frage zu Ihrer Vorlesung");
    FRequirement fr1 = new FRequirement("Breite", "PHLIPPE", "Häääää?");
    FRequirement fr2 = new FRequirement("Länge", "PHLIPPE", "Raaaaus!");
    ArrayList<FRequirement> frList = new ArrayList<FRequirement>();
    frList.add(fr0);
    frList.add(fr1);
    frList.add(fr2);
    GlossaryEntry g0 = new GlossaryEntry("Penis", "High", "Schaft", "p.enis", "valid!", "No!");
    GlossaryEntry g1 = new GlossaryEntry("Vaniga", "High", "Brücke", "v.gina", "valid!", "Was?");
    GlossaryEntry g2 = new GlossaryEntry("Bohl", "low", "dumm", "dümmer", "Peter", "Prtoket");
    ArrayList<GlossaryEntry> gList = new ArrayList<GlossaryEntry>();
    gList.add(g0);
    gList.add(g1);
    gList.add(g2);
    NFRequirement nfr0 = new NFRequirement("Tiefe", "MBILLH", "Also, wie viele Katzen passen hier rein?");
    NFRequirement nfr1 = new NFRequirement("Hölle", "MBILLH", "Was?");
    NFRequirement nfr2 = new NFRequirement("Himmel", "MBILLH", "Was?");
    ArrayList<NFRequirement> nfrList = new ArrayList<NFRequirement>();
    nfrList.add(nfr0);
    nfrList.add(nfr1);
    nfrList.add(nfr2);
    ProductApplication pa = new ProductApplication("Mein Haus, mein Block, mein wasweißich");
    ProductData pd0 = new ProductData("Mister", "Strahlenschutz", "Babilon");
    ProductData pd1 = new ProductData("Die", "alte", "Türksau");
    ArrayList<ProductData> pdList = new ArrayList<ProductData>();
    pdList.add(pd0);
    pdList.add(pd1);
    QualityRequirement qr0 = new QualityRequirement("Robustheit");
    QualityRequirement qr1 = new QualityRequirement("Sicherheit");
    QualityRequirement qr2 = new QualityRequirement("Bedienbarkeit");
    QualityRequirement qr3 = new QualityRequirement("Portabilität");
    QualityRequirement qr4 = new QualityRequirement("Wartbarkeit");
    ArrayList<QualityRequirement> qrList = new ArrayList<QualityRequirement>();
    qrList.add(qr0);
    qrList.add(qr1);
    qrList.add(qr2);
    qrList.add(qr3);
    qrList.add(qr4);
    TargetDefinition td = new TargetDefinition("Was soll das?");
    TransactionFP tfp0 = new TransactionFP(4, 2);
    TransactionFP tfp1 = new TransactionFP(42, 12);
    TransactionFP tfp2 = new TransactionFP(43, 25);
    ArrayList<TransactionFP> tfpList = new ArrayList<TransactionFP>();
    tfpList.add(tfp0);
    tfpList.add(tfp1);
    tfpList.add(tfp2);
    WeightFactor wf0 = new WeightFactor("Egal", 42, 321);
    WeightFactor wf1 = new WeightFactor("Oder", 12, 341);
    ArrayList<WeightFactor> wfList = new ArrayList<WeightFactor>();
    wfList.add(wf0);
    wfList.add(wf1);

    format.setCostEstimation(ce);
    format.setCustData(cd);
    format.setDataFuncPointList(dfList);
    format.setFuncRequirementList(frList);
    format.setGlossary(gList);
    format.setNonFuncRequirementList(nfrList);
    format.setProductApplication(pa);
    format.setProductDataList(pdList);
    format.setQualityRequirementList(qrList);
    format.setTargetDef(td);
    format.setTransactionFPList(tfpList);
    format.setWeightFactorList(wfList);
    
    fp.writeToFile("test", format);
    System.out.println("Ich war hier");
    
    CustomXMLFormat ncf;
    ncf = fp.readFromFile("bums");
    System.out.println("Ich war nochmal hier");
  }
}
