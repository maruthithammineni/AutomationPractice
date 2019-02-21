Feature: Test the Login page
  
  The different tests include both valid & invalid conditions

  Scenario: Test Login with valid Email & Password
  	Given Click on Signin
  #	When User enters valid Email & Password
    #And Click on Login
    #Then MyAccount page should be displayed
    #And Welcome message should be displayed
#
    #Scenario Outline: Failed login using wrong credentials
    #When I fill in "Email" with "<email>"
    #And I fill in "Password" with "<password>"
    #And I click on the "Login" button
    #And I should see "<warning>" message
    #Examples:
      #| username    | password   | warning                           |
      #| Test        | !23        | Incorrect credentials. Try again! |
      #| Tset        | 123        | Incorrect credentials. Try again! |
      #| Tset        | !23        | Incorrect credentials. Try again! |
      #| Test        |            | Please enter password.            |
      #|             | 123        | Please enter username.            |
      #|             |            | Please enter your credentials.    |