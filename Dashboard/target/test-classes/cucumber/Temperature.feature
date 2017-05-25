Feature: Temperature
  As a user
  I want to use a sensor
  So that I can know the temperature of the room

  Scenario: Check temperature
    Given I have a sensor
    When the value is above 40
    Then the system should give me a signal

  