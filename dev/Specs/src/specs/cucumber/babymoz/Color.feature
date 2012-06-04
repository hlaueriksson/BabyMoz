Feature: Color

The screens are styled with random background and text color
The background and text color of a screen should be the same every time that screen is displayed
The background and text color should have sufficient contrast

  Scenario: Color initiation
    Given that a screen is initiated
    Then a random background and text color is associated with the screen

  Scenario: Color contrast
    Given that a screen is initiated with the same background and text color
    Then the text color associated with the screen should be reset

  Scenario: Color display
    Given that the app is started
    When a new symbol is displayed
    Then the background and text color associated with the screen should be applied

  Scenario: Color values contrast
    Given that the colors values loaded
    When all colors combinations are evaluated
    Then no more than 25 % should have invalid contrast
