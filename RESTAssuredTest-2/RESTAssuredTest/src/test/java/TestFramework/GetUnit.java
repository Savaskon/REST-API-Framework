package TestFramework;

import org.testng.annotations.Test;

import commonFiles.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class GetUnit {


@Test //Successful Get the UnitID - 200

        public void getUnit() {
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
                .then().statusCode(200).and().contentType(ContentType.JSON)
.extract().response();
    JsonPath js= ReusableMethods.rawToJson(res);
    String responseString = res.asString();
    String id=js.get("data[0].id");

    
given().headers( "Authorization",
        "Bearer " + ReusableMethods.login(),
        "Content-Type",
        ContentType.JSON,
        "Accept",
        ContentType.JSON).when()
        .log().all().get(Resources.getUnit() + id)
        .then().log().all().statusCode(200).and().contentType(ContentType.JSON)
        .extract().response();
System.out.println( responseString );


}


@Test //Unit ID not found 404

public void getfakeUnit() {
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
JsonPath js= ReusableMethods.rawToJson(res);
String responseString = res.asString();
String id=js.get("data[100].id");


given().headers( "Authorization",
"Bearer " + ReusableMethods.login(),
"Content-Type",
ContentType.JSON,
"Accept",
ContentType.JSON).when()
.log().all().get(Resources.getUnit() + id)
.then().log().all().assertThat().statusCode(404).and().contentType(ContentType.JSON)
.extract().response();
System.out.println( responseString );


}

@Test //UnAuthorized Access-401

public void getNoUnit() {
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
        .then().statusCode(200).and().contentType(ContentType.JSON)
.extract().response();
JsonPath js= ReusableMethods.rawToJson(res);
String responseString = res.asString();
String id=js.get("data[0].id");

given().when()
.get(Resources.getUnit() + id)
.then().log().all().statusCode(401).and().contentType(ContentType.JSON)
.extract().response();
System.out.println( responseString );


}

}








