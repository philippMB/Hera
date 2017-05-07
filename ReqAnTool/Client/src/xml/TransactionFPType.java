package xml;

public enum TransactionFPType
{
  EI_INPUT,
  EO_OUTPUT,
  EQ_QUERY;

  public static TransactionFPType getEI_INPUT()
  {
    return EI_INPUT;
  }

  public static TransactionFPType getEO_OUTPUT()
  {
    return EO_OUTPUT;
  }

  public static TransactionFPType getEQ_QUERY()
  {
    return EQ_QUERY;
  }
}
