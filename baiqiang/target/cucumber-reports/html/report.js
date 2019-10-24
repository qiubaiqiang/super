$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:feature2/test2.feature");
formatter.feature({
  "name": "TestCucumber2",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "test result whether is correct",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "open browser2",
  "keyword": "Given "
});
formatter.step({
  "name": "input data \"\u003cheight\u003e\" \"\u003cweight\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "assert  result \"\u003cresult\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "height",
        "weight",
        "result"
      ]
    },
    {
      "cells": [
        "180",
        "60",
        "18.5"
      ]
    },
    {
      "cells": [
        "180",
        "70",
        "21.6"
      ]
    },
    {
      "cells": [
        "170",
        "65",
        "22.5"
      ]
    },
    {
      "cells": [
        "160",
        "50",
        "19.5"
      ]
    }
  ]
});
formatter.scenario({
  "name": "test result whether is correct",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "open browser2",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.TestCucumber2.open_browser() in file:/C:/Users/baiqiang.qiu/IdeaProjects/baiqiang/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "input data \"180\" \"60\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.TestCucumber2.input_data(String,String) in file:/C:/Users/baiqiang.qiu/IdeaProjects/baiqiang/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "assert  result \"18.5\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.TestCucumber2.assert_result(String) in file:/C:/Users/baiqiang.qiu/IdeaProjects/baiqiang/target/test-classes/"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "test result whether is correct",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "open browser2",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.TestCucumber2.open_browser() in file:/C:/Users/baiqiang.qiu/IdeaProjects/baiqiang/target/test-classes/"
});
