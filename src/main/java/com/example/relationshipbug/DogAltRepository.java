package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DogAltRepository extends Neo4jRepository<DogAlt, String> {
}
