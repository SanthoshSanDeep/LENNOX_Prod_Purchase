Feature: Buying product 10T46 from Lennox site

@BuyProduct @regression
Scenario Outline: Web Application - Buying Compressor product 10T46 from lennox online Website
   	Given I want navigate to product URL "<URL>"
   	When I Enter login credentials "<UserName>" and "<Password>"
    And I Click Menu button in top left side
    And I Click Parts and Supplies and click Compressors option
    And I Verify compressor landing page and Click compressors option
    And I Verify and Select 10T46 product from list
    Then I verify product details and compare it with the details from the previous page  
    
Examples:
|URL|UserName|Password|
##data@src/main/java/dataProvider/TestData.xlsx@smoke
|https://www.liidaveqa.com/|lenproautomation8@lenqat.com|Community17|