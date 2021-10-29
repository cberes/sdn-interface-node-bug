# neo4j-relationship-bug

[SDN](https://github.com/spring-projects/spring-data-neo4j) seems to refuse to set all relationships when some relationships are present in an abstract class.

## Requirements

Don't forget to set database credentials in [application.properties](src/main/resources/application.properties).

## Tests

Run [tests](src/test/java/com/example/relationshipbug/CatDogApplicationTests.java) via `mvn clean build` or via an IDE.

