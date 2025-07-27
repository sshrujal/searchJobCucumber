Feature: Job Search and Apply Flow on LabCorp Careers

  Scenario: Search and validate job details, then apply
    Given I open the browser and navigate to "https://www.labcorp.com"
    When I click on the "Careers" link
    And I search for job title "Senior IT Project Manager"
    And I select the job titled "Senior IT Project Manager"
    Then I should see the Job Title as "Senior IT Project Manager"
    And I should see the Job Location as "Durham, North Carolina"
    And I should see the Job ID as "2516034" 

    # Additional 3 Assertions
    And I should see the first sentence of the first paragraph in the Description/Introduction as "Labcorp is hiring a Senior IT Project Manager."
    And I should see the second bullet point under Management Support as "Builds project plans, including necessary deliverable and schedules."
    And I should see the third requirement as "Computer-oriented programs, multi-year projects consisting of multiple large sub-projects."
    And I should see the first suggested education contains "Scrum Master Certification"

    When I click on "Apply Now"
    Then I should see the Job Title match with previous page
   
    When I click to "Return to Job Search"
    Then I should be back on the Job Search Results page