package calculators;

import domain.PolicySubObject;

import java.math.BigDecimal;
import java.util.List;

public abstract class RiskPremiumCalculatorBase implements RiskPremiumCalculator {

  /**
   * Modifiers that will be used to to modify final price
   * @return All the modifiers that will be applied to price
   */
  protected abstract List<PremiumModifier> getModifiers();

  @Override
  public BigDecimal calculatePremium(List<PolicySubObject> subObjects) {
    BigDecimal current = subObjects
      .stream()
      .filter(obj -> isAcceptedType(obj.getRiskType()))
      .map(PolicySubObject::getSumInsured)
      .reduce(BigDecimal.ZERO, BigDecimal::add);

    for (PremiumModifier modifier : getModifiers()) {
      current = modifier.apply(current);
    }

    return current;
  }
}
