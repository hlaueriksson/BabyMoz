Feature: Help Cantonese 123

As a user
I want help about the app
so that I can get to know the features

  Scenario: Help about the app
    Given I opened the help view in the Cantonese 123 app
    Then I should see:
        | swipe |
        | left |
        | next |
        | right |
        | previous |
        | number |
        | settings |
        | audio |
        | animation |
        | shuffle |
