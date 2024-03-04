Feature: LogOut Page

  Scenario: LogOut Successfully
    Given user is already logged into admin panel
    When user clicks on Logout button under top right dropdown of Profile
    Then Login page would be shown