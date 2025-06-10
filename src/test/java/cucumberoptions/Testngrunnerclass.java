package cucumberoptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/featurefiles",glue="stepDefinitions",monochrome=true, 
plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_scenarios.txt"})

public class Testngrunnerclass  extends AbstractTestNGCucumberTests{

}
