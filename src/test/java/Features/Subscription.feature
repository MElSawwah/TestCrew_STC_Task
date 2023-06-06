Feature: Validate subscription packages on STC TV website

Scenario: Verify subscription packages for different countries
  Given I am on the STC TV subscriptions page and click on the country drop down
  When I select the country "<country>"
  Then I should see the subscription packages with correct "<type>", "<price>" and "<currency>"
  
  Examples: 
      |country  |type    |price   |currency |
      |Saudi    |Classic |25      |SAR      |
      |Kuwait   |Classic |2.5     |OMR      |
      |Bahrain  |Classic |3       |JOD      |

  