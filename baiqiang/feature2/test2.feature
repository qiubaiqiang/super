Feature: TestCucumber2

  Scenario Outline: test result whether is correct
    Given open browser2
    When input data "<height>" "<weight>"
    Then assert  result "<result>"

    Examples:
      | height | weight | result |
      | 180    | 60     | 18.5   |
      | 180    | 70     | 21.6   |
      | 170    | 65     | 22.5   |
      | 160    | 50     | 19.5   |













