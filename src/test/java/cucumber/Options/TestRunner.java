package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",plugin="json:target/jsonReports/cucumber-reports.json",glue={"StepDefinitions"})

public class TestRunner {
//,tags= "@DeleteAPI"
}
