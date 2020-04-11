@ArtistsSaveFeature
Feature: Basic Arithmetic

  Scenario: Save artist
    Given the following artist:
      | id | name |
      | 1  | Mika |
    When calling save method
    Then we get artist with names:
      | Mika |

