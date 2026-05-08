package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Login.feature", glue = { "stepsdefinition",
		"hooks" }, plugin = { "pretty", "html:target/cucumber-reports.html" }, dryRun = true, publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}
