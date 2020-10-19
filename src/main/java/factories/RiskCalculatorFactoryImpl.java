package factories;

import calculators.RiskPremiumCalculator;
import calculators.impl.FireRiskPremiumCalculator;
import calculators.impl.TheftRiskPremiumCalculator;
import domain.RiskCalculatorIsNotDefined;
import domain.RiskType;

import java.util.Map;
import java.util.function.Supplier;

public class RiskCalculatorFactoryImpl implements RiskCalculatorFactory {

  private final Map<RiskType, Supplier<RiskPremiumCalculator>> calculators = Map.ofEntries(
    Map.entry(RiskType.THEFT, () -> new TheftRiskPremiumCalculator()),
    Map.entry(RiskType.FIRE, () -> new FireRiskPremiumCalculator())
  );

  @Override
  public RiskPremiumCalculator getRiskCalculator(RiskType type) {
    if (!calculators.containsKey(type)) {
      throw new RiskCalculatorIsNotDefined(type);
    }

    return calculators.get(type).get();
  }
}
