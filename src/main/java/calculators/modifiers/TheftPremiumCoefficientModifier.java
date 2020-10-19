package calculators.modifiers;

import calculators.PremiumModifier;

import java.math.BigDecimal;

public class TheftPremiumCoefficientModifier implements PremiumModifier {

  private static final BigDecimal THRESHOLD = BigDecimal.valueOf(100);
  private static final BigDecimal DEFAULT_COEFFICIENT = BigDecimal.valueOf(0.11);
  private static final BigDecimal AFTER_THRESHOLD_COEFFICIENT = BigDecimal.valueOf(0.05);

  @Override
  public BigDecimal apply(BigDecimal currentPrice) {
    return currentPrice.compareTo(THRESHOLD) >= 0
      ? currentPrice.multiply(AFTER_THRESHOLD_COEFFICIENT)
      : currentPrice.multiply(DEFAULT_COEFFICIENT);
  }
}
