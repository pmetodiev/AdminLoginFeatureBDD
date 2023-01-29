Feature: Admin Login Scenarios - POSITIVE
  As an admin user I want to successfully be able to
  login and logout from the admin panel


  Scenario: Successful admin login
    Given the user is on the admin login page
    When the user logs in using username "admin" and password "parola123!"
    And the user clicks on the login button
    Then the user should successfully log in into the admin panel
    And the user logs out via the logout button


  Scenario Outline: Successful admin login using different credentials
    Given the user is on the admin login page
    When the user logs in using username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should successfully log in into the admin panel
    And the user logs out via the logout button
    Examples:
      | username | password   |
      | admin    | parola123! |
      | joro     | blabla     |