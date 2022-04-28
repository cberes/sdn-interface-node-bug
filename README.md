# sdn-dynamic-labels-bug

[SDN](https://github.com/spring-projects/spring-data-neo4j) is unable to instantiate nodes with multiple levels of
inheritance and a non-empty `@DynamicLabels` field.

For example, say you have super class

    @Node
    public abstract class Animal {
      @DynamicLabels
      private Set<String> labels = new TreeSet<>();
    }

A sub class

    @Node
    public abstract class Feline extends Animal {
    }

And a sub class of the sub class

    @Node
    public class Cat extends Feline {
    }

You can query for instances of the `Cat` sub class only if they do not have a dynamic label


    Cat cat1 = new Cat();
    animalRepository.save(cat1);

    Cat cat2 = new Cat();
    cat2.getLabels().add("Orange");
    animalRepository.save(cat);

    Cat found1 = (Cat) animalRepository.findById(cat.getId()).get(); // this is fine
    Cat found2 = (Cat) animalRepository.findById(cat.getId()).get(); // BeanInstantiationException

The second query fails if the `Feline` sub class is abstract or concrete, though the exception is different.

This example worked correctly in SDN 6.2.1 but it fails with SDN 6.2.4.


## Requirements

Don't forget to set database credentials in [application.properties](src/main/resources/application.properties).

## Tests

Run [tests](src/test/java/com/example/relationshipbug/DynamicLabelsTest.java) via `mvn clean install` or via an IDE.

