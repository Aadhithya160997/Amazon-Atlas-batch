package com.example.enrollment;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestConfig.class)  // Specify your Spring configuration class here
public class CucumberSpringConfiguration {
    // This class will be used to configure the Spring context for Cucumber
}
