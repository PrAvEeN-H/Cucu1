  @SelectHotel 
Feature: Verifying OMRBranch Select Hotel Automation
  Scenario Outline: Verifying select hotel navigates to book hotel
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select first hotel and save the hotel name and price
    And user accept the alert message
    Then User should verify after accepting the alert success message "Book Hotel"
    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 |
  Scenario Outline: Verifying select hotel navigates to same page upon dismissing alert
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select first hotel and save the hotel name and price
    And user dismiss the alert message
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 |
  Scenario Outline: Verifying price low to high functionality under sort by
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select Price low to high button in sort by option
    Then User should verify all hotels prices are from low to high

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 |

  Scenario Outline: Verifying price high to low fuctionality under sort by
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select Price high to low button in sort by option
    Then User should verify all hotels prices are from high to low

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 |

  Scenario Outline: Verifying roomtype filter is displaying
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    And User should verify all hotles name ends with given "<roomType>" filter

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 |
