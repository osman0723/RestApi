package pageObjects;



import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class ApiTest_PO {
    public Response response;

    public Response postMethod(String email, String password) {
       String requestBody = setBody(email,password);
       response = given().body(requestBody).request().header("Content-Type","application/json","Accept", ContentType.JSON).post();
       return response;
    }

    public String setBody(String email, String password) {
        String body = "";
        try {
            body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")
                    + "/src/test/resources/data/userDetails.json")));
            body = body.replaceAll("replaceEmail",email);
            body = body.replaceAll("replacePassword",password);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }
    public Response getMethod() {
        response = given().request().header("Content-Type","application/json","Accept",ContentType.JSON)
                .get();
        return response;
    }
    public Response postMethod(){
        response = given().body("").request().header("Content-Type","application/json","Accept", ContentType.JSON)
                .post();
        return response;
    }
    public Response putMethod() {
        response = given().body("").request().header("Content-Type","application/json","Accept", ContentType.JSON)
                .put();
        return response;
    }
    public Response postMethod(String search){
        String requestBody = setBodyProduct(search);
        response = given().body(requestBody).request().header("Content-Type","application/json","Accept", ContentType.JSON)
                .post();

        return response;
    }
    public Response postMethodOnlyPassword(String password){
        String requestBody = setBody(password);
        response = given().body(requestBody).request().header("Content-Type","application/json","Accept", ContentType.JSON)
                .post();

        return response;
    }
    public String setBody(String password) {
        String body = "{ \"password\":" + password + "}" ;
      return body;
    }
    public String setBodyProduct(String product) {
        String body = "{ \"name\": \"" + product + "\" }" ;
        return body;
    }

    public Response deleteMethod() {
        response =   response = given().request().header("Content-Type","application/json","Accept",ContentType.JSON)
                .delete();
        return response;
    }


}
