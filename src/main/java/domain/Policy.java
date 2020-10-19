package domain;

import java.util.List;

public class Policy {
  private final String policyNumber;
  private final PolicyStatus policyStatus;
  private final List<PolicyObject> policyObjects;

  public static PolicyBuilder builder() {
    return new PolicyBuilder();
  }

  public Policy(String policyNumber, PolicyStatus policyStatus, List<PolicyObject> policyObjects) {
    this.policyNumber = policyNumber;
    this.policyStatus = policyStatus;
    this.policyObjects = policyObjects;
  }

  public String getPolicyNumber() {
    return policyNumber;
  }

  public PolicyStatus getPolicyStatus() {
    return policyStatus;
  }

  public List<PolicyObject> getPolicyObjects() {
    return policyObjects;
  }

  public static class PolicyBuilder {
    private List<PolicyObject> policyObjects;
    private String policyNumber;
    private PolicyStatus policyStatus;

    public PolicyBuilder setPolicyNumber(String policyNumber) {
      this.policyNumber = policyNumber;
      return this;
    }

    public PolicyBuilder setPolicyStatus(PolicyStatus policyStatus) {
      this.policyStatus = policyStatus;
      return this;
    }

    public PolicyBuilder setPolicyObjects(List<PolicyObject> policyObjects) {
      this.policyObjects = policyObjects;
      return this;
    }

    public Policy build() {
      return new Policy(
        policyNumber,
        policyStatus,
        policyObjects.isEmpty() ? null : policyObjects
      );
    }
  }
}
