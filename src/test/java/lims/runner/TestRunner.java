package lims.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lims.step.JvmReport;

@RunWith(Cucumber.class)
@CucumberOptions(features= "C:\\Users\\xvd71\\eclipse-workspace\\SkeletonRequst\\src\\test\\resources\\Skeleton.feature",glue= "lims.step",
dryRun=false,monochrome=true,plugin= {"json:C:\\Users\\xvd71\\eclipse-workspace\\SkeletonRequst\\Reports\\JsonReport\\SkRequest.json"})

public class TestRunner {
	@AfterClass
	public static void report() {
    JvmReport.generateJvmReport("C:\\Users\\xvd71\\eclipse-workspace\\SkeletonRequst\\Reports\\JsonReport\\SkRequest.json");

	}

}
