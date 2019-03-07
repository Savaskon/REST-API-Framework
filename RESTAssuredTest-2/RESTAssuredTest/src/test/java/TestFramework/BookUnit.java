package TestFramework;

import org.testng.annotations.Test;

import commonFiles.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class BookUnit {


@Test //Book Unit Successful -200// 

public void bookUnit() {
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

String id=js.get("data[1].id");


given()
.headers( "Authorization",
	       "Bearer " + ReusableMethods.login(),
	       "Content-Type",
	       ContentType.JSON,
	       "Accept",
	       ContentType.JSON).when().body( "{\"unitId\": \""+id+"\",\"year\": 2081 }")
 .post(Resources.bookUnit())
                .then().log().all().statusCode(200).and().contentType(ContentType.JSON)
.extract().response();
    System.out.println( responseString );


}


@Test //Unauthenticated Access - 401//

public void bookNotUnit() {
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


given()
	       .when().body( "{\"unitId\": \""+id+"\",\"year\": 2081 }")
 .post(Resources.bookUnit())
                .then().log().all().statusCode(401).and().contentType(ContentType.JSON)
.extract().response();

    System.out.println( responseString );


    }



@Test //Unit doesn't Exist - 404//

public void noUnit() {
RestAssured.proxy("bcpxy.nycnet",8080);
RestAssured.baseURI =Resources.baseUrl();
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

String id=js.get("data[100].id");


given()
.headers( "Authorization",
	       "Bearer " + ReusableMethods.login(),
	       "Content-Type",
	       ContentType.JSON,
	       "Accept",
	       ContentType.JSON)
	       .when().body( "{\"unitId\": \""+id+"\",\"year\": 2081 }")
.post(Resources.bookUnit())
              .then().log().all().statusCode(404).and().contentType(ContentType.JSON)
.extract().response();

  System.out.println( responseString );


  }


}



