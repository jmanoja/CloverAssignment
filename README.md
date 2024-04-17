# CloverAssessment

This test framework can we used for frontend automation of web applications.

Prerequisites:
1. Java 11
2. Maven 3.6+
3. Intellij or Eclipse as IDE

Tech stack for the framework:
1. Java
2. Selenium
3. Cucumber
4. TestNG
5. Allure reports

How to setup this project:
1. Setup Java 11 and maven 3.6+
2. run `mvn clean install` to build the maven project and download dependencies
3. Add tags on your Scenario that you want to run
4. Open terminal and use following command to run the tests:
`mvn clean test`
5. Note: Give your tags in "src/test/java/org/search/automation/runner/CucumberRunnerTests.java" file to run a particular scenario.