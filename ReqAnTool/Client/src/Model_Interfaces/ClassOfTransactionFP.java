package Model_Interfaces;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
/**
 * Describes the type of the TransactionFunctionPoint.
 * Type is input, output or query.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @author
 * @version 1.0
 *
 * @see ITransactionFP
 */
public enum ClassOfTransactionFP
    implements IClassOfFP
{
    EI_INPUT,
    EO_OUTPUT,
    EQ_QUERY
}
