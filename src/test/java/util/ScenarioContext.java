package util;

import io.cucumber.java.Scenario;

public class ScenarioContext {
private static Scenario scenario;
private static String featureFileName;

public static void setScenario(Scenario scenario) {
ScenarioContext.scenario = scenario;
ScenarioContext.featureFileName = scenario.getName();

}

public static String getFeatureFileName() {
return featureFileName;
}
}