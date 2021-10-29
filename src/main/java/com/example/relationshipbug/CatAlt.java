package com.example.relationshipbug;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Getter
@Setter
@Node
public class CatAlt extends AnimalAlt<Catnip> {

    @Relationship("PLAYS_WITH")
    private Catnip toy;
}
