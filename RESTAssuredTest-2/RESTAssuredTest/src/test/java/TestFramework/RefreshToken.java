package TestFramework;


import org.testng.annotations.Test;

import commonFiles.Payload;
import commonFiles.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



public class RefreshToken {


@Test//Test Case to get the refresh token

public void refreshToken() {
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
            .body(Payload.getrefreshToken())
            .post(Resources.refreshAuth())
            .then().log().all().statusCode(200).and().contentType(ContentType.JSON)
            .extract().response();
    String responseString = res.asString();
    System.out.println(responseString);



}

    };





