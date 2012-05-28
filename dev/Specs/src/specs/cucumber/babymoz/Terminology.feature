Feature: Terminology

A Symbol is a representation of a letter, number or character
An Image is a reference to an image resource
A Welcome is an Image dedicated for a splash Screen
A Screen is a container for a Symbol or Image
A Set is a list of Screens
A Library is a repository that keeps track of Screens

  Scenario: Symbol
    Given that I have a letter
    Then a Symbol can be used to represent the letter

  Scenario: Image
    Given that I have an image resource
    Then an Image can be used to refer to the image resource

  Scenario: Welcome
    Given that I have an image resource dedicated for a splash screen
    Then a Welcome can be used to refer to the image resource

  Scenario: Screen
    Given that I have a Symbol and an Image
    Then a Screen can be used to contain both the Symbol and the Image

  Scenario: Set
    Given that I have two Screens
    Then a Set can be used to list the Screens

  Scenario: Library
    Given that I have a Set with Screens
    Then a Library can be used to keep track of the Screens
