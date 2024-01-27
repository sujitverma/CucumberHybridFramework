package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			                        "html:target/cucumber-reports",
						"timeline:target/test-output/output-thread/",
						"rerun:target/failedrun.txt"}, 
				monochrome = true,
				glue = {"stepdefinitions", "parallel"},
				features = { "src/test/resources/parallel/" }
)

public class ParallelRun extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
