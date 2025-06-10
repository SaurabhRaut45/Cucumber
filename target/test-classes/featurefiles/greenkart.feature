Feature: Application Login

@PlaceOrder
Scenario: Admin Login

Given User is on greenkart landing page

When User searched with shortname "Tom" and extarcted actual name of the product

Then User searched with same shortname "Tom" in offerspage to see if the product exists

