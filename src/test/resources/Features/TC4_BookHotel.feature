  @BookHotel

Feature: Verifying OMRBranch Book Hotel Automation
  Scenario Outline: Verifying book hotel with special request and gst using debit and credit card
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
      | SelecrtCard       | CardNumber       | NameOnCard | SelectMonth | SelectYear | Cvv |
      | Debit Visa        | 5555555555552222 | Akash      | April       |       2025 | 233 |
      | Debit Amex        | 5555555555552222 | Ram        | May         |       2025 | 233 |
      | Debit Mastercard  | 5555555555552222 | Raj        | June        |       2025 | 233 |
      | Debit Discover    | 5555555555552222 | Mani       | July        |       2025 | 244 |
      | Credit Visa       | 5555555555552223 | Akash      | April       |       2025 | 233 |
      | Credit Amex       | 5555555555552223 | Ram        | May         |       2025 | 233 |
      | Credit Mastercard | 5555555555552223 | Raj        | June        |       2025 | 233 |
      | Credit Discover   | 5555555555552223 | Mani       | July        |       2025 | 244 |
    Then User should verify success message after booking with card details "Booking is Confirmed" and saves the order id
    And User should verify same selected hotel is booked

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild | Salutation | firstName | lastName | mobileNumber | email                | getRegNumber | getRegName             | getRegAddress | message   | cardType    |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 | Mr.        | Akash     | k a      |   8489608783 | akashka888@gmail.com |   9043592058 | Greens Tech OMR Branch | Thoraipakkam  | Camp Fire | Debit Card  |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 | Mr.        | Akash     | k a      |   8489608783 | akashka888@gmail.com |   9043592058 | Greens Tech OMR Branch | Thoraipakkam  | Camp Fire | Credit Card |

  Scenario Outline: Verifying book hotel without special request using debit and credit card
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
    And User add without special request with gst
    And user proceed payment "<cardType>"
      | SelecrtCard       | CardNumber       | NameOnCard | SelectMonth | SelectYear | Cvv |
      | Debit Visa        | 5555555555552222 | Akash      | April       |       2025 | 233 |
      | Debit Amex        | 5555555555552222 | Ram        | May         |       2025 | 233 |
      | Debit Mastercard  | 5555555555552222 | Raj        | June        |       2025 | 233 |
      | Debit Discover    | 5555555555552222 | Mani       | July        |       2025 | 244 |
      | Credit Visa       | 5555555555552223 | Akash      | April       |       2025 | 233 |
      | Credit Amex       | 5555555555552223 | Ram        | May         |       2025 | 233 |
      | Credit Mastercard | 5555555555552223 | Raj        | June        |       2025 | 233 |
      | Credit Discover   | 5555555555552223 | Mani       | July        |       2025 | 244 |
    Then User should verify success message after booking with card details "Booking is Confirmed" and saves the order id
    And User should verify same selected hotel is booked

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild | Salutation | firstName | lastName | mobileNumber | email                | getRegNumber | getRegName             | getRegAddress | cardType    |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 | Mr.        | Akash     | k a      |   8489608783 | akashka888@gmail.com |   9043592058 | Greens Tech OMR Branch | Thoraipakkam  | Debit Card  |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 | Mr.        | Akash     | k a      |   8489608783 | akashka888@gmail.com |   9043592058 | Greens Tech OMR Branch | Thoraipakkam  | Credit Card |
  Scenario Outline: Verifying book hotel without gst and with special request using debit card
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select first hotel and save the hotel name and price
    And User accept the alert message
    Then User should verify after accepting the alert success message "Book Hotel"
    When User add all guest details "<Salutation>","<firstName>","<lastName>","<mobileNumber>" and "<email>"
    And User giving  special request without gst "<message>"
    And user proceed payment "<cardType>"
      | SelecrtCard       | CardNumber       | NameOnCard | SelectMonth | SelectYear | Cvv |
      | Debit Visa        | 5555555555552222 | Akash      | April       |       2025 | 233 |
      | Debit Amex        | 5555555555552222 | Ram        | May         |       2025 | 233 |
      | Debit Mastercard  | 5555555555552222 | Raj        | June        |       2025 | 233 |
      | Debit Discover    | 5555555555552222 | Mani       | July        |       2025 | 244 |
      | Credit Visa       | 5555555555552223 | Akash      | April       |       2025 | 233 |
      | Credit Amex       | 5555555555552223 | Ram        | May         |       2025 | 233 |
      | Credit Mastercard | 5555555555552223 | Raj        | June        |       2025 | 233 |
      | Credit Discover   | 5555555555552223 | Mani       | July        |       2025 | 244 |
    Then User should verify success message after booking with card details "Booking is Confirmed" and saves the order id
    And User should verify same selected hotel is booked

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild | Salutation | firstName | lastName | mobileNumber | email                | message   | cardType   |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 | Mr.        | Akash     | k a      |   8489608783 | akashka888@gmail.com | Camp Fire | Debit Card |
  Scenario Outline: Verifying book hotel without gst and without special request using credit card
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select first hotel and save the hotel name and price
    And User accept the alert message
    Then User should verify after accepting the alert success message "Book Hotel"
    When User add all guest details "<Salutation>","<firstName>","<lastName>","<mobileNumber>" and "<email>"
    And user give without special request
    And user proceed payment "<cardType>"
      | SelecrtCard       | CardNumber       | NameOnCard | SelectMonth | SelectYear | Cvv |
      | Debit Visa        | 5555555555552222 | Akash      | April       |       2025 | 233 |
      | Debit Amex        | 5555555555552222 | Ram        | May         |       2025 | 233 |
      | Debit Mastercard  | 5555555555552222 | Raj        | June        |       2025 | 233 |
      | Debit Discover    | 5555555555552222 | Mani       | July        |       2025 | 244 |
      | Credit Visa       | 5555555555552223 | Akash      | April       |       2025 | 233 |
      | Credit Amex       | 5555555555552223 | Ram        | May         |       2025 | 233 |
      | Credit Mastercard | 5555555555552223 | Raj        | June        |       2025 | 233 |
      | Credit Discover   | 5555555555552223 | Mani       | July        |       2025 | 244 |
    Then User should verify success message after booking with card details "Booking is Confirmed" and saves the order id
    And User should verify same selected hotel is booked

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild | Salutation | firstName | lastName | mobileNumber | email                | getRegNumber | getRegName             | getRegAddress | cardType   |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 | Mr.        | Akash     | k a      |   8489608783 | akashka888@gmail.com |   9043592058 | Greens Tech OMR Branch | Thoraipakkam  | Debit Card |
  Scenario Outline: Verifying Book hotel without entering any field
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"
    When User search hotels "<stateName>","<cityName>","<roomType>","<checkInDate>","<checkOutDate>","<noOfRoom>","<noOfAdult>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User select first hotel and save the hotel name and price
    And User accept the alert message
    Then User should verify after accepting the alert success message "Book Hotel"
    When User book hotel without entering any feilds
    Then User should verify error message after booking "Let us know for whom you are booking the hotel","Please select Salutation of the user","Please provide First Name of the user","Please provide Last Name of the user","Please provide Contact Number of the user to ease the communication (if required)" and "Please provide Email ID of the user to ease the communication (if required)"

    Examples: 
      | userName             | password  | stateName  | cityName | roomType | checkInDate | checkOutDate | noOfRoom | noOfAdult | noOfChild |
      | akashka888@gmail.com | Akash@123 | Tamil Nadu | Chennai  | Studio   | 2023-05-15 | 2023-05-22   | 2-Two    | 2-Two     |         1 |
