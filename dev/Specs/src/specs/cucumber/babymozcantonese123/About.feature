Feature: About Cantonese 123

As a user
I want info about the app
so that I can contact and know more about the publisher

  Scenario: About the app
    Given I opened the about view in the Cantonese 123 app
    Then I should see:
        | children |
        | learn |
        | count |
        | ten |
        | cantonese |
        | Henrik Lau Eriksson |
        | http://hoffenkloffen.com |
        | hoffenkloffen@gmail.com |
