@api

Feature: Api Tests

  Background:
    Given User given api url "https://automationexercise.com"


  Scenario: API 1: Get All Products List
    Given  Set api endpoint "/api/productsList"
    And I request GET all products list
    Then response code should be 200


  Scenario: API 2: POST To All Products List
    Given  Set api endpoint "/api/productsList"
    And I request POST
    Then response code should be 405
    Then response message should be "This request method is not supported."

  Scenario: API 3: Get All Brands List
    Given  Set api endpoint "/api/brandsList"
    And I request GET all brand list
    Then response code should be 200

  Scenario: API 4: PUT To All Brands List
    Given  Set api endpoint "/api/brandsList"
    And I request PUT
    Then response code should be 405
    Then response message should be "This request method is not supported."

  Scenario: API 5: POST To Search Product
    Given  Set api endpoint "/api/searchProduct"
    And I request POST with parameter "tshirt"
    Then response code should be 200
    Then validate searched products list


  Scenario: API 6: POST To Search Product without search_product parameter
    Given  Set api endpoint "/api/searchProduct"
    And I request POST without search_product parameter
    Then response code should be 400
    Then response message should be "Bad request, search_product parameter is missing in POST request."

  Scenario Outline: API 7: POST To Verify Login with valid details
    Given  Set api endpoint "/api/verifyLogin"
    And I request POST with valid "<email>" and "<password>"
    Then response code should be 200
    Then response message should be "User exists!"

      Examples:
      | email          | password |
      | osman@mail.com | 123      |

  Scenario: API 8: POST To Verify Login without email parameter
    Given  Set api endpoint "/api/verifyLogin"
    And I request POST only paramether password "123"
    Then response code should be 400
    Then response message should be "Bad request, search_product parameter is missing in POST request."

  Scenario: API 9: DELETE To Verify Login
    Given  Set api endpoint "/api/verifyLogin"
    And I request DELETE
    Then response code should be 405
    Then response message should be "This request method is not supported."


  Scenario Outline: API 10: POST To Verify Login with invalid details(email and password)
    Given  Set api endpoint "/api/verifyLogin"
    When I request POST with invalid "<email>" and "<password>"
    Then response code should be 404
    Then response message should be "User not found!."
    Examples:
      | email        | password |
      | qwe@mail.com | 123      |


