package tests;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
monochrome = true,
features = "src//test//java//features",
plugin = {"pretty", "html:target/cucumber-html-report"},
glue = "stepdefinitions"
//tags = "@testdiary"
)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {

}
