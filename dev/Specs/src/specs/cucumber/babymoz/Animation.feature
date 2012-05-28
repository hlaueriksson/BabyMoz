Feature: Animation

As a user
I want to see an animation on all screens
so that learning gets more fun

As a user
I want to be able to turn of the animations
So that I don't get annoyed

The screens are "brought to life" with a random animation
The animation of a screen should be the same every time that screen is displayed

Animations are enabled by default

  Scenario: Animation initiation
    Given that a screen is initiated
    Then a random animation is associated with the screen

  Scenario: Animation is enabled
    Given that animations are enabled
    When a new symbol is displayed
    Then the associated animation should be started

  Scenario: Animation is disabled
    Given that animations are disabled
    When a new symbol is displayed
    Then no animation should be started

  Scenario: Animation default
    Given the default preferences
    Then animation should be enabled
