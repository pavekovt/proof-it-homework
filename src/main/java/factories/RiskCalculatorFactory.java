package factories;

import calculators.RiskPremiumCalculator;
import domain.RiskType;

public interface RiskCalculatorFactory {

  /**
   * Returns new calculator instance for specified risk type
   * @throws domain.RiskCalculatorIsNotDefined
   * @param type Risk type of calculator
   * @return new calculator instance
   */
  RiskPremiumCalculator getRiskCalculator(RiskType type);
}
