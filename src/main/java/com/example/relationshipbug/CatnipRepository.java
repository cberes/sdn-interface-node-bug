package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CatnipRepository extends Neo4jRepository<Catnip, String> {
}
