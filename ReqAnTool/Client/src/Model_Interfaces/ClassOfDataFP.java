package Model_Interfaces;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
/**
 * Describes the type of the DataFunctionPoint.
 * Type is either internal logical file or external logical file.
 * For more detailed information please refer to the ReqAn specification.
 *
 * @autor 7532274
 * @version 1.0
 *
 * @see IDataFP
 */
public enum ClassOfDataFP
{
    ILF_INTERNAL_LOGICAL_FILE,
    EIF_EXTERNAL_INPUT_FILE
}
