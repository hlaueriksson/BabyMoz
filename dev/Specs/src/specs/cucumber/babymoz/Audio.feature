Feature: Audio

As a user
I want to hear a sound clip for all screens
So that I can learn how to speak and pronounce the character/word

As a user
I want to be able to turn of the sound
so that I don't get annoyed

Audio is enabled by default

  Scenario: Audio initiation
    Given that a screen is initiated
    Then a audio reference is associated with the screen

  Scenario: Audio is enabled
    Given that audio is enabled
    When a new symbol is displayed
    Then the associated sound should be played

  Scenario: Audio is disabled
    Given that audio is disabled
    When a new symbol is displayed
    Then no sound should be played

  Scenario: Audio default
    Given the default preferences
    Then audio should be enabled
