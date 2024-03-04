Feature: MyInfo Page

  Scenario: Date Updated Successfully
    Given user is already logged into admin panel
    And  click on MyInfo page
    And verify already filled Date of Birth
    When user updates the date to another date successfully
    Then page should be updated with changes date

