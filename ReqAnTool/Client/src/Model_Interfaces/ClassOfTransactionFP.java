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
 * @author 7532274
 * @version 1.0
 *
 * @see ITransactionFP
 */
public enum ClassOfTransactionFP
{
    EI_INPUT,
    EO_OUTPUT,
    EQ_QUERY
}
