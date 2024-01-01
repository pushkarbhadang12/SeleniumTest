@Portfolio
Feature: Rediff Money Portfolio Operations

  Background: Check login with valid credentials
    Given User opens Rediff Money portal
    And User enter Email Id and Password
    When User clicks on Submit button
    Then User verify if login is successful
   
    
  @CreatePortfolio
  Scenario Outline: Create Portfolio
    Given User logged in to Rediff Money Portal
    And User clicks on Create button
    And User enters Portfolio Name<PortfolioName>
    When User clicks on Create Portfolio button
    Then User verify if Portfolio is created successfully<PortfolioName>
    And User clicks on LogOut link
    
    Examples: 
      | PortfolioName |  
      | "Portfolio2"  |     
     
  
  @RenamePortfolio
  Scenario Outline: Rename Portfolio
    Given User logged in to Rediff Money Portal
    And User selects portfolio from Portfolio list<PortfolioName>
    And User clicks on Rename button
    When User enters new Portfolio Name<NewPortfolioName>
    And User clicks on Rename Portfolio button 
    Then User verify if Portfolio is renamed successfully from<PortfolioName>to<NewPortfolioName>
    And User clicks on LogOut link
    
    Examples: 
      | PortfolioName | NewPortfolioName|
      | "Portfolio2"  | "MyPortfolio2"  |       
     
  @exclude   
  @DeletePortfolio
  Scenario Outline: Delete Portfolio
    Given User logged in to Rediff Money Portal
    And User selects portfolio from Portfolio list<PortfolioName>
    And User clicks on Delete Portfolio button
    When User clicks on Ok button
    Then User verify if Portfolio is deleted successfully<PortfolioName>
    And User clicks on LogOut link
    
    Examples: 
      | PortfolioName |
      | "MyPortfolio1"| 
    
            