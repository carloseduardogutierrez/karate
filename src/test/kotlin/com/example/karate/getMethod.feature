Feature: Test with a Get Method

  Background:
    * url 'https://postman-echo.com'
    * header Content-Type = 'application/json; charset=utf-8'

  Scenario: Get Method with params

    * def foo = { bar: 1, baz: 'hello', ban: 'world' }

    Given path '/get'
    And param foo1 = 'bar1'
    And param foo2 = 'bar2'
    When method GET
    Then status 200
    Then match foo !contains { bar: 2 }
    Then match foo !contains { huh: '#notnull' }
