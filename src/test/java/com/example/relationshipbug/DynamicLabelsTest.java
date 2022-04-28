package com.example.relationshipbug;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DynamicLabelsTest {
    private final AnimalRepository animalRepository;

    @Autowired
    DynamicLabelsTest(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @BeforeEach
    void setup() {
        animalRepository.deleteAll();
    }

    @Test
    void saveCat() {
        Cat cat = new Cat();
        cat.setName("Smoky");
        animalRepository.save(cat);

        Cat found = (Cat) animalRepository.findById(cat.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).as("name").isNotEmpty();
        softly.assertThat(found.getLabels()).as("labels").isEmpty();
        softly.assertAll();
    }

    @Test
    void saveCatWithDynamicLabel() { // this will fail
        Cat cat = new Cat();
        cat.setName("Bones");
        cat.getLabels().add("Siamese");
        animalRepository.save(cat);

        Cat found = (Cat) animalRepository.findById(cat.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).as("name").isNotEmpty();
        softly.assertThat(found.getLabels()).as("labels").contains("Siamese");
        softly.assertAll();
    }

    @Test
    void saveDog() {
        Dog dog = new Dog();
        dog.setName("Rufus");
        animalRepository.save(dog);

        Dog found = (Dog) animalRepository.findById(dog.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).as("name").isNotEmpty();
        softly.assertThat(found.getLabels()).as("labels").isEmpty();
        softly.assertAll();
    }

    @Test
    void saveDogWithDynamicLabel() { // this will fail
        Dog dog = new Dog();
        dog.setName("Rover");
        dog.getLabels().add("PitBull");
        animalRepository.save(dog);

        Dog found = (Dog) animalRepository.findById(dog.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).as("name").isNotEmpty();
        softly.assertThat(found.getLabels()).as("labels").contains("PitBull");
        softly.assertAll();
    }

    @Test
    void saveBaseDogWithDynamicLabel() {
        BaseDog dog = new BaseDog();
        dog.setName("Chester");
        dog.getLabels().add("PitBull");
        animalRepository.save(dog);

        BaseDog found = (BaseDog) animalRepository.findById(dog.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).as("name").isNotEmpty();
        softly.assertThat(found.getLabels()).as("labels").contains("PitBull");
        softly.assertAll();
    }
}
