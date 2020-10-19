package calculators.impl;

import calculators.PremiumModifier;
import calculators.RiskPremiumCalculatorBase;
import calculators.modifiers.FirePremiumCoefficientModifier;
import domain.RiskType;

import java.util.Collections;
import java.util.List;

public class FireRiskPremiumCalculator extends RiskPremiumCalculatorBase {

  @Override
  protected List<PremiumModifier> getModifiers() {
    return Collections.singletonList(new FirePremiumCoefficientModifier());
  }

  @Override
  public Boolean isAcceptedType(RiskType type) {
    return type == RiskType.FIRE;
  }
}
