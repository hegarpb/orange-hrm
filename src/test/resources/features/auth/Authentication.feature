Feature: Authentication
    Sebagai user saya ingin melakukan login 
  # Scenario Outline: Login dengan valid credential
  #   Given user berada pada halaman login
  #   When user memasukan username "<username>"
  #   And user memasukan password "<password>"
  #   And user menekan tombol login
  #   Then user diarahkan ke halaman dashboard "<url>"
  #   Examples:
  #     | username | password | url                                                                     |
  #     | Admin    | admin123 | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index |

  Scenario Outline: Login dengan invalid credential
    Given user berada pada halaman login
    When user memasukan username "<username>"
    And user memasukan password "<password>"
    And user menekan tombol login
    Then muncul pesan error "<pesan>"

    Examples:
      | username  | password      | pesan               |
      | WrongUser | WrongPassword | Invalid credentials |
      | WrongUser | admin123      | Invalid credentials |
      | Admin     | WrongPassword | Invalid credentials |

  Scenario Outline: Login dengan invalid credential
    Given user berada pada halaman login
    When user memasukan username "<username>"
    And user memasukan password "<password>"
    And user menekan tombol login
    Then muncul pesan validasi "<pesan>"

    Examples:
      | username | password | pesan    |
      |          | admin123 | Required |
      | Admin    |          | Required |
      |          |          | Required |
