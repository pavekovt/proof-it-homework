# Premium Calculator

## Prerequisites
* Java 11+
* Gradle

## Comments

### Dependency Injection
DI is not used in completing of this task as it looks like a simple library for me.
It makes more sense to inject this library where it will be used, e.g. in Spring application you'd wrap it to Bean.

### Adding new calculators

Adding new calculators for new risk type requires:
1. Add type to [RiskType](src/main/java/domain/RiskType.java) enum
1. Implement new [RiskCalculator](src/main/java/calculators/RiskPremiumCalculatorBase.java):
    1.  Extend base class and implement 2 required methods
1. Add the calculator to [factory](src/main/java/factories/RiskCalculatorFactoryImpl.java)

### Thing to improve
1. Risk calculator modifiers are not flexible to support complex cases, might be good idea to add change structure the 
way that will allow modifiers to have access to whole policy.
