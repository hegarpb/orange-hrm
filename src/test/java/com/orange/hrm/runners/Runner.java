package com.orange.hrm.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
                "src/test/resources/features/pim/AddEmployee.feature"

}, glue = {
                "com.orange.hrm",
                "com.orange.hrm.definitions"
}, plugin = {

                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-report/cucumber.json"
})

public class Runner extends AbstractTestNGCucumberTests {

}
