package domain;

public class RiskCalculatorIsNotDefined extends RuntimeException {
  public RiskCalculatorIsNotDefined(RiskType type) {
    super("Premium calculator for type " + type + " does not exist");
  }
}
