  @Explore
Feature: verifying OMRBranch search hotel Automation

  Scenario Outline: Verifying search hotel with all field
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15  | 2023-05-22   | 2-Two    | 2-Two     |         1 |

  Scenario Outline: Verifying search hotel with only mandatory fields
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<checkInDate>","<checkOutDate>","<noOfRoom>" and "<noOfAdult>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName             | password  | stateName  | cityName | checkInDate | checkOutDate | noOfRoom | noOfAdult |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | 2023-05-15  | 2023-05-22   | 2-Two    | 2-Two     |

  Scenario Outline: Verifying search hotel without entering any feild
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotel without entering any feild
    Then User should verify after search hotel error message "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms", and "Please select no. of adults"

    Examples: 
      | userName             | password  |
      | akashka888@gmail.com | Akash@123 |

  Scenario Outline: Verifying search hotel filter room type
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should verify same selected "<roomType>" filter is present

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15  | 2023-05-22   | 2-Two    | 2-Two     |         1 |
