
@Tag
Feature:  As a user to book ticket
 

  @DashBoard
  Scenario: select the location and date to book bus 
    Given I want to be in "https://www.redbus.in/" page  
    When Have to select the location and date to book bus
    Then click on to search button
    

  