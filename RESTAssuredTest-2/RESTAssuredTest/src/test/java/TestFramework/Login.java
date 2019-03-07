package TestFramework;

import org.testng.annotations.Test;
import commonFiles.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;




public class Login {


@Test //Test Case to Unauthorized user

public void loginfake() {
RestAssured.proxy("bcpxy.nycnet",8080);
RestAssured.baseURI = Resources.baseUrl();
Response res = given().
header( "Content-Type", "application/json" )
.body("{" +
    "\"email\" :\"bn@2041.uk\"," +
    "\"password\" : \"idietoosoon\"" +
    "}").when()
.post(Resources.postlogin())
.then().log().all().statusCode(401).and().contentType( ContentType.JSON )
.extract().response();
String responseString = res.asString();
System.out.println( responseString );







}

    };





