$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/Resources/Features/Registration.feature");
formatter.feature({
  "line": 3,
  "name": "register",
  "description": "",
  "id": "register",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@register"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "user should able to login successfully",
  "description": "",
  "id": "register;user-should-able-to-login-successfully",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "user is on homepage",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});