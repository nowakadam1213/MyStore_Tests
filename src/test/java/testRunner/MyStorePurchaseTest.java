package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "cucumber/features/my-store-purchase.feature", glue = "stepDefinitions", plugin = {"pretty","html:out.html"})

public class MyStorePurchaseTest {
}
