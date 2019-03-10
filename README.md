# bg-sdet-assignment - BlueGround goes to Mars
 A JAVA REST Assured Framework built to automate the REST APIs of the Mars Challenge. 
 The structure of the Framework is :
- TestFramework Package: Includes all the Testcases and Reusable Methods
- CommonFiles: Includes resuable files
- The Project is built on Maven. To run the project use the pom.xml file --> run maven test. 
     - Testframework: TestNG
- Html repots are generated under the target folder/surefire reports
- The project can easily integrated with Jenkins. Place the project folder under jenkins directory, create a new project and configure
directory path and maven path. 
***Please note: To run the test you need to comment out the Pxoxy settings. ////RestAssured.proxy("bcpxy.nycnet",8080);
