$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/Temperature.feature");
formatter.feature({
  "line": 1,
  "name": "Temperature",
  "description": "As a user\r\nI want to use a sensor\r\nSo that I can know the temperature of the room",
  "id": "temperature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Check temperature",
  "description": "",
  "id": "temperature;check-temperature",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I have a sensor",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "the value is above 40",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "the system should give me a signal",
  "keyword": "Then "
});
formatter.match({
  "location": "RunCalculatorSteps.i_have_a_sensor()"
});
formatter.result({
  "duration": 116779397,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "40",
      "offset": 19
    }
  ],
  "location": "RunCalculatorSteps.the_value_is_above(int)"
});
formatter.result({
  "duration": 3363081,
  "status": "passed"
});
formatter.match({
  "location": "RunCalculatorSteps.the_system_should_give_me_a_signal()"
});
formatter.result({
  "duration": 362224,
  "status": "passed"
});
});