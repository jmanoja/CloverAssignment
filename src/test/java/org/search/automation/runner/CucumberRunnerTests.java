package org.search.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@Clover", features = "src/test/resources/features/", glue = "org.search.automation.stepDefinitions",
    plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
