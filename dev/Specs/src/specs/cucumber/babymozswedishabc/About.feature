Feature: About Swedish ABC

As a user
I want info about the app
so that I can contact and know more about the publisher

  Scenario: About the app
    Given I opened the about view in the Swedish ABC app
    Then I should see:
        | children |
        | learn |
        | alphabet |
        | A |
        | Ö |
        | swedish |
        | Henrik Lau Eriksson |
        | http://hoffenkloffen.com |
        | hoffenkloffen@gmail.com |
