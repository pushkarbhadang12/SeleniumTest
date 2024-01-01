@Stock
Feature: Rediff Money Stock Operations

  Background: Check login with valid credentials
    Given User opens Rediff Money portal
    And User enter Email Id and Password
    When User clicks on Submit button
    Then User verify if login is successful
  
  
  @AddStock
  Scenario Outline: Add Stock
    Given User logged in to Rediff Money Portal
    And User scrolls down till Stock section
    And User clicks on Add Stock button
    And User enters Stock Name<StockName>
    And User enters Stock Date<StockDate>
    And User enters Stock Quantity<StockQuantity>
    And User enters Stock Price<StockPrice>
    And User selects Exchange<Exchange>
    When User clicks on Submit Add Stock button
    Then User verify adding stock is successful<StockName>
    
    
  Examples: 
      | StockName      |  StockDate     |  StockQuantity  |    StockPrice   |    Exchange    |
      | "Coforge Ltd"  |  "12-05-2023"  |       "100"      |     "5200"      |     "BSE"      |  
      
  @exclude 
  @DeleteStock
  Scenario Outline: Delete Stock
    Given User logged in to Rediff Money Portal
    And User scrolls down till Stock section
    And User verifies if stock to be deleted is present in stock list<StockName>
    When User clicks on stock to be deleted and click on Delete button<StockName>
    Then User verify if stock is deleted successfully<StockName>
    
    
  Examples: 
      | StockName                 | 
      | "Coforge Ltd" |      