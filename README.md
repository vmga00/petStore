# PetStore API Test Automation Framework
##Overview
This is a test automation framework for testing the pet store sample project hotsed at https://petstore3.swagger.io. For other versions, check the branches.

This is a java project to run this framework, please set the API standalone project as described in [Pet Store API](https://github.com/swagger-api/swagger-petstore)

###To run with maven
Clone the project to your IDE and remember to do a 
```
mvn clean install
```
And verify that the dependencies have been downloaded correctly.

###To run the test cases
####To run all tests:
```
testng_standalone_suite.xml
```
####To run individual class tests
Navigate to the *src/test/java/com/petstore/api/tests* and execute the individual test classes

#####To run individual test cases
1. Navigate to the *src/test/java/com/petstore/api/tests*
2. Open a Test Class
3. Execute the desired test







