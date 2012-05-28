Feature: Shuffle

As a user
I want to be able to turn on shuffle
so that learning is improved

The welcome screen should always be first

Shuffle is disabled by default

  Scenario: Shuffle is disabled
    Given that shuffle is disabled
    Then the screens should be displayed in ascending order

  Scenario: Shuffle is enabled
    Given that shuffle is enabled
    Then the screens should be displayed in random order
    But the welcome screen should be first

  Scenario: Shuffle default
    Given the default preferences
    Then shuffle should be disabled
