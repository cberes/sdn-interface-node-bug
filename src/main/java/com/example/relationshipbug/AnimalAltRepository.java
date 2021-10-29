package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AnimalAltRepository extends Neo4jRepository<AnimalAlt<?>, String> {
}
