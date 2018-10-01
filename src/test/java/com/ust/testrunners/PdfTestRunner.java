package com.ust.testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features= {"features/PdfAutomation.feature"},
				glue= {"com.ust.pdfglue"},
				tags= {"@test"})

public class PdfTestRunner {

}
