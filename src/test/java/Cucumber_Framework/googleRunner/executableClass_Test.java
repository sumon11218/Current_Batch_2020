package Cucumber_Framework.googleRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Cucumber_Framework/Features/google.feature"},
        glue={"Cucumber_Framework.StepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
)//end of your feature path
public class executableClass_Test {
}

