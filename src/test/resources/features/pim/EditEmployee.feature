Feature: Edit data Employe
        Sebagai user saya ingin mengedit data employee

  Scenario Outline: Edit Employe
    Given user sudah login dan berada di halaman PIM
    When user memilih data employee "<name>"
    And user menekan tombol edit
    Then muncul data employee yang akan di edit

    Examples:
      | name     |
      | Isabelle |
