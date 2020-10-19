package domain;

import java.util.List;

public class PolicyObject {
  private final String objectName;
  private final List<PolicySubObject> subObjects;

  public static PolicyObjectBuilder builder() {
    return new PolicyObjectBuilder();
  }

  public PolicyObject(String objectName, List<PolicySubObject> subObjects) {
    this.objectName = objectName;
    this.subObjects = subObjects;
  }

  public String getObjectName() {
    return objectName;
  }

  public List<PolicySubObject> getSubObjects() {
    return subObjects;
  }

  public static class PolicyObjectBuilder {
    private List<PolicySubObject> subObjects;
    private String objectName;

    public PolicyObjectBuilder setObjectName(String objectName) {
      this.objectName = objectName;
      return this;
    }

    public PolicyObjectBuilder setSubObjects(List<PolicySubObject> subObjects) {
      this.subObjects = subObjects;
      return this;
    }

    public PolicyObject build() {
      return new PolicyObject(
        objectName,
        subObjects.isEmpty() ? null : subObjects
      );
    }
  }
}
