@ChangeBooking
Feature: Verifying OMRBranch Change Booking Automation

  Scenario Outline: Change booking using generated order id
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select first hotel and save the hotel name and price
    And User accept the alert message
    Then User should verify after accepting the alert success message "Book Hotel"
    When User add all guest details "<Salutation>","<firstName>","<lastName>","<mobileNumber>" and "<email>"
    And User add gst details "<getRegNumber>","<getRegName>" and "<getRegAddress>"
    And User giving  special request "<message>"
    And user proceed payment "<cardType>"
      | SelecrtCard      | CardNumber       | NameOnCard | SelectMonth | SelectYear | Cvv |
      | Debit Visa       | 5555555555552222 | Akash      | April       |       2025 | 233 |
      | Debit Amex       | 5555555555552222 | Ram        | May         |       2025 | 233 |
      | Debit Mastercard | 5555555555552222 | Raj        | June        |       2025 | 233 |
      | Debit Discover   | 5555555555552222 | Mani       | July        |       2025 | 244 |
    Then User should verify success message after booking with card details "Booking is Confirmed" and saves the order id
    And User should verify same selected hotel is booked
    When User navigates to my booking page
    Then User should verify after navigating success message "Bookings"
    When User enter the generated order id
    Then User should verify same order id is displayed
    And User should verify same hotel name is displayed
    And User should verify same prize is displayed
    When User edit the paticular booking details "<dateChange>"
    Then user should verify after edit success message "Booking updated successfully"

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild | Salutation | firstName | lastName | mobileNumber | email                | getRegNumber | getRegName             | getRegAddress | message   | cardType   | dateChange |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15  | 2023-05-22   | 2-Two    | 2-Two     |         1 | Mr.        | Akash     | k a      |   8489608783 | akashka888@gmail.com |   9043592058 | Greens Tech OMR Branch | Thoraipakkam  | Camp Fire | Debit Card | 2023-05-25 |

  Scenario Outline: Change booking for existing order id
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User navigates to my booking page after login
    Then User should verify after navigating success message "Bookings"
    When User enter the existing order id "<exeOrderId>"
    Then User should verify same existing order id is displayed "<exeOrderId>"
    When User edit the paticular booking details "<dateChange>"
    Then user should verify after edit success message "Booking updated successfully"

    Examples: 
      | userName             | password  | exeOrderId | dateChange |
      | akashka888@gmail.com | Akash@123 | RKXVT92130 | 2023-05-25 |

  Scenario Outline: Change booking for first available order id
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User navigates to my booking page after login
    Then User should verify after navigating success message "Bookings"
    When User edit the first available booking "<dateChange>"
    Then user should verify after edit success message "Booking updated successfully"

    Examples: 
      | userName             | password  | dateChange |
      | akashka888@gmail.com | Akash@123 | 2023-05-25 |
