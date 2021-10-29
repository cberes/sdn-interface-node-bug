package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<Person, String> {
    List<PersonProjection> findAllByAge(int age);

}
