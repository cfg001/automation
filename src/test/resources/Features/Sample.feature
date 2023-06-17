Feature: Sample

  Scenario: Simple text
    Given user is opens ARDWEB
    Then verify user is on "LoginPage" Page
    And user enters "V100019" in Username_textbox
    And user clicks LP_Next_Button
    And user enters excrypted "lIRySHRkPGyCfgOSkip5MA==" in Password_textbox
    And user clicks LP_Next2_Button
    And user clicks LP_PopupOK_Button
    Then verify user is on "HomePage" Page
    And user selects "ICNHA01GS" Officeid
    And user clicks PNRBookingFlow_link
    Then verify user is on "SearchFlightPage" Page
    And user selects "Availability" from Searchtype_dropdown
    And user clicks Origin_1
    And user enters "HNL" in Origin_1
    And user clicks Destination_1
    And user enters "LIH" in Destination_1
    And user clicks Date_1
    And user enters "240124" in Date_1
    And user clicks Serach_Button
    And user selects "Y" class from the flight in row "1"
    And user clicks Book_Button
    And verify Segment_1 is displayed
    And user clicks AddorUpdate_link
    Then verify user is on "PassengerDetailsPage" Page
    And user enters "Test" in Lastname_1
    And user enters "James" in Firstname_1
    And user enters "ADT" in PTC_1
    And user enters "ritesh.nagamalla-v@hawaiianair.com" in Email
    And user enters "Rocktown raod 1" in Address1
    And user enters "New Jersey" in City
    And user enters "NJ" in State
    And user enters "08445" in Zipcode
    And user enters "US" in Country
    And user clicks ApplyandClose_Button
    Then verify user is on "SearchFlightPage" Page
    And verify Pax1_Details is displayed
    And user clicks Price_Button
    Then verify user is on "PricingPage" Page
    And user clicks AllPrices_Tab
    And user clicks UpdateFares_Button
    And user clicks ConfirmPrice_Button
    Then verify user is on "AddPNRElementPage" Page
    And user clicks SSR_API
    Then verify user is on "APIPage" Page
    And user selects "Male" from Gender_Dropdown
    And user enters "220593" in DateofBirth
    And user jclicks BookServicesButton
    And verify DOCS is displayed
    And user take a screenshot
    And user clicks NextStep_Button
    Then verify user is on "FormOfPaymentPage" Page
    And user perform payment type using Discover_CreditCard
    And user enters "Test" in CallerDetailsid_textbox
    And user clicks IssueDocuments_Button
    And verify SuccessfullMessage is displayed
    And user take a screenshot
    And user clicks GotoPNRDetails_Button
    Then verify user is on "PNRPage" Page
    And user clicks Eticket_link
    Then verify user is on "EticketPage" Page
    And user gettext of EticketNumber and save the value
    And user gettext of PNRNumber and save the value
    And user take a screenshot   