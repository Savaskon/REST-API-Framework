package TestFramework;
import commonFiles.Payload;
import commonFiles.Resources;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ReusableMethods {



    public static JsonPath rawToJson(Response r)
    {
        String respon=r.asString();
        JsonPath x=new JsonPath(respon);
        return x;
    }

    public static String login() {

        RestAssured.baseURI = "http://mars.theblueground.net/";
        Response res = given().
                header( "Content-Type", "application/json" )
                .body(Payload.getPostData() ).when()
                .post(Resources.postlogin())
                .then().assertThat().statusCode( 200 ).and().contentType( ContentType.JSON )
                .extract().response();
        JsonPath js = ReusableMethods.rawToJson( res );
        String responseString = res.asString();
        String accessToken = js.get( "token.accessToken" );
        return accessToken;
    }
       
    public static String refresh() {

        RestAssured.baseURI = "http://mars.theblueground.net/";
        Response res = given().
                header( "Content-Type", "application/json" )
                .body(Payload.getPostData() ).when()
                .post(Resources.postlogin())
                .then().assertThat().statusCode( 200 ).and().contentType( ContentType.JSON )
                .extract().response();
        JsonPath js = ReusableMethods.rawToJson( res );
        String responseString = res.asString();
        String refreshToken = js.get( "token.refreshToken" );
        return refreshToken; 
    
    
    
    
    
    }

}

