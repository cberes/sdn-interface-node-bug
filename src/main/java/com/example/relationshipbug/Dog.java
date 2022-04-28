package com.example.relationshipbug;

import org.springframework.data.neo4j.core.schema.Node;

@Node(primaryLabel = "TheDog")
public class Dog extends Animal {
}
