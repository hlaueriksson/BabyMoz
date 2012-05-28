Feature: Swipe

As a user
I want to be able to swipe
So that I easily can navigate forward and backward between the screens

When the app is started the start screen is displayed
Swiping left navigates forward
Swiping right navigates backward
The screens are displayed in a consecutive loop

  Scenario: Before swipe
    Given that I have started the app
    Then the start screen should be displayed

  Scenario: Swipe left
    Given that I have started the app
    When I swipe left
    Then the first symbol should be displayed

  Scenario: Swipe right
    Given that I have started the app
    When I swipe right
    Then the last symbol should be displayed

  Scenario: Swipe forward from last symbol
    Given that the last symbol is displayed
    When I swipe left
    Then the start screen should be displayed again

  Scenario: Swipe backward from first symbol
    Given that the first symbol is displayed
    When I swipe right
    Then the start screen should be displayed again
