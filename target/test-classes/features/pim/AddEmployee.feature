Feature: Add employee
        Sebagai user saya ingin menambah data employee

  Scenario Outline: Menambah data employee
    Given user sudah melakukan login dan berada di halaman PIM
    When user memilih menu add employee
    And user mengisi first name "<firstName>"
    And user mengisi middle name "<middleName>"
    And user mengisi last name "<lastName>"
    And user mengunggah foto profil
    And user menekan tombol save.
    Then muncul pesan sukses. "<pesan>"

    Examples:
      | firstName | middleName | lastName | pesan              |
      | Kirigaya  | Kirito     | Kazuto   | Successfully Saved |
