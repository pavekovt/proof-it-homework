package calculators;

import java.math.BigDecimal;

public interface PremiumModifier {
  /**
   * Modifier for calculator
   * @param currentPrice current price to modify
   * @return new price
   */
  BigDecimal apply(BigDecimal currentPrice);
}
