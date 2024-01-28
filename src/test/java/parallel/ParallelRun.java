package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
			                        "html:target/cucumber-reports/index.html",
			                        "json:target/cucumber-reports/Cucumber.json",
			                        "junit:target/cucumber-reports/Cucumber.xml",
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
