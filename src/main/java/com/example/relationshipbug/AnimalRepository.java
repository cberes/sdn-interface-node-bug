package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AnimalRepository extends Neo4jRepository<Animal, String> {
}
