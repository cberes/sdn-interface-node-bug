package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AddressRepository extends Neo4jRepository<Address, String> {
}
