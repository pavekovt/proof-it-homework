import domain.*;
import factories.RiskCalculatorFactoryImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PremiumCalculatorImplTest {

  @Test
  public void calculatorRoundResultTo2Digits() {
    //given
    var policy = Policy.builder()
      .setPolicyNumber("policyNumber")
      .setPolicyStatus(PolicyStatus.APPROVED)
      .setPolicyObjects(
        Collections.singletonList(
          PolicyObject
            .builder()
            .setObjectName("object")
            .setSubObjects(
              Collections.singletonList(
                PolicySubObject.builder()
                  .setSubObjectName("sub2")
                  .setRiskType(RiskType.THEFT)
                  .setSumInsured(BigDecimal.valueOf(8.11))
                  .build()
              )
            ).build()
        )
      ).build();

    PremiumCalculatorImpl calculator = new PremiumCalculatorImpl(new RiskCalculatorFactoryImpl());

    //when
    var result = calculator.calculate(policy);

    //then
    // without rounding result would be 0.8921
    assertThat(result, is(BigDecimal.valueOf(0.89)));
  }

  @Test
  public void integration1() {
    //given
    var policy = Policy.builder()
      .setPolicyNumber("policyNumber")
      .setPolicyStatus(PolicyStatus.APPROVED)
      .setPolicyObjects(
        Collections.singletonList(
          PolicyObject
            .builder()
            .setObjectName("object")
            .setSubObjects(
              Arrays.asList(
                PolicySubObject.builder()
                  .setSubObjectName("sub1")
                  .setRiskType(RiskType.FIRE)
                  .setSumInsured(BigDecimal.valueOf(100))
                  .build(),
                PolicySubObject.builder()
                  .setSubObjectName("sub2")
                  .setRiskType(RiskType.THEFT)
                  .setSumInsured(BigDecimal.valueOf(8))
                  .build()
              )
            ).build()
        )
      ).build();

    PremiumCalculatorImpl calculator = new PremiumCalculatorImpl(new RiskCalculatorFactoryImpl());

    //when
    BigDecimal result = calculator.calculate(policy);

    //then
    assertThat(result, is(BigDecimal.valueOf(2.28)));
  }

  @Test
  public void integration2() {
    //given
    var policy = Policy.builder()
      .setPolicyNumber("policyNumber")
      .setPolicyStatus(PolicyStatus.APPROVED)
      .setPolicyObjects(
        Collections.singletonList(
          PolicyObject.builder()
            .setObjectName("object")
            .setSubObjects(
              Arrays.asList(
                PolicySubObject.builder()
                  .setSubObjectName("sub1")
                  .setRiskType(RiskType.FIRE)
                  .setSumInsured(BigDecimal.valueOf(500))
                  .build(),
                PolicySubObject.builder()
                  .setSubObjectName("sub2")
                  .setRiskType(RiskType.THEFT)
                  .setSumInsured(BigDecimal.valueOf(102.51))
                  .build()
              )
            ).build()
        )
      ).build();

    PremiumCalculatorImpl calculator = new PremiumCalculatorImpl(new RiskCalculatorFactoryImpl());

    //when
    BigDecimal result = calculator.calculate(policy);

    //then
    assertThat(result, is(BigDecimal.valueOf(17.13)));
  }
}