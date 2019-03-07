package TestFramework;

import org.testng.annotations.Test;
import commonFiles.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class ListUnits {


@Test// List all available Units
        public void listUnits() {
	RestAssured.proxy("bcpxy.nycnet",8080);
    RestAssured.baseURI = Resources.baseUrl();
    Response res = given()
       .headers( "Authorization",
               "Bearer " + ReusableMethods.login(),
               "Content-Type",
               ContentType.JSON,
               "Accept",
               ContentType.JSON)
                .when()
                .get(Resources.getUnit())
                .then().log().all().statusCode(200).and().contentType(ContentType.JSON)
.extract().response();
    String responseString = res.asString();
    System.out.println( responseString );


}

@Test// List all available Units
public void listUnitsNoAuth() {
RestAssured.proxy("bcpxy.nycnet",8080);
RestAssured.baseURI = Resources.baseUrl();
Response res = given()
.header( "Content-Type", "application/json" )
        .when()
        .get(Resources.getUnit())
        .then().log().all().statusCode(401).and().contentType(ContentType.JSON)
.extract().response();
String responseString = res.asString();
System.out.println( responseString );


}


    }





