Feature: Help Swedish ABC

As a user
I want help about the app
so that I can get to know the features

  Scenario: Help about the app
    Given I opened the help view in the Swedish ABC app
    Then I should see:
        | swipe |
        | left |
        | next |
        | right |
        | previous |
        | letter |
        | settings |
        | audio |
        | animation |
        | shuffle |
