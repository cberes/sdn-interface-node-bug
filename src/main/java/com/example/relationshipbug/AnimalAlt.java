package com.example.relationshipbug;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Node
public abstract class AnimalAlt<T extends BaseEntity<T>> extends BaseEntity<AnimalAlt<T>> {
    private String name;

    @Relationship("CARED_FOR_BY")
    private Person person;

    public abstract T getToy();
}
