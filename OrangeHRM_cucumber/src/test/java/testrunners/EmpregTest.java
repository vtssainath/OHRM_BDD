package testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="featurefiles/Empolyee.feature",glue="stepdefinitions",
dryRun=false,plugin= {"com.cucumber.listener.ExtentCucumberFormatter:reports/Empregresult.html"},
tags="@tag1")
public class EmpregTest
{

}
