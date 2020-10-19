import domain.Policy;

import java.math.BigDecimal;

public interface PremiumCalculator {
  /**
   * Calculates premium price for the policy
   * @param policy Policy to calculate price
   * @throws domain.RiskCalculatorIsNotDefined if risk type calculator is not defined in factory
   * @return Premium price
   */
  BigDecimal calculate(Policy policy);
}
