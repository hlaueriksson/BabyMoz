Feature: Help Swedish 123

As a user
I want help about the app
so that I can get to know the features

  Scenario: Help about the app
    Given I opened the help view in the Swedish 123 app
    Then I should see:
        | swipe |
        | right |
        | next |
        | left |
        | previous |
        | settings |
        | audio |
        | animation |
        | shuffle |
