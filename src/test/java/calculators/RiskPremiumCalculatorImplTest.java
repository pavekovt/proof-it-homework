package calculators;

import domain.PolicySubObject;
import domain.RiskType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class RiskPremiumCalculatorImplTest {

  private static class RiskFirePremiumTestImplementation extends RiskPremiumCalculatorBase {

    @Override
    protected List<PremiumModifier> getModifiers() {
      return Collections.emptyList();
    }

    @Override
    public Boolean isAcceptedType(RiskType type) {
      return type == RiskType.FIRE;
    }
  }

  @Test
  public void calculatorAcceptsSupportedObjects() {
    //given
    var policySubObject1 = PolicySubObject.builder()
      .setRiskType(RiskType.FIRE)
      .setSubObjectName("test")
      .setSumInsured(BigDecimal.valueOf(100))
      .build();

    var policySubObject2 = PolicySubObject.builder()
      .setRiskType(RiskType.FIRE)
      .setSubObjectName("test")
      .setSumInsured(BigDecimal.valueOf(75))
      .build();

    var calculator = new RiskFirePremiumTestImplementation();

    //when
    var result = calculator.calculatePremium(Arrays.asList(policySubObject1, policySubObject2));

    //then
    assertThat(result, is(BigDecimal.valueOf(175)));
  }

  @Test
  public void calculatorIgnoresUnsupportedObjects() {
    //given
    var policySubObject1 = PolicySubObject.builder()
      .setRiskType(RiskType.THEFT)
      .setSubObjectName("test")
      .setSumInsured(BigDecimal.valueOf(100))
      .build();

    var policySubObject2 = PolicySubObject.builder()
      .setRiskType(RiskType.THEFT)
      .setSubObjectName("test")
      .setSumInsured(BigDecimal.valueOf(100))
      .build();

    var calculator = new RiskFirePremiumTestImplementation();

    //when
    var result = calculator.calculatePremium(Arrays.asList(policySubObject1, policySubObject2));

    //then
    assertThat(result, is(BigDecimal.ZERO));
  }
}