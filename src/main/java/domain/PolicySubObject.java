package domain;

import java.math.BigDecimal;

public class PolicySubObject {
  private final String subObjectName;
  private final RiskType riskType;
  private final BigDecimal sumInsured;

  public static PolicySubObjectBuilder builder() {
    return new PolicySubObjectBuilder();
  }

  public PolicySubObject(String subObjectName, RiskType riskType, BigDecimal sumInsured) {
    this.subObjectName = subObjectName;
    this.riskType = riskType;
    this.sumInsured = sumInsured;
  }

  public String getSubObjectName() {
    return subObjectName;
  }

  public RiskType getRiskType() {
    return riskType;
  }

  public BigDecimal getSumInsured() {
    return sumInsured;
  }

  public static class PolicySubObjectBuilder {
    private String subObjectName;
    private RiskType riskType;
    private BigDecimal sumInsured;

    public PolicySubObjectBuilder setSubObjectName(String subObjectName) {
      this.subObjectName = subObjectName;
      return this;
    }

    public PolicySubObjectBuilder setRiskType(RiskType riskType) {
      this.riskType = riskType;
      return this;
    }

    public PolicySubObjectBuilder setSumInsured(BigDecimal sumInsured) {
      this.sumInsured = sumInsured;
      return this;
    }

    public PolicySubObject build() {
      return new PolicySubObject(subObjectName, riskType, sumInsured);
    }
  }
}

