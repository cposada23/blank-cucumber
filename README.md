# CUCUMBER FRAMEWORK | AUTOMATION CHALLEGE
#### _challenge to test web automation skills_

Here are the instructions to run the tests

## Installation

Required dependencies
- Java17
- Maven 3.9.2 or Just use maven wrapper from IntelliJ

## Running the tests:
#### From the test Runner

```sh
# Locate the testRunner in the src/test/java/blank/RunCucumberTest.java folder
# Rigth click and run (This depends on the IDE you are using)
```
#### From command line
```
# In the proyect folder, open a coomand line and run:
mvn clean test
```
#### You can run the test in Chrome and firefox, changing the browser in the properties file
- Properties file folder: src/test/resources/config/test.properties
```sh
# In the .properties file you can see this options
browser=chrome
headless=false
# Change them accordingly to the needs
```
