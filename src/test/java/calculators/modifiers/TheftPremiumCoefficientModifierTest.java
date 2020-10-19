package calculators.modifiers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class TheftPremiumCoefficientModifierTest {


  @Test
  void preThresholdValueIsUsed() {
    //given
    var modifier = new TheftPremiumCoefficientModifier();
    var value = BigDecimal.valueOf(2);

    //when
    var result = modifier.apply(value);

    //then
    assertThat(result, is(BigDecimal.valueOf(0.22)));
  }

  @Test
  void postThresholdValueIsUsed() {
    //given
    var modifier = new TheftPremiumCoefficientModifier();
    var value = BigDecimal.valueOf(160);

    //when
    var result = modifier.apply(value);

    //then
    assertThat(result, is(BigDecimal.valueOf(8).setScale(2, RoundingMode.HALF_DOWN)));
  }
}