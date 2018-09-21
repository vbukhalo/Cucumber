package com.ust.testrunners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features={"features/UltimateQALanding.feature"},
				glue={"com.ust.gluecode"}
//				tags= {"@test"}
				)

public class TestRunner {
}