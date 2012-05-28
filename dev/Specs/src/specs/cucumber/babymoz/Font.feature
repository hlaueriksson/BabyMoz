Feature: Font

As a user
I want to be able to change the font family
so that I can make it look nice to me

As a user
I want to be able to change the font size
so that I can improve the readability

  Scenario: Font family
    Given that a font family is set
    Then the symbols should be displayed with the selected font family

  Scenario: Font size
    Given that a font size is set
    Then the symbols should be displayed with the selected font size
