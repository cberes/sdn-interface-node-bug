package com.example.sdnbug;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SaveTigerThenCatTest {
    private final AnimalRepository animalRepository;

    @Autowired
    SaveTigerThenCatTest(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @BeforeEach
    void setup() {
        animalRepository.deleteAll();
    }

    @Test
    void test() {
        Tiger tiger = new Tiger();
        tiger.setName("Claws");
        animalRepository.save(tiger);

        Cat foundTiger = (Cat) animalRepository.findById(tiger.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(foundTiger).as("type").isInstanceOf(Tiger.class);
        softly.assertThat(((Tiger) foundTiger).getName()).as("name").isNotEmpty();
        softly.assertAll();

        DomesticCat cat = new DomesticCat();
        animalRepository.save(cat);

        Cat foundCat = (Cat) animalRepository.findById(cat.getId()).get();
        assertThat(foundCat).as("type").isInstanceOf(DomesticCat.class);
    }
}
