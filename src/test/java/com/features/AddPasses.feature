Feature: Add passes using Email Lookup and Media Number

  Scenario Outline: Add Pass using valid Media Number invalid Last name
    Given User click on Passes
    When User clicks on Upload Passes
    And User clicks on Enter Manually
    And User enter the valid PassNumber "<PassNumber>"
    And User enter the invalid Lastname "<Lastname>"
    When User clicks on Confirm your Pass
    But Toast message is Display
    Then verify the Toast message
   # Then Close the app
    Examples:
      | PassNumber           | Lastname |
      | 01040001231230000014 | abc      |


  Scenario Outline: Add Pass using invalid Last Media Number invalid Last name
    Given User click on Passes
    When User clicks on Upload Passes
    And User clicks on Enter Manually
    And User enter the invalid  PassNumber "<PassNumber>"
    And User enter the invalid Lastname "<Lastname>"
    When User clicks on Confirm your Pass
    But Toast message is Display
    Then verify the Toast message
   # Then Close the app
    Examples:
      | PassNumber             | Lastname |
      | 0104000123124000012345 | abcDef   |

  Scenario Outline: Add Pass using valid Last Media Number
    Given User click on Passes
    When User clicks on Upload Passes
    And User clicks on Enter Manually
    And User enter the valid PassNumber "<PassNumber>"
    And User enter the valid Lastname "<Lastname>"
    When User clicks on Confirm your Pass
    Then Toast message is Display
    Then verify the Toast message
    #Then Close the app
    Examples:
      | PassNumber           | Lastname |
      | 01040001231240000001 | Gsell    |

