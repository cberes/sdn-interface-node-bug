# sdn-interface-node-bug

[SDN](https://github.com/spring-projects/spring-data-neo4j) instantiates the wrong type depending on the order that nodes are saved.

For example, say you have this weird type hierarchy

    @Node
    public abstract class Animal {
    }

    @Node
    public interface Cat {
    }

    // No Node annotation!
    public class DomesticCat extends Animal implements Cat {
    }

    @Node
    public class Tiger extends Animal implements Cat {
    }

If you save and query for a `Tiger`, then save and query for a `DomesticCat`, the second node will be a `Tiger` instead

    Tiger tiger = new tiger();
    animalRepository.save(tiger);

    Tiger found1 = (Tiger) animalRepository.findById(tiger.getId()).get();

    DomesticCat cat = new DomesticCat();
    animalRepository.save(cat);

    // error: found2 is a Tiger
    DomesticCat found2 = (DomesticCat) animalRepository.findById(cat.getId()).get();

If you add `@Node` to `DomesticCat` or save and query in a different order, there are no errors.

This example worked correctly in SDN 6.2.1 but it fails with SDN 6.2.4.

## Requirements

Don't forget to set database credentials in [application.properties](src/main/resources/application.properties).

## Tests

Run [tests](src/test/java/com/example/sdnbug/SaveTigerThenCatTest.java) via `mvn clean test -Dtest=SaveTigerThenCatTest` or via an IDE.

If you run `mvn clean test`, the tests may run in a different order, which may allow all of them to succeed.

