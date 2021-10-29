package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BankRepository extends Neo4jRepository<Bank, String> {
}
