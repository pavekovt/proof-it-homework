package calculators;

import domain.PolicySubObject;
import domain.RiskType;

import java.math.BigDecimal;
import java.util.List;

public interface RiskPremiumCalculator {
  /**
   * Defines whether this risk type is supported by calculator.
   * Requires to ignore unsupported type
   * @param type Type of policy sub-object
   * @return Whether type is supported or not
   */
  Boolean isAcceptedType(RiskType type);

  /**
   * Calculates premium price for supported risk type
   * @param subObjects All policy sub objects
   * @return Premium price
   */
  BigDecimal calculatePremium(List<PolicySubObject> subObjects);
}
