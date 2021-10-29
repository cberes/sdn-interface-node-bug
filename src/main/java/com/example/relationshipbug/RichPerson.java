package com.example.relationshipbug;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Node
public class RichPerson extends Person {
    @Relationship("BANKS_AT")
    private Bank bank;
}
