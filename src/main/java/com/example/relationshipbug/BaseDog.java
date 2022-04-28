package com.example.relationshipbug;

import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "MyBaseDog")
public class BaseDog extends Animal {
}
