package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/apiFeature"},
        plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = "steps"
)
public class RunCucumberTestAPI extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
