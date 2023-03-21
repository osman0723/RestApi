package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import pageObjects.ApiTest_PO;

public class ApiTests_Steps extends ApiTest_PO {
    @Given("User given api url {string}")
    public void user_given_api_url(String url) {

        RestAssured.baseURI = url;
    }
    @Given("Set api endpoint {string}")
    public void set_api_endpoint(String endpoint) {

        RestAssured.basePath = endpoint;
    }
    @When("I request POST with invalid {string} and {string}")
    public void i_login_with_request_body_with_and(String email, String password) {
        response = postMethod(email,password);
        response.prettyPrint();
    }


    @And("I request GET all products list")
    public void iRequestGETAllProductsList() {
       response = getMethod();
       response.prettyPrint();
    }



    @Then("response code should be {int}")
    public void responseCodeShouldBe(int expectedCode) {
      int statusCode = response.getStatusCode();
      Assert.assertEquals(statusCode,expectedCode);

    }

    @And("I request POST")
    public void iRequestPOST() {
        response = postMethod();
    }

    @Then("response message should be {string}")
    public void responseMessageShouldBe(String message) {
       response.prettyPrint();
       if(response.toString().contains(message)){
           System.out.println("Message is verified");
       }
       else {
           RuntimeException re = new RuntimeException();
           System.out.println("Message is not verified");
           throw re;
       }
    }

    @And("I request GET all brand list")
    public void iRequestGETAllBrandList() {
        response = getMethod();
        response.prettyPrint();
    }

    @And("I request PUT")
    public void iRequestPUT() {
        response = putMethod();
    }


    @And("I request POST with parameter {string}")
    public void iRequestPOSTWithParameter(String parameter) {

        response = postMethod(parameter);
    }

    @Then("validate searched products list")
    public void validateSearchedProductsList() {
        response.prettyPrint();
    }



    @And("I request POST with valid {string} and {string}")
    public void iRequestPOSTWithValidAnd(String email, String password) {
            response = postMethod(email,password);
    }

    @And("I request POST without search_product parameter")
    public void iRequestPOSTWithoutSearch_productParameter() {
        response = postMethod();
    }

    @And("I request POST only paramether password {string}")
    public void iRequestPOSTOnlyParametherPassword(String password) {
        response = postMethodOnlyPassword(password);
    }

    @And("I request DELETE")
    public void iRequestDELETE() {
        response = deleteMethod();
    }

}
