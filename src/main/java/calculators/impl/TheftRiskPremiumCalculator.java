package calculators.impl;

import calculators.PremiumModifier;
import calculators.RiskPremiumCalculatorBase;
import calculators.modifiers.TheftPremiumCoefficientModifier;
import domain.RiskType;

import java.util.Collections;
import java.util.List;

public class TheftRiskPremiumCalculator extends RiskPremiumCalculatorBase {

  @Override
  protected List<PremiumModifier> getModifiers() {
    return Collections.singletonList(new TheftPremiumCoefficientModifier());
  }

  @Override
  public Boolean isAcceptedType(RiskType type) {
    return type == RiskType.THEFT;
  }
}
