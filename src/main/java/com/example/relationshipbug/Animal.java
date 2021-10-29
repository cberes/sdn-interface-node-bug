package com.example.relationshipbug;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Node
public abstract class Animal<T extends BaseEntity<T>> extends BaseEntity<Animal<T>> {
    private String name;

    @Relationship("PLAYS_WITH")
    private T toy;

    @Relationship("CARED_FOR_BY")
    private Person person;
}
