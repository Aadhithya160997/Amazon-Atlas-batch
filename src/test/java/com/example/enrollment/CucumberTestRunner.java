package com.example.enrollment;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",  // Path to the feature files
        glue = "com.example.enrollment.stepdefinitions",  // Path to the step definitions
        plugin = {"pretty"}  // Optional: To get a formatted output in the console
)
public class CucumberTestRunner {
}

