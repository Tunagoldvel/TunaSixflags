package com.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/reports/cucumberReports"},
        features = {"src/test/java/com/features"},
        glue = {"com.StepDefinition"},
        snippets = CAMELCASE,
        dryRun = false,
        monochrome = true
        //tags={","}

)

public class SixFlagsMobileRunnerTest {


}
