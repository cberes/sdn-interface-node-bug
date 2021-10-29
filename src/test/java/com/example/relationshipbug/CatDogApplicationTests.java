package com.example.relationshipbug;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CatDogApplicationTests {
    private final AnimalRepository animalRepository;
    private final AnimalAltRepository animalAltRepository;
    private final BoneRepository boneRepository;
    private final CatnipRepository catnipRepository;
    private final PersonRepository personRepository;
    private final DogRepository dogRepository;
    private final DogAltRepository dogAltRepository;

    @Autowired
    CatDogApplicationTests(AnimalRepository animalRepository,
                           AnimalAltRepository animalAltRepository,
                           BoneRepository boneRepository,
                           CatnipRepository catnipRepository,
                           PersonRepository personRepository,
                           DogRepository dogRepository,
                           DogAltRepository dogAltRepository) {
        this.animalRepository = animalRepository;
        this.animalAltRepository = animalAltRepository;
        this.boneRepository = boneRepository;
        this.catnipRepository = catnipRepository;
        this.personRepository = personRepository;
        this.dogRepository = dogRepository;
        this.dogAltRepository = dogAltRepository;
    }

    @BeforeEach
    void setup() {
        animalRepository.deleteAll();
        animalAltRepository.deleteAll();
        catnipRepository.deleteAll();
        boneRepository.deleteAll();
        personRepository.deleteAll();
    }

    @Test
    void saveCat() {
        Person alice = new Person();
        alice.setName("Alice");
        personRepository.save(alice);

        Catnip catnip = catnipRepository.save(new Catnip());
        Cat cat = new Cat();
        cat.setName("Smoky");
        cat.setPerson(alice);
        cat.setToy(catnip);
        animalRepository.save(cat);

        Cat found = (Cat) animalRepository.findById(cat.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).isNotEmpty();
        softly.assertThat(found.getPerson()).isNotNull();
        softly.assertThat(found.getToy()).isNotNull();
        softly.assertAll();
    }

    @Test
    void saveDog() {
        Person bob = new Person();
        bob.setName("Bob");
        personRepository.save(bob);

        Bone bone = boneRepository.save(new Bone());
        Dog dog = new Dog();
        dog.setName("Rufus");
        dog.setPerson(bob);
        dog.setToy(bone);
        animalRepository.save(dog);

        Dog found = (Dog) animalRepository.findById(dog.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).isNotEmpty();
        softly.assertThat(found.getPerson()).isNotNull();
        softly.assertThat(found.getToy()).isNotNull();
        softly.assertAll();
    }

    @Test
    void saveCatAlt() {
        Person alice = new Person();
        alice.setName("Alice");
        personRepository.save(alice);

        Catnip catnip = catnipRepository.save(new Catnip());
        CatAlt cat = new CatAlt();
        cat.setName("Smoky");
        cat.setPerson(alice);
        cat.setToy(catnip);
        animalAltRepository.save(cat);

        CatAlt found = (CatAlt) animalAltRepository.findById(cat.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).isNotEmpty();
        softly.assertThat(found.getPerson()).isNotNull();
        softly.assertThat(found.getToy()).isNotNull();
        softly.assertAll();
    }

    @Test
    void saveDogAlt() {
        Person bob = new Person();
        bob.setName("Bob");
        personRepository.save(bob);

        Bone bone = boneRepository.save(new Bone());
        DogAlt dog = new DogAlt();
        dog.setName("Rufus");
        dog.setPerson(bob);
        dog.setToy(bone);
        animalAltRepository.save(dog);

        DogAlt found = (DogAlt) animalAltRepository.findById(dog.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getName()).isNotEmpty();
        softly.assertThat(found.getPerson()).isNotNull();
        softly.assertThat(found.getToy()).isNotNull();
        softly.assertAll();
    }
}
