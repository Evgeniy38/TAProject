Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check search for a unique product in the search field
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks current product visibility

    Examples:
      | homePage             | keyword            |
      | https://www.asos.com | Converse Space Jam |

  Scenario Outline: Check products category search in the search field
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks current products '<keyword>' category visibility
    Examples:
      | homePage             | keyword |
      | https://www.asos.com | skirt   |

  Scenario Outline: Check add product to bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User checks ADD TO BAG button visibility
    And User clicks size select field
    And User clicks current size
    And User clicks ADD TO BAG button on product
    And User checks that add to bag popup is visible
    And User moves My Bag button
    And User clicks VIEW BAG button
    Then User checks that bag page header is '<bagHeader>'

    Examples:
      | homePage             | keyword | bagHeader                         |
      | https://www.asos.com | skirt   | Items are reserved for 60 minutes |

  Scenario Outline: Check incorrect keyword on search page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<wrongKeyword>'
    And User clicks search button
    And User checks that current url contains keyword '<wrongKeyword>'
    Then User checks lack of products with '<searchHeader>'

    Examples:
      | homePage             | wrongKeyword | searchHeader                |
      | https://www.asos.com | jtrdjgfzhk   | NOTHING MATCHES YOUR SEARCH |

  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks wish list on first product
    And User clicks wish list on second product
    And User clicks wish list on fourth product
    Then User checks that amount of products in wish list are '<amountOfProducts>'

    Examples:
      | homePage              | searchWord | amountOfProducts |
      | https://www.asos.com/ | Skirt      | 3                |

  Scenario Outline: Check delete product from savedList
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks wish list on first product
    And User clicks wish list on second product
    And User clicks wish list on fourth product
    When User clicks on heart button
    And User checks that amount of products in saved list are '<amount>'
    And User clicks delete button on first product
    Then User checks that products decrease by one '<finishAmount>'

    Examples:
      | homePage              | searchWord | amount | finishAmount |
      | https://www.asos.com/ | Shirt      | 3      | 2            |

  Scenario Outline: Check the impossibility of adding to the bag without selecting a size
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    And User clicks on first product
    And User checks ADD TO BAG button visibility
    And User clicks ADD TO BAG button on product
    Then User checks the '<message>'

    Examples:
      | homePage              | searchWord | message                                                  |
      | https://www.asos.com/ | Dress      | Please select from the available colour and size options |


  Scenario Outline: Check delete product from bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks on first product
    And User clicks size select field
    And User clicks current size
    And User clicks ADD TO BAG button on product
    And User checks that add to bag popup is visible
    And User moves My Bag button
    And User clicks VIEW BAG button
    And User checks remove button visibility
    And User clicks remove button
    Then User checks that the bag is empty '<text>' visibility

    Examples:
      | homePage             | keyword  | text              |
      | https://www.asos.com | converse | Your bag is empty |

  Scenario Outline: Check that url contains search word
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    Then User checks that current url contains '<currentUrl>'

    Examples:
      | homePage              | searchWord | currentUrl |
      | https://www.asos.com/ | converse   | converse   |

  Scenario Outline: Check empty bag
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User clicks My Bag button
    Then User checks that the bag is empty '<text>' visibility

    Examples:
      | homePage             | text              |
      | https://www.asos.com | Your bag is empty |