package Model_Interfaces;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum ClassOfTransactionFP implements IClassOfFP
{
    EI_INPUT,
    EO_OUTPUT,
    EQ_QUERY
}
