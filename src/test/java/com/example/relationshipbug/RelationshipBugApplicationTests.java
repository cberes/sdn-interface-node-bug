package com.example.relationshipbug;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RelationshipBugApplicationTests {
    private final AddressRepository addressRepository;
    private final BankRepository bankRepository;
    private final PersonRepository personRepository;

    @Autowired
    RelationshipBugApplicationTests(AddressRepository addressRepository,
                                    BankRepository bankRepository,
                                    PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.bankRepository = bankRepository;
        this.personRepository = personRepository;
    }

    @BeforeEach
    void setup() {
        personRepository.deleteAll();
        bankRepository.deleteAll();
        addressRepository.deleteAll();
    }

    @Test
    void saveRichPerson() {
        Address address = addressRepository.save(Address.builder()
                .street("123 Main St")
                .city("Walla Walla")
                .state("Washington")
                .build());
        Bank bank = bankRepository.save(Bank.builder().name("Good Bank").build());
        RichPerson person = new RichPerson();
        person.setBank(bank);
        person.setActive(true);
        person.setAge(30);
        person.setName("Example");
        person.setExcludedFromProjection("This is excluded");
        person.setAddress(address);
        personRepository.save(person);

        RichPerson found = (RichPerson) personRepository.findById(person.getId()).get();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(found.getAddress()).isNotNull();
        softly.assertThat(found.getBank()).isNotNull();
        softly.assertAll();
    }

    @Test
    void savePerson() {
        Address address = addressRepository.save(Address.builder()
                .street("123 Main St")
                .city("Walla Walla")
                .state("Washington")
                .build());
        Person person = new Person();
        person.setActive(true);
        person.setAge(30);
        person.setName("Example");
        person.setExcludedFromProjection("This is excluded");
        person.setAddress(address);
        personRepository.save(person);

        Person found = personRepository.findById(person.getId()).get();
        assertThat(found.getAddress()).isNotNull();
    }
}
