@Login
Feature: Verifying OMRBranchLogin Automatuion

  Scenario Outline: Verify login with valid credential
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify success message after login "Welcome Akash"

    Examples: 
      | userName             | password  |
      | akashka888@gmail.com | Akash@123 |

  Scenario Outline: Verify login using Enter key
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>" using Enter key
    Then User should verify success message after login "Welcome Akash"

    Examples: 
      | userName             | password  |
      | akashka888@gmail.com | Akash@123 |

  Scenario Outline: Verify login with invalid credential
    Given User is on OMRBranch hotel page
    When User enter "<userName>" and "<password>"
    Then User should verify error message after login "Invalid Login details or Your Password might have expired. Click here to reset your password"

    Examples: 
      | userName             | password |
      | akashka888@gmail.com | akash    |
