Feature: Login Page

  Scenario: Login Successfully
    Given user opens a new page in the browser
    And navigate to "https://opensource-demo.orangehrmlive.com/"
    When user fills in the account details
    And click on Login button
    Then dashboard screen should be displayed in the admin panel
