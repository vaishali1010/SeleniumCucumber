package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/LogOutPage.feature"},
        glue = {"stepDefinitions","Hooks"},
        tags = "",
        plugin = {"pretty", "html:target/cucumber-reports/report.html"}
)

public class LogOutPageRunner extends AbstractTestNGCucumberTests {
}
