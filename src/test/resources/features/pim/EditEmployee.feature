Feature: Edit data Employe
        Sebagai user saya ingin mengedit data employee

  Scenario Outline: Edit Employe
    Given user sudah login dan berada di halaman PIM
    When user memilih data employee "<name>"
    And user menekan tombol edit
    And user mengisi field first name "<firstName>"
    And user mengisi field middle name "<middleName>"
    And user mengisi field last name "<lastName>"
    And user mengisi field employee id "<employeeId>"
    And user mengisi field other id "<otherId>"
    And user mengisi field license number "<licenseNumber>"
    And user mengisi field license expiry date "<expiryDate>"
    And user mengisi field nationality "<nationality>"
    And user mengisi field marital status "<maritalStatus>"
    And user mengisi field date of birth "<dob>"
    And user memilih gender "<gender>"
    And user menekan tombol save
    Then muncul pesan sukses "<pesan>"

    Examples:
      | name | firstName | middleName | lastName | employeeId | otherId | licenseNumber | expiryDate | nationality | maritalStatus | dob        | gender | pesan                |
      | Jack | Hegar     | P          | B        |     112233 |  332211 |        445566 | 2025-04-09 | American    | Single        | 1997-29-04 | Male   | Successfully Updated |
