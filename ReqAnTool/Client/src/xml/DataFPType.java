package xml;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
public enum DataFPType
{
  ILF_INTERNAL_LOGICAL_FILE,
  EIF_EXTERNAL_INPUT_FILE;
  
  public static DataFPType getILF_INTERNAL_LOGICAL_FILE()
  {
    return ILF_INTERNAL_LOGICAL_FILE;
  }

  public static DataFPType getEIF_EXTERNAL_INPUT_FILE()
  {
    return EIF_EXTERNAL_INPUT_FILE;
  }
}
