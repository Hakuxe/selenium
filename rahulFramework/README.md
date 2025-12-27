# Terminal commands

- mvn installed
- surefire reports plugin

## Run tests using the terminal mvn 

Use -D to add parameters to the test

```
// run all tests in the folder test
$ mvn test 

// Run a xml file 
$ mvn clean test -Dsurefire.suiteXmlFiles=/path/to/testng.xml

// Run passing browser as parameter(check: BaseTest line 46)
$ mvn clean test -Dsurefire.suiteXmlFiles=testng.xml -Dbrowser=firefox


```