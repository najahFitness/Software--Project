Feature: Add Client and Instructor

  Scenario Outline: Admin adds client or instructor
    Given admin is logged in to the system
    When admin fills in 'name' with '<name>' with  for the client or instructor
    And admin fills in 'role' with '<role>' for the client or instructor
    And admin fills in 'phonenumber' with '<phonenumber>'  for the client or instructor
    And admin clicks on Add to create the new role
    Then admin should see a confirmation message "<message>" for the new  role

    Examples:
      | name        |role      |phonenumber| message              |
      |  Ali |Client    |059988770| Client added successfully     |
      | Nimer |Instructor|059988750| Instructor added successfully |
      | Jamila|Client    |059988774| Client added successfully     |
      |       |Instructor|         | Invalid name or phonenumber   |

