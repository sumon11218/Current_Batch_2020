package Cucumber_Framework.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/Cucumber_Framework/Features"},
        glue={"Cucumber.StepDefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}
        //plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"}

)//end of your feature path
public class executableClass_Test {
}

