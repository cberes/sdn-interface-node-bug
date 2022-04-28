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
    void saveCatWithDynamicLabel() {
        Cat cat = new Cat();
        cat.setName("Bones");
        cat.getLabels().add("Siamese");
        cat.getLabels().add("MyOrangeCat");
        animalRepository.save(cat);

        Cat found = (Cat) animalRepository.findById(cat.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).as("name").isNotEmpty();
        softly.assertThat(found.getLabels()).as("labels").contains("Siamese");
        softly.assertAll();
    }
}
