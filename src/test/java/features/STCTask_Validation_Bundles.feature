#    please construct an automated test framework to execute the steps below
#    Steps:-
#    1-navigate to the following url https://subscribe.stctv.com/
#    2-validate the subscription package - type and price and currency for all
#    (Egypt - UAE - Palestine)
#    this can be done preferably in java language and BDD framework

Feature: Validate Subscription Packages
  As a user
  I want to validate the subscription packages for different countries
  So that I can make an informed decision

  @smoke @regression @hs
    # Happy Scenario()

   Scenario: 01 - Validate Subscription Packages for Egypt
    Given I navigate to STC TV website
    When I select "Egypt" as the country
    Then I can assert on all details like bundleType and price and currency for "Egypt"
    And close the website

  Scenario: 02 - Validate Subscription Packages for Egypt
    Given I navigate to STC TV website
    When I select "UAE" as the country
    Then I can assert on all details like bundleType and price and currency for "UAE"
    And close the website

  Scenario: 03 - Validate Subscription Packages for Egypt
    Given I navigate to STC TV website
    When I select "Palestine" as the country
    Then I can assert on all details like bundleType and price and currency for "Palestine"
    And close the website
