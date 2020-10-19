import domain.Policy;
import domain.PolicySubObject;
import domain.RiskType;
import factories.RiskCalculatorFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PremiumCalculatorImpl implements PremiumCalculator {

  private final RiskCalculatorFactory riskCalculatorFactory;

  public PremiumCalculatorImpl(RiskCalculatorFactory factory) {
    this.riskCalculatorFactory = factory;
  }

  @Override
  public BigDecimal calculate(Policy policy) {
    List<PolicySubObject> subObjects = policy.getPolicyObjects()
      .stream()
      .flatMap(it -> it.getSubObjects().stream())
      .collect(Collectors.toList());

    return Arrays.stream(RiskType.values())
      .map(riskCalculatorFactory::getRiskCalculator)
      .map(it -> it.calculatePremium(subObjects))
      .reduce(BigDecimal.ZERO, BigDecimal::add)
      .setScale(2, RoundingMode.HALF_DOWN);
  }
}
