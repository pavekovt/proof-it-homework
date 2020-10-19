package calculators.modifiers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class FirePremiumCoefficientModifierTest {

  @Test
  void preThresholdValueIsUsed() {
    //given
    var modifier = new FirePremiumCoefficientModifier();
    var value = BigDecimal.valueOf(20);

    //when
    var result = modifier.apply(value);

    //then
    assertThat(result, is(BigDecimal.valueOf(0.28).setScale(3, RoundingMode.HALF_DOWN)));
  }

  @Test
  void postThresholdValueIsUsed() {
    //given
    var modifier = new FirePremiumCoefficientModifier();
    var value = BigDecimal.valueOf(160);

    //when
    var result = modifier.apply(value);

    //then
    assertThat(result, is(BigDecimal.valueOf(3.84).setScale(3, RoundingMode.HALF_DOWN)));
  }
}