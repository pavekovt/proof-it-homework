package factories;

import domain.RiskType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class RiskCalculatorFactoryImplTest {

  private static List<Arguments> riskFactoryParameters() {
    return Arrays.stream(RiskType
      .values())
      .map(Arguments::of)
      .collect(Collectors.toList());
  }

  @ParameterizedTest(name = "Factory returns correct calculator for type {arguments}")
  @MethodSource(value = "riskFactoryParameters")
  void factoryReturnsApplicableCalculator(RiskType riskType) {
    //given
    var factory = new RiskCalculatorFactoryImpl();

    //when
    var calculator = factory.getRiskCalculator(riskType);

    //then
    assertThat(calculator.isAcceptedType(riskType), is(true));
  }
}