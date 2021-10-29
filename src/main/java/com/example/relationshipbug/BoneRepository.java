package com.example.relationshipbug;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BoneRepository extends Neo4jRepository<Bone, String> {
}
