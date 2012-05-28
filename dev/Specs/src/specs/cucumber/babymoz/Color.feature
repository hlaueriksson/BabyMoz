Feature: Color

The screens are styled with random background and text color
The background and text color of a screen should be the same every time that screen is displayed
The background and text color should have sufficient contrast

  Scenario: Color initiation
    Given that a screen is initiated
    Then a random background and text color is associated with the screen

  Scenario: Color contrast
    Given that a screen is initiated with the same background and text color
    Then a default background and text color should be associated with the screen

  Scenario: Color display
    Given that the app is started
    When a new symbol is displayed
    Then the background and text color associated with the screen should be applied
