package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Project\\B2B_Assignment_API\\src\\test\\java\\Features\\User.feature"
                 ,plugin = "json:target/jsonReports/cucumber-report.json"
                 ,glue = {"stepDefinations"}                 
                 ,dryRun = false
                 ,strict = true
                 ,monochrome=true)
                 //,tags= {"@CreateUser"})
public class TestRunner {

}
