Feature: Validating place API


@addplace @Reg
  Scenario Outline: Verify if place id being successfully added using addPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with "post" http request
    Then API call call is success with status code 200
    And "status"  in response body is "OK"
    And "scope"  in response body is "APP"
    And verify place_Id created maps to "<name>" using "getplaceAPI"

    Examples: 
      | name     | language | address            |
      | Cristene | English  | Wrold cross centre |
     # | BBhouse  | Spansish | C roseLane         |

@deletePlace @Reg  
     Scenario: Verify if delete place functionality is working
     Given Deleteplace payload 
      When user calls "deleteplaceAPI" with "post" http request
      Then API call call is success with status code 200
      And "status"  in response body is "OK"