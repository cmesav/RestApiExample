#Author: mesa.cristian@gmail.com

Feature: As an Qa analist I want to test the rest services

  Background: Connect to the service
    Given Im conected to the service

  @Get
  Scenario: Get Employees
    When I use the get with path "/employees"
    Then I see the status code 200
    And the message "Successfully! All records has been fetched."
    And the correct schema for the method "Get" response

  @Post
  Scenario: Create an employee
    When I send the request wit path "/create"
    Then I see the status code 200
    And the message "Successfully! Record has been added."
    And the correct schema for the method "Post" response

  @GetOne
  Scenario: Get one particular employee
    When I use the path "/employee/{id}" to consult employee id 1
    Then I see the status code 200
    And the correct employee info
      | id | employee_name | employee_salary | employee_age |profile_image|
      | 1  | Tiger Nixon   | 320800          | 61           |             |
    And the message "Successfully! Record has been fetched."
    And the correct schema for the method "GetEmployee" response

    @Delete
    Scenario: Delete an employee
      When I send the petition with path "/delete/{id}" an id 1
      Then I see the status code 200
      And the message "Successfully! Record has been deleted"



