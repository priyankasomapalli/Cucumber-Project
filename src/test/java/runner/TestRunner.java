package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Login.feature", glue = { "stepsdefinition"}, plugin = { "pretty" ,"html:target/cucumber-reports.html"}, dryRun = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}
