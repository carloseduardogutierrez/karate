Feature: Test with a Get Method on The Star Wars API

  Background:
    * url 'https://swapi.dev/api'
    * header Content-Type = 'application/json; charset=utf-8'

  Scenario: first hello world

    * def expectedOutput = read('response/getResponse.json')

    Given path '/people/1'
    And param foo1 = 'bar1'
    And param foo2 = 'bar2'
    When method GET
    Then status 200
    And match $ == expectedOutput
    #And match response == expectedOutput <- You can use this way too